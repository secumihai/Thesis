package com.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class OpenFile {
    private static GetElement getElement;
    private static File[] files;
    private static String name;
    private static List<String> data;
    public OpenFile(File [] files) {
        this.files = files;
        data = new ArrayList<>();
    }

    public static List<String> readFile() throws Exception {
        for (int in = 0; in < files.length; in++) {
            name=getName(files[in].getPath());
            //System.out.println(name);
            data.add(name);
            BufferedReader reader = new BufferedReader(new FileReader(files[in].getPath()));
            int counter=0;
            String str;
            while ((str = reader.readLine()) != null){
                str= str.trim();
                str=str.replaceAll("\\s+","@");
                if(counter>=8){
                    String s[]=str.split("@");
                    for(int i=0;i<s.length;i++){
                        if(counter==8 && i==1){
                            //System.out.print("- "+s[i]+" - ");
                            data.add(s[i]);
                        }
                        else if(counter>8 && i==0){
                            //System.out.print("- "+s[i]+" - ");
                            data.add(s[i]);
                        }
                        else if(counter>=8 && i==s.length-1){
                            double numDouble = Double.parseDouble(s[i]);
                            //System.out.printf(Locale.US,"%.2f\n",numDouble);
                            data.add(s[i]);
                            //System.out.println();
                        }
                    }
                }
                counter++;
            }
            data.add("@");
            reader.close();

        }
        return data;
    }


    public static String getName(String path){
        String name=new String(path);
        name=name.trim();
        String [] Name = name.split("\\\\");
        name=Name[Name.length-1];
        name=name.replaceAll("[a-zA-Z]","").replaceAll("_","");
        if(path.contains("metal")){
            name+="\nAnaliza elementală a metalului:";
        }else if(path.contains("piatr") || path.contains("pietr")){
            name="Analiza elementală a pietrei:";
        }
        else if(path.contains("perl")){
            name="Analiza elementală a perlei:";
        }else{
            name+="\nAnaliza elementală:";
        }
        return name;
    }

}

