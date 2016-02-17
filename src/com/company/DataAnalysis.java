package com.company;

import java.util.*;

/**
 * Created by Kayla on 2/15/2016.
 */
public class DataAnalysis {
   /**
    * The numberSNV function iterates through all records and checks for the INDEL keyword in the info field
    * if INDEL is not present, the number of SNVs is incremented
    * @param records
    * @return The total number of SNVs present in the set of records
    */
   public static long numberSNV(ArrayList<Record> records) {
      long snvs = 0;
      for (Record r: records) {
         if (!r.info.contains("INDEL")) {
            snvs ++;
         }
      }
      return snvs;
   }

   /**
    * The numberINDEL function iterates through all records and checks for the INDEL keyword in the info field
    * if INDEL is present, the number of INDELs is incremented
    * @param records
    * @return The total number of INDELs present in the set of records
    */
   public static long numberINDEL(ArrayList<Record> records) {
      long indels = 0;
      for (Record r: records) {
         if (r.info.contains("INDEL")) {
            indels ++;
         }
      }
      return indels;
   }

   /**
    * The meanDepth method iterates through all the records and checks for the key word INDEL in the info field
    * if INDEL is present, the record is ignored
    * the mean read depth is then found on only the SNV records and returned
    * @param records
    * @return The mean read depth of all SNV records
    */
   public static float meanDepth(ArrayList<Record> records) {
      float reads = 0;
      float counter = 0;
      for (Record r: records) {
         for (String s: r.infoSplit) {
            if (!r.info.contains("INDEL") && s.substring(0,2).equals("DP") && !s.substring(2,3).equals("4")) {
               int read = Integer.parseInt(s.substring(3,s.length()));
               reads+= read;
               counter++;
            }
         }
      }
      return reads / counter;
   }

   /**
    * The chromSNVs method iterates through the set of records
    * a LinkedHashMap is used to store each chromosome and the number of SNVs found on it
    * the set of keys are then iterated through to print out the chromosome and its number of SNVs
    * @param records
    */
   public static void chromSNVs(ArrayList<Record> records) {
      LinkedHashMap<String, Integer> chromosomeSNVs = new LinkedHashMap<>();
      for (Record r : records) {
         if (!r.info.contains("INDEL") && chromosomeSNVs.containsKey(r.chrom)) {
            int temp = chromosomeSNVs.get(r.chrom);
            chromosomeSNVs.replace(r.chrom, ++temp);
         }
         else if (!r.info.contains("INDEL")){
            chromosomeSNVs.put(r.chrom, 1);
         }
      }
      Set set = chromosomeSNVs.entrySet();
      Iterator i = set.iterator();
      while(i.hasNext()) {
         Map.Entry temp = (Map.Entry)i.next();
         System.out.print("Chromosome " + temp.getKey() + " has ");
         System.out.println(temp.getValue() + " SNVs");
      }
   }
}
