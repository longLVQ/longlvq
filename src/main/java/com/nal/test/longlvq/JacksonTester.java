package com.nal.test.longlvq;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
   public static void main(String args[]) {
      ObjectMapper mapper = new ObjectMapper();
      try {
         Student student = new Student(1,11,"1ab","Mark");       
         String jsonString = mapper
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(student);
         System.out.println(jsonString);
      }
      catch (IOException e) { 
         e.printStackTrace();
      }   
   }
}
class Student {
	@JsonIgnoreProperties("id")
   public int id;
	@JsonIgnoreProperties("systemId")
   public String systemId;
   public int rollNo;
   public String name;

   Student(int id, int rollNo, String systemId, String name){
      this.id = id;
      this.systemId = systemId;
      this.rollNo = rollNo;
      this.name = name;
   }
}