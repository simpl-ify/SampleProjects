package com.simplify.regLookAround;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegLookAround {

    private static final String[] SAMPLE_STR = new String[]{
            "http://www.linkeverything.com",
            "https://mail.linkeverything.com",
            "ftp://ftp.linkeverything.com"
    };
    private static final String[] SAMPLE_STR2 = new String[]{
            "ABC01: $23.45",
            "HGG42: $5.31",
            "CFMX1: $899.00",
            "XTC99: $69.96",
            "Total items found: 4"
    };

    public static void main(String[] args) {

        sample();

        Pattern pattern;
        Matcher matcher;

        System.out.println("# 전방탐색 - 찾는 단어 포함 - .+(:)");

        pattern = Pattern.compile(".+(:)");
        for(String str : SAMPLE_STR){
            matcher = pattern.matcher(str);
            if(matcher.find()){
                System.out.println(str + " > " + matcher.group());
            }
        }

        System.out.println();
        System.out.println("# 전방탐색 - 찾는 단어 포함하지 않음 - .+(?=:)");

        pattern = Pattern.compile(".+(?=:)");
        for(String str : SAMPLE_STR){
            matcher = pattern.matcher(str);
            if(matcher.find()){
                System.out.println(str + " > " + matcher.group());
            }
        }

        System.out.println();
        System.out.println("# 후방탐색 - (?<=\\$)[0-9.]+");

        pattern = Pattern.compile("(?<=\\$)[0-9.]+");
        for(String str : SAMPLE_STR2){
            matcher = pattern.matcher(str);
            if(matcher.find()){
                System.out.println(str + " > " + matcher.group());
            }
        }

        System.out.println();
        System.out.println("# 응용하기");

        String xmlSample = "<HEAD>\n" +
                "<TITLE>Simplify linkeverything</TITLE>\n" +
                "</HEAD>";
        pattern = Pattern.compile("(?<=\\<[tT][iI][tT][lL][eE]\\>).*(?=\\<\\/[tT][iI][tT][lL][eE]\\>)");
        matcher = pattern.matcher(xmlSample);
        if(matcher.find()){
            System.out.println(xmlSample);
            System.out.println(" > " + matcher.group());
        }

        System.out.println();
        System.out.println("# 금액만 추출");

        String negativeSample = "I paid $30 for 100 apples,\n" +
                "50 oranges, and 60 pears.\n" +
                "I saved $5 on this order.";
        pattern = Pattern.compile("(?<=\\$)\\d+");
        matcher = pattern.matcher(negativeSample);
        System.out.println(negativeSample);
        while(matcher.find()){
            System.out.println(" > " + matcher.group());
        }

        System.out.println();
        System.out.println("# 수량만 추출");

        pattern = Pattern.compile("\\b(?<!\\$)\\d+\\b");
        matcher = pattern.matcher(negativeSample);
        System.out.println(negativeSample);
        while(matcher.find()){
            System.out.println(" > " + matcher.group());
        }




    }

    private static void sample() {

        Pattern pattern = Pattern.compile(":");
        Matcher matcher = pattern.matcher("T:EST");
        System.out.println(matcher.find());
        System.out.println();

    }
}
