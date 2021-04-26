package com.backend;

import java.util.*;

public class DataSort {
    private GetElement getElement;
    private Map<String,String> map;
    private Map<Double, String> sortedData;
    private List<String> opendFile;
    private List<String> stringData;
    private List<Double> doubleData;
    private List<String> nameData;
    public static List<Map<Double , String>> listOfMapData;

    public List<String> getNameData() {
        return nameData;
    }

    public DataSort() {
        getElement = new GetElement();
        sortedData = new TreeMap<Double, String>(Collections.reverseOrder());
        stringData = new ArrayList<>();
        doubleData = new ArrayList<>();
        nameData = new ArrayList<>();
        listOfMapData = new ArrayList<Map<Double,String>>();
    }

    public List<Map<Double, String>> sorting() throws Exception {
        map = getElement.getMapOfSymbolAndElements();
        opendFile = OpenFile.readFile();

        for (int i = 0; i < opendFile.size(); i++) {
            if(i%2==0){
                if(!opendFile.get(i).contains("Analiza")) {
                    doubleData.add(round(Double.parseDouble(opendFile.get(i)),2));
                }else{
                    nameData.add(opendFile.get(i));
                }
            }else {
                if(opendFile.get(i).equals("@")){
                    doubleData.add(null);
                    stringData.add(opendFile.get(i));
                }else {
                    for (Map.Entry<String, String> pair : map.entrySet()) {
                        String key = pair.getKey();
                        String value = pair.getValue();
                        if (opendFile.get(i).equals(key)) {
                            stringData.add("- " + value + " - ");
                        }
                    }
                }
            }
        }

        for(int i=0;i<stringData.size();i++){
            if(stringData.get(i).contains("@")){
                listOfMapData.add(sortedData);
                sortedData= new TreeMap<Double, String>(Collections.reverseOrder()); ;
            }
            else{
                sortedData.put(doubleData.get(i), stringData.get(i));
            }

        }

        return listOfMapData;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
