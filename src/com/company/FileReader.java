package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kayla on 2/15/2016.
 */
public class FileReader {
   /**
    * The readData method takes in a file path and reads in the lines that do not begin with a #, which indicates they are a record
    * the record is then added to an ArrayList
    * @param file
    * @return An ArrayList of records
    */
   public static ArrayList<Record> readData(String file) {
      ArrayList<Record> records = new ArrayList<Record>();
      try {
         Scanner sc = new Scanner(new File(file));
         while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.substring(0,1).equals("#")) {
               Record temp = new Record(line);
               records.add(temp);
            }
         }
         sc.close();
      }
      catch (Exception e) {
         System.out.print("Error");
      }
      return records;
   }
}
