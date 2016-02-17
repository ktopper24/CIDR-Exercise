package com.company;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Record> records = FileReader.readData("C://Programming/bigSample.vcf");
        System.out.println(DataAnalysis.numberSNV(records));
        System.out.println(DataAnalysis.numberINDEL(records));
        System.out.println(DataAnalysis.meanDepth(records));
        DataAnalysis.chromSNVs(records);

    }
}
