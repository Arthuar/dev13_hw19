package com.example.dev_hw19.generator;

public class GeneratorNote {
    public static String generate(int count){
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < count; i++) {
            builder.append("('title" + i + "', 'content" +i + "')," +'\n' );
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(GeneratorNote.generate(1000));
    }
}
