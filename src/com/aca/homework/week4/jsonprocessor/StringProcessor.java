package com.aca.homework.week4.jsonprocessor;

public class StringProcessor {
    private String json;

    public StringProcessor(String json){
        this.json = json;
    }

    public String getValue(String key){
        String apostrophe = "\"";
        int firstId = getKeyFirstId(key,this.json);
        int secondId = firstId;
        while (!"\"".equals(json.substring(secondId,secondId + 1))) {
            secondId++;
        }
        return json.substring(firstId,secondId);
    }

    private int getKeyFirstId(String key, String json){

        String apostrophe = "\"";
        int firstId = 0;
        int secondId = 0;

        for (int i = 0; i < json.length() ; i++) {
            boolean checkApostrophe = json.substring(i, i + 1).equals(apostrophe);
            if (checkApostrophe && !":".equals(json.substring(i + 1, i + 2))
                    && !",".equals(json.substring(i + 1, i + 2)))
                firstId = i + 1;
            if (checkApostrophe && json.substring(i + 1, i + 2).equals(":")){
                secondId = i;
                if(json.substring(firstId,secondId).equals(key))
                    return secondId+4;
            }

        }
        throw new IllegalArgumentException("Not found such key");
    }

}
