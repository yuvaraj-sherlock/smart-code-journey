package com.codejourney.core;

public class SentenceReverse {

    public static String reverseSentence(String sentence){
        String inputSentence = sentence.trim();
        String[] words = inputSentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int index=words.length-1; index>=0; index--){
            sb.append(words[index]+" ");
        }
        return sb.toString().trim();
    }
}