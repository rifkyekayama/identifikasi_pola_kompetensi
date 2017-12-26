/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pola_kompetensi;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Supandi Doank
 */
public class CleaningData {
    
    public ArrayList<String[]> dataAsli = new ArrayList<String[]>();
    
    public CleaningData(){
        
    }
    
    public ArrayList<String[]> parseFile(ArrayList<String> data){
        ArrayList<String[]> result = new ArrayList<String[]>();
        String separator = ",";
        int i, j;
        
        for(i=0;i<data.size();i++){
            String[] parsingFile = data.get(i).split(separator);
            result.add(parsingFile);
        }
        return result;
    }
    
    public ArrayList<String[]> readFile(String file){
        ArrayList<String[]> result = new ArrayList<String[]>();
        String line = "";
        String separator = ",";
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            //System.out.println("proses baca file.....");
            while ((line = br.readLine()) != null){
                String temp = "";
                String[] parsingFile = line.split(separator);
                result.add(parsingFile);
            }
        }catch(FileNotFoundException ex){
            System.err.println("File tidak ditemukan ");
            ex.printStackTrace();
        }catch(IOException ex){
            System.err.println("File tidak ditemukan ");
        }finally{
            if(br != null){
                try{
                    br.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public ArrayList<String> generateTransaksi(ArrayList<String[]> dataAsli, String kategori) {
        ArrayList<String> result = new ArrayList<String>();
        int i, j, k;
        boolean isFind = false;
        
        for(i=0;i<dataAsli.size();i++){
            if(kategori != "Semua"){
                if(dataAsli.get(i)[0].equals(kategori)){
                    for(j=0;j<dataAsli.get(i).length;j++){
                        if(!result.contains(dataAsli.get(i)[j].trim())){
                            result.add(dataAsli.get(i)[j].trim());
                        }
                    }
                }
            }else if(kategori == "Semua"){
                for(j=0;j<dataAsli.get(i).length;j++){
                    if(!result.contains(dataAsli.get(i)[j].trim())){
                        result.add(dataAsli.get(i)[j].trim());
                    }
                }
            }
        }
        
        return result;
    }
}
