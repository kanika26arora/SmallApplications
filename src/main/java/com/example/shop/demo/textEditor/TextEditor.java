package com.example.shop.demo.textEditor;

public class TextEditor {

    StringBuilder stringBuilder;
    int cursor;

    public TextEditor(){
        stringBuilder = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text){

        String left = stringBuilder.substring(0, cursor);
        String right = stringBuilder.substring(cursor, stringBuilder.length());
        stringBuilder.setLength(0);
        stringBuilder.append(left).append(text).append(right);
        cursor = cursor + text.length();

    }

    public int deleteText(int k){
        int min = Math.max(cursor-k, 0);
        stringBuilder.replace(min, cursor, "");
        int r = cursor-min;
        cursor=min;
        return r;
    }

    public String cursorLeft(int k){

        cursor = Math.max(cursor-k, 0);

        if(cursor-10>=0){
            return stringBuilder.substring(cursor-10, cursor);
        } else{
            return stringBuilder.substring(0, cursor);
        }

    }

    public String cursorRight(int k){

        cursor = Math.min(cursor+k, stringBuilder.length());

        if(cursor-10>=0){
            return stringBuilder.substring(cursor-10, cursor);
        } else{
            return stringBuilder.substring(0, cursor);
        }
    }
}
