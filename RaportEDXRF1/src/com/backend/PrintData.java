package com.backend;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.awt.BorderLayout.CENTER;

public class PrintData{
    private DataSort dataSort;
    private List<Map<Double , String>> listOfMapData;
    private List<String> nameData;
    private String pathSave;
    private CompressImages image;



    public PrintData(String pathSave){
        this.pathSave=pathSave;
        dataSort = new DataSort();
        image= new CompressImages();
    }



    public void showData(String data [],String imageNumber[],String [] imagesDescription, String [] imageDatas) throws Exception {
        listOfMapData=dataSort.sorting();
        nameData=dataSort.getNameData();
        String [] wordShortCuts ={"${raportNumber}","${dateOfRaport}","${dateOfRaportFooter}","${client}","${adress}",
                                  "${sampleNumber}","${sealNumber}","${getSample}","${initialDate}",
                                   "${finalDate}","${documents}","${conclusion}","${inspector}","${degree}","${speciality}","${age}"};
        XWPFDocument doc = new XWPFDocument(OPCPackage.open("D:\\Model.docx"));

        // inscrierea în text
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    for (int i = 0; i < wordShortCuts.length; i++) {
                        if(text != null && text.contains(wordShortCuts[i])){
                            String[] lines = data[i].split("\r\n|\r|\n");
                            if(lines.length>1) {
                                    text = text.replace(wordShortCuts[i], lines[0]);
                                for (int j = 1; j <lines.length ; j++) {
                                    r.addBreak();
                                    r.setText(lines[j]);
                                }

                            }else {
                                text = text.replace(wordShortCuts[i], data[i]);
                            }
                        }
                        r.setText(text,0);
                    }

                }
            }
        }
        //inscrierea în footer
        for (XWPFFooter footer : doc.getFooterList()) {
            for (XWPFParagraph paragraph : footer.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    for (int i = 0; i < wordShortCuts.length; i++) {
                        if(text != null && text.contains(wordShortCuts[i])){
                                text = text.replace(wordShortCuts[i], data[i]);
                        }
                        run.setText(text,0);
                    }

                }
            }
        }

        //inscrierea in tabelul cu elemente

        int counter = 0;
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            if(counter==3){
                                String text = r.getText(0);
                                for (int i = 0; i < wordShortCuts.length; i++) {
                                    if(text != null && text.contains(wordShortCuts[i])){
                                        text = text.replace(wordShortCuts[i], data[i]);
                                    }
                                    r.setText(text,0);
                                }
                            }
                            else if (counter == 2) {
                                String text = r.getText(0);
                                if (text != null && text.contains("${datas}")) {
                                    text = text.replace("${datas}", "");
                                    r.setText(text, 0);
                                    for (int j = 0; j < nameData.size(); j++) {
                                        if (nameData.get(j).contains("\n")) {
                                            String[] lines = nameData.get(j).split("\n");
                                            if(j>0) {
                                              //  r.setText("____________________");
                                                r.addBreak();
                                            }
                                            r.setText("            "+lines[0]); // set first line into XWPFRun
                                            for(int k=1;k<lines.length;k++){
                                                // add break and insert new text
                                                r.addBreak();
                                                r.setText(lines[k]);
                                            }
                                        } else {
                                            r.addBreak();
                                            r.setText(nameData.get(j));
                                        }
                                        r.addBreak();
                                        double sum=0;
                                        int count=0;
                                        for (Map.Entry<Double, String> pair : listOfMapData.get(j).entrySet()) {
                                            Double value = pair.getKey();
                                            String element = pair.getValue();
                                            if(count<listOfMapData.get(j).size()-1) {
                                                sum += value;
                                                r.setText(element);
                                                String strDouble = String.format(Locale.US, "%.2f", value);
                                                r.setText(strDouble);
                                                r.addBreak();
                                            }
                                            else{
                                                r.setText(element);
                                                Double key2= 100.0-sum;
                                                String strDouble = String.format(Locale.US, "%.2f", key2);
                                                r.setText(strDouble);
                                                r.addBreak();
                                            }
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

            counter++;
        }


        // primul tabel introducem imaginile
        int counterTable = 0;
        XWPFTable table = doc.getTableArray(1);
        for (int i = 0; i < imageDatas.length; i++) {
            //table.createRow();
            XWPFTableRow tableRowTwo = table.createRow();
            tableRowTwo.getCell(0).setText((i+1)+".");
            tableRowTwo.getCell(1).setText("${sampleN}"+i);
            tableRowTwo.getCell(2).setText("${Fotos}"+i);
            tableRowTwo.getCell(3).setText("${description}"+i);
        }




        doc.write(new FileOutputStream("output.docx"));
        doc = new XWPFDocument(OPCPackage.open("output.docx"));


        for (XWPFTable tbl : doc.getTables()) {
            for (int i = 0; i < imageDatas.length; i++) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                if (counterTable == 1) {
                                    String text = r.getText(0);
                                    if(text != null && text.equals((i+1)+".")){
                                        r.setBold(true);
                                    }
                                    if (text != null && text.equals("${sampleN}"+ i)) {
                                        text = text.replace("${sampleN}"+ i, imageNumber[i]);
                                        r.setText(text, 0);
                                        r.setBold(true);
                                    }
                                    if(text != null && text.equals("${Fotos}"+i)) {
                                        text = text.replace("${Fotos}"+i, "");
                                        r.setText(text, 0);
                                        File file = image.compress(imageDatas[i]);
                                        String imgFile = file.getAbsolutePath();
                                        FileInputStream fis = new FileInputStream(imgFile);
                                        XWPFPicture picture = r.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, "Name", Units.pixelToEMU(200), Units.pixelToEMU(200));
                                        fis.close();
                                    }
                                    if(text != null && text.equals("${description}"+i)) {
                                        text = text.replace("${description}"+i, "");
                                        String[] lines = imagesDescription[i].split("\r\n|\r|\n");
                                        if (lines.length > 1) {
                                            r.setText(lines[0]);
                                            for (int j = 1; j < lines.length; j++) {
                                                r.addBreak();
                                                r.setText(lines[j]);
                                            }

                                        } else {
                                            r.setText(imagesDescription[i]);
                                        }
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            counterTable++;
        }



        FileOutputStream outStream = new FileOutputStream(pathSave);
        doc.write(outStream);
        outStream.close();
        doc.close();

    }

}
