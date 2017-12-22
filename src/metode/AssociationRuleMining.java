/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Supandi Doank
 */
public class AssociationRuleMining {
    
    public ArrayList<String[]> sumOfCombination = new ArrayList<String[]>();
    public ArrayList<String[]> rules = new ArrayList<String[]>();
    public ArrayList<HashMap<String, String>> tableTransaction = new ArrayList<HashMap<String, String>>();
    
    public AssociationRuleMining(){
        
    }
    
    public AssociationRuleMining(ArrayList<String[]> sumOfCombination, ArrayList<HashMap<String, String>> tableTransaction){
        this.sumOfCombination = (ArrayList<String[]>)sumOfCombination.clone();
        this.tableTransaction = ( ArrayList<HashMap<String, String>>)tableTransaction.clone();
    }
    
    public void buildRule(){
        int i,j;
        
        ArrayList<String> allLists = new ArrayList<String>();
        
        for(i=0;i<sumOfCombination.size();i++){
            ArrayList<String> keyIndex = new ArrayList<String>(getKeyIndex(sumOfCombination.get(i)));
            allLists = (ArrayList<String>)getAllLists(keyIndex, sumOfCombination.get(i).length-1).clone();
            
            for(j=0;j<allLists.size();j++){
                String[] data = new String[5]; 
                data[0] = allLists.get(j);
                data[1] = getRuleText(allLists.get(j).split(","));
                data[2] = sumOfCombination.get(i)[sumOfCombination.get(i).length-1];
                data[3] = "0";
                data[4] = "0";
                rules.add(data);
            }
        }
        
        countSupport();
        countConfidence();
        
//        for(i=0;i<rules.size();i++){
//            System.out.println(Arrays.deepToString(rules.get(i)));
//        }
    }
    
    public void countSupport() {
        int i,j;
        double totalIndustri = tableTransaction.size();
        
        for(i=0;i<rules.size();i++){
            double totalP = Double.parseDouble(rules.get(i)[2]);
            
            rules.get(i)[3] = Double.toString((totalP/totalIndustri)*100);
        }
    }
    
    public void countConfidence(){
        int i,j;
        
        for(i=0;i<rules.size();i++){
            String[] tmp = rules.get(i)[0].split(",");
            String[] data = new String[tmp.length-1];

            for(j=0;j<data.length;j++){
                data[j] = tmp[j];
            }
            
            double totalP = Double.parseDouble(rules.get(i)[2]);
            double p = (double)getP(data);
            
            rules.get(i)[4] = Double.toString((totalP/p)*100);
        }
    }
    
    public ArrayList<Object[]> getMinimumSupportAndConfidenceLists(ArrayList<String[]> rules, int supportThreshold, int confidenceThreshold){
        int i,j;
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        
        for(i=0;i<rules.size();i++){
            if(Double.parseDouble(rules.get(i)[3]) >= supportThreshold && Double.parseDouble(rules.get(i)[4]) >= confidenceThreshold){
                Object[] data = new Object[5];
                data[0] = rules.get(i)[0];
                data[1] = rules.get(i)[1];
                data[2] = rules.get(i)[3];
                data[3] = rules.get(i)[4];
                data[4] = Double.parseDouble(rules.get(i)[3]) * Double.parseDouble(rules.get(i)[4]);
                result.add(data);
            }
        }
        
        return result;
    }
    
    public ArrayList<Object[]> getMinimumSupportLists(ArrayList<String[]> rules, int threshold){
        int i,j;
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        
        for(i=0;i<rules.size();i++){
            if(Double.parseDouble(rules.get(i)[3]) >= threshold){
                Object[] data = new Object[4];
                data[0] = rules.get(i)[1];
                data[1] = rules.get(i)[3];
                data[2] = rules.get(i)[4];
                data[3] = Double.parseDouble(rules.get(i)[3]) * Double.parseDouble(rules.get(i)[4]);
                result.add(data);
            }
        }
        
        return result;
    }
    
    public ArrayList<Object[]> getMinimumConfidenceLists(ArrayList<String[]> rules, int threshold){
        int i,j;
        ArrayList<Object[]> result = new ArrayList<Object[]>();
        
        for(i=0;i<rules.size();i++){
            if(Double.parseDouble(rules.get(i)[4]) >= threshold){
                Object[] data = new Object[4];
                data[0] = rules.get(i)[1];
                data[1] = rules.get(i)[3];
                data[2] = rules.get(i)[4];
                data[3] = Double.parseDouble(rules.get(i)[3]) * Double.parseDouble(rules.get(i)[4]);
                result.add(data);
            }
        }
        
        return result;
    }
    
    public int getP(String[] data){
        int result = 0;
        int i,j;
        
        for(i=0;i<tableTransaction.size();i++){
            for(j=0;j<data.length;j++){
                if(tableTransaction.get(i).get(data[j]) == "1"){
                    result = result + 1;
                }
            }
        }
        
        return result;
    }
    
    public String getRuleText(String[] data){
        String result = "";
        int i;
        
        if(data.length == 2){
            result = "If Use "+data[0]+" Then "+data[1];
        }else{
            result = "If Use ";
            for(i=0;i<data.length-1;i++){
                result = result + data[i];
                
                if(i < data.length-2){
                    result = result + " And ";
                }
            }
            result = result +" Then "+ data[data.length-1];
        }
        
        return result;
    }
    
    public String getConclusionText(String[] data){
        String result = "";
        int i;
        
        if(data.length == 2){
            result = "Jika kompetensi yang dibutuhkannya "+data[0]+" Maka dibutuhkan kompetensi "+data[1];
        }else{
            result = "Jika kompetensi yang dibutuhkannya ";
            for(i=0;i<data.length-1;i++){
                result = result + data[i];
                
                if(i < data.length-2){
                    result = result + " dan ";
                }
            }
            result = result +" Maka dibutuhkan kompetensi "+ data[data.length-1];
        }
        
        return result;
    }
    
    public ArrayList<String> getKeyIndex(String[] data){
        ArrayList<String> result = new ArrayList<String>();
        int i;
        
        for(i=0;i<data.length-1;i++){
            result.add(data[i]);
        }
        
        return result;
    }
    
    public ArrayList<String> getAllLists(ArrayList<String> elements, int lengthOfList){
        //initialize our returned list with the number of elements calculated above
        ArrayList<String> allLists = new ArrayList<String>();

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements; 
        else {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            ArrayList<String> allSublists = new ArrayList<String>(getAllLists(elements, lengthOfList - 1));

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.size(); i++){
                for(int j = 0; j < allSublists.size(); j++){
                    //add the newly appended combination to the list
//                    if(i != j){
                        String[] tmp = allSublists.get(j).split(",");
                        if(!tmp[0].matches(elements.get(i)) && !allSublists.get(j).contains(elements.get(i))){
                            String elementTmp = elements.get(i)+","+allSublists.get(j);
                            allLists.add(elementTmp);
                            arrayIndex++;
                        }
//                    }
                }
            }
            return allLists;
        }
    }
    
}
