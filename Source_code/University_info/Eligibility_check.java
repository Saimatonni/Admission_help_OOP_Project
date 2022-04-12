package com.example.admission_help.universityInfo;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import com.example.admission_help.Student.student;


public class Eligibility_check implements Eligibility_In{
   student obj=new student();
   public String Inputcut(String s){
      String temp="";
      int flag=1,n=s.length();
      try {
         for(int i=0;i<n;i++)
         {
            char ss=s.charAt(i);
            if(ss!=',') temp+=ss;
            if(ss==','|| i+1==n)
            {
               if(flag==3)
                  obj.setSsc_gpa(Double.valueOf(temp));
               else if(flag==4)
                  obj.setsscGroup(temp);
               else if(flag==1)
                  obj.setHsc_gpa(Double.valueOf(temp));
               else obj.sethscGroup(temp);
               temp="";
               flag++;
            }
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
      System.out.println(obj.ssc_gpa+ " "+obj.ssc_group+" "+ obj.hsc_gpa+" "+ obj.hsc_group);
      return InputCheck(obj);
   }
   public String InputCheck(student obj)
   {
      if((obj.hsc_gpa>=0.00 && obj.hsc_gpa<=5.00 ) && (obj.ssc_gpa>=0.00 && obj.ssc_gpa<= 5.00) &&
              (obj.ssc_group.equals("Science")|| obj.ssc_group.equals("Arts") || obj.ssc_group.equals("Commerce"))
              && (obj.hsc_group.equals("Science")|| obj.hsc_group.equals("Arts") || obj.hsc_group.equals("Commerce"))) {
         System.out.println("YES");
         return Eligible_List(obj);
      }
      else return "Please Input In right Formate. Everything should be separated by coma\n";

   }
   public String Eligible_List(student obj)
   {
      String ans="";
      try {
         FileReader fr = new FileReader("Read.txt");
         BufferedReader read = new BufferedReader(fr);
         String line = read.readLine();
         String temp="";
         student obj2=new student();
         int flag = 1,n=line.length(),i;
         //System.out.println(line);
         while (line!=null) {
            n = line.length();
            for (i = 0; i < n; i++) {
               char ch = line.charAt(i);
               if (ch != ' ') temp += ch;
               else if (ch == ' ' ) {
                  if (flag == 1)
                     obj2.setSsc_gpa( Double.valueOf(temp));
                  else if (flag == 2)
                     obj2.setsscGroup( temp);
                  else if (flag == 3)
                     obj2.setHsc_gpa(Double.valueOf(temp));
                  else    obj2.sethscGroup( temp);
                  temp = "";
                  flag++;
               }
               if (flag == 5) {
                  //System.out.println(HSC_Steam+" "+SSC_Steam+" "+Sg+" "+hg);
                  if ( (obj2.hsc_group.equals("All") || (obj2.hsc_group.equals(obj.hsc_group) && obj2.ssc_group.equals(obj.ssc_group))) && obj.ssc_gpa >= obj2.ssc_gpa  && obj.hsc_gpa>=obj2.hsc_gpa) {
                     temp = "";
                     while (i < n) {
                        ch = line.charAt(i);
                        temp += ch;
                        i++;
                     }
                     ans+=temp;
                     ans+="\n";
                  }
                  else System.out.println("No");
                  break;
               }
            }
            line = read.readLine();
            flag=1;
            System.out.println(line);
            temp="";
         }
         read.close();
      }
      catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
      if(ans.equals("")) ans="Sorry You are not elligible for any versity";
      return ans;
   }
}