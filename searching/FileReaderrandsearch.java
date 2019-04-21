package projc;
import java.io.*;
import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;

class Filereaderr {
 
    public static void main(String args[])throws Exception
   {
    	 String s;
   FileReader fr=new FileReader("ankit.txt");
   BufferedReader br=new BufferedReader(fr);
  Scanner sc=new Scanner(System.in);
   int	count=0;
   String keyword=sc.nextLine();
   while ((s=br.readLine())!=null){
      if(s.contains(keyword)) {
     count++;
      }
     
   }
   System.out.println("found  times : "+count);
   }
}