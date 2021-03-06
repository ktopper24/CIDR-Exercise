package com.company;

/**
 * Created by Kayla on 2/15/2016.
 */

/**
 * A record represents a single genetic variation, each field has a corresponding instance variable
 * The info variable is further split into fields
 */
public class Record {
   public Record(String record) {
      String[] split = record.split("\t");
      this.chrom = split[0];
      this.pos = split[1];
      this. id = split[2];
      this.ref = split[3];
      this.alt = split[4];
      this.qual = split[5];
      this.filter = split[6];
      this.info = split[7];
      this.format = split[8];
      this.HG = split[9];
      this.infoSplit = splitInfo(info);

   }

   /**
    * The splitInfo method split the info field further by semi colons
     * @param info
    * @return An array of key value pairs present in the info field of a record
    */
   public static String[] splitInfo( String info){
      String[] infoSplit = info.split(";");
      return infoSplit;
   }

   public String chrom;
   public String pos;
   public String id;
   public String ref;
   public String alt;
   public String qual;
   public String filter;
   public String info;
   public String format;
   public String HG;
   public String[] infoSplit;

}
