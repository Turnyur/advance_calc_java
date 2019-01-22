/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Turnyur Siy
 */
public class ReadFile {
    public String path ;
    
    public ReadFile(String file_path){
        
    }
    public ReadFile(){
        
    }
    public String OpenFile(String file_path) throws IOException{
       FileReader fr= new FileReader(file_path);
       BufferedReader textReader=new BufferedReader(fr);
       
       int numberOfLines=numberOfLines(file_path);
       String[] textData=new String[numberOfLines];
       String acumulate_textData="";
        for (int i = 0; i < numberOfLines; i++) {
            textData[i]=textReader.readLine();
            acumulate_textData+=textData[i];
        }
       textReader.close();
        return acumulate_textData;
    }
    
    
    
    public int numberOfLines(String file_path) throws IOException{
       FileReader fr= new FileReader(file_path);
       BufferedReader bf=new BufferedReader(fr);
       
       String aLine;
       int numberOfLines=0;
       while((aLine=bf.readLine())!=null){
           
           numberOfLines++;
       }
       
        
     bf.close();
        return numberOfLines;
    }
    
    
}
