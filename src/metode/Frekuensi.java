/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Supandi Doank
 */
public class Frekuensi {
    
    public ArrayList<String[]> parseData = new ArrayList<>();
    public ArrayList<String> cleanData = new ArrayList<>();
    public ArrayList<HashMap<String, String>> tableTransaction = new ArrayList<HashMap<String, String>>();
    public HashMap<String, Integer> sumTransaction = new HashMap<String, Integer>();
    public HashMap<String, Integer> minimumTransaction = new HashMap<String, Integer>();
    public ArrayList<Object[]> doubleCombination = new  ArrayList<Object[]>();
    public ArrayList<Object[]> tripleCombination = new  ArrayList<Object[]>();
    public ArrayList<String> combination = new ArrayList<String>();
    public ArrayList<String[]> sumOfCombination = new ArrayList<String[]>();
    public int batasMinimum;
    
    public Frekuensi(){
        
    }
    
    public Frekuensi(ArrayList<String[]> parseData, ArrayList<String> cleanData, int batasMinimum){
        this.parseData = (ArrayList<String[]>)parseData.clone();
        this.cleanData = (ArrayList<String>)cleanData.clone();
        this.batasMinimum = batasMinimum;
    }
    
    public void generateTableTransaction(){
        int i,j;
        String matchValue = "0";
        
        for(i=0;i<parseData.size();i++){
            HashMap<String, String> dataIndustri = new HashMap<String, String>();
            for(j=0;j<cleanData.size();j++){
                dataIndustri.put(cleanData.get(j), "0");
            }
            for(j=0;j<parseData.get(i).length;j++){
                dataIndustri.put(parseData.get(i)[j].trim(), "1");
            }
            System.out.println("Frekuensi::Generated table transaction "+dataIndustri.toString().replace("]","\n"));
            tableTransaction.add(dataIndustri);
        }
    }
    
    public void getSumTransactions(){
        int i,j;
        
        for(i=0;i<cleanData.size();i++){
            sumTransaction.put(cleanData.get(i), 0);
        }
        
        for(i=0;i<tableTransaction.size();i++){
            for (String key : tableTransaction.get(i).keySet()) {
                if(tableTransaction.get(i).get(key) == "1" && sumTransaction.get(key) != null){
                    sumTransaction.put(key, sumTransaction.get(key)+1);
                }
            }
        }
        
        System.out.println("Frekuensi::getSumTransactions "+sumTransaction.toString().replace("]","\n"));
    }
    
    public void getMinimumTransactions(int threshold){
        
        for (String key : sumTransaction.keySet()) {
            if(sumTransaction.get(key) >= threshold){
                minimumTransaction.put(key, sumTransaction.get(key));
            }
        }
        
        System.out.println("Frekuensi::getMinimumTransactions "+minimumTransaction.toString().replace("]","\n"));
    }
    
    public void getDoubleCombination() {
        String[] keyIndex = new String[minimumTransaction.size()];
        int i=0, j;
        
        for (String key : minimumTransaction.keySet()) {
            keyIndex[i] = key;
            i++;
        }
        
        for(i=0;i<keyIndex.length;i++){
            for(j=(i+1);j<keyIndex.length;j++){
                Object[] combination = new Object[3];
                combination[0] = keyIndex[i];
                combination[1] = keyIndex[j];
                combination[2] = 0; //Untuk total sum
                doubleCombination.add(combination);
            }
        }
        
        for(i=0;i<doubleCombination.size();i++){
            int sum = 0;
            for(j=0;j<tableTransaction.size();j++){
                String kombinasi1 = (String) doubleCombination.get(i)[0];
                String kombinasi2 = (String) doubleCombination.get(i)[1];
               
                if(tableTransaction.get(j).get(kombinasi1) == "1" && tableTransaction.get(j).get(kombinasi2) == "1"){
                    sum = sum + 1;
                }
            }
            doubleCombination.get(i)[2] = sum;
        }
        
        for(i=0;i<doubleCombination.size();i++){
            String kombinasi1 = (String) doubleCombination.get(i)[0];
            String kombinasi2 = (String) doubleCombination.get(i)[1];
            
            System.out.println(kombinasi1+"  |---|  "+kombinasi2);
        }
    }
    
    public void getTripleCombination(){
        ArrayList<String> keyIndex = new ArrayList<String>();
        int i, j, k;
        
        for(i=0;i<doubleCombination.size();i++){
            String kombinasi1 = (String) doubleCombination.get(i)[0];
            String kombinasi2 = (String) doubleCombination.get(i)[1];
            
            if(!keyIndex.contains(kombinasi1)){
                keyIndex.add(kombinasi1);
            }
            if(!keyIndex.contains(kombinasi2)){
                keyIndex.add(kombinasi2);
            }
        }
        
        for(i=0;i<keyIndex.size();i++){
            for(j=(i+1);j<keyIndex.size();j++){
                for(k=(j+1);k<keyIndex.size();k++){
                    Object[] combination = new Object[4];
                    combination[0] = keyIndex.get(i);
                    combination[1] = keyIndex.get(j);
                    combination[2] = keyIndex.get(k);
                    combination[3] = 0;
                    tripleCombination.add(combination);
                }
            }
        }
        
        for(i=0;i<tripleCombination.size();i++){
            int sum = 0;
            for(j=0;j<tableTransaction.size();j++){
                String kombinasi1 = (String) tripleCombination.get(i)[0];
                String kombinasi2 = (String) tripleCombination.get(i)[1];
                String kombinasi3 = (String) tripleCombination.get(i)[2];
               
                if(tableTransaction.get(j).get(kombinasi1) == "1" && tableTransaction.get(j).get(kombinasi2) == "1" && tableTransaction.get(j).get(kombinasi3) == "1"){
                    sum = sum + 1;
                }
            }
            tripleCombination.get(i)[3] = sum;
        }
        
        for(i=0;i<tripleCombination.size();i++){
            if((int) tripleCombination.get(i)[3] >= 10){
                System.out.println(tripleCombination.get(i)[0]+"  |---|  "+tripleCombination.get(i)[1]+"  |---|  "+tripleCombination.get(i)[2]+"  |---|  jumlah = "+tripleCombination.get(i)[3]);
            }
        }
    }
    
    public void getCombination(){
        boolean isGreaterThenMinimum = true;
        boolean isIncreaseDeepValue = false;
        ArrayList<String> keyIndex = new ArrayList<String>(getKeyIndex());
        int deepOfCombination = 2;
        
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String[]> generatedList = new ArrayList<String[]>();
        
        while(isGreaterThenMinimum){
            System.out.println("deep of combination = "+deepOfCombination);
            isIncreaseDeepValue = false;
            System.out.println("generated key index");
            result = (ArrayList<String>)getAllLists(keyIndex, deepOfCombination, result).clone();
            System.out.println("Generated list of combination");
            generatedList = (ArrayList<String[]>)generatedCombinationLists(result).clone();
            System.out.println("Execution core process calculate combinations");
            sumOfCombination = (ArrayList<String[]>)getSumOfCombination(generatedList).clone();
            
            System.out.println("Check sum of combinations");
            for(int i=0;i<sumOfCombination.size();i++){
                if(Integer.parseInt(sumOfCombination.get(i)[sumOfCombination.get(i).length-1]) >= batasMinimum){
                    isIncreaseDeepValue = true;
                }
            }
            
            if(isIncreaseDeepValue){
                deepOfCombination++;
                keyIndex = (ArrayList<String>)getKeyIndexFromAnotherProcess(sumOfCombination).clone();
            }else{
                isGreaterThenMinimum = false;
            }
        }
        
        for(int i=0;i<sumOfCombination.size();i++){
            System.out.println(Arrays.deepToString(sumOfCombination.get(i)));
        }
    }
    
    public ArrayList<String> getKeyIndex(){
        ArrayList<String> keyIndex = new ArrayList<String>();
        int i=0, j;
        
        for (String key : minimumTransaction.keySet()) {
            keyIndex.add(key);
            i++;
        }
        return keyIndex;
    }
    
    public ArrayList<String> getKeyIndexFromAnotherProcess(ArrayList<String[]> data){
        ArrayList<String> keyIndex = new ArrayList<String>();
        int i,j;
        
        for(i=0;i<data.size();i++){
            for(j=0;j<data.get(i).length-1;j++){
                if(!keyIndex.contains(data.get(i)[j])){
                    keyIndex.add(data.get(i)[j]);
                }
            }
        }
        
        return keyIndex;
    }
    
    public ArrayList<String> getAllLists(ArrayList<String> elements, int lengthOfList, ArrayList<String> dataBefore){
        //initialize our returned list with the number of elements calculated above
        System.out.println("Jumlah Elements = "+elements.size());
        ArrayList<String> allLists = new ArrayList<String>();
        ArrayList<String> allSublists = new ArrayList<String>();

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements; 
        else {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            if(dataBefore.size() == 0){
                allSublists =(ArrayList<String>)getAllLists(elements, lengthOfList - 1, allSublists).clone();
            }else{
                allSublists =(ArrayList<String>)dataBefore.clone();
            }

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.size(); i++){
//                System.out.println("elements "+i+" "+elements.size()+" "+allSublists.size());
                for(int j = 0; j < allSublists.size(); j++){
//                    System.out.println("All sublists "+j+" "+allSublists.size());
                    //add the newly appended combination to the list
                    if(i != j && j >= i){
                        String[] tmp = allSublists.get(j).split(",");
                        if(!tmp[0].matches(elements.get(i)) && !allSublists.get(j).contains(elements.get(i))){
                            String elementTmp = elements.get(i)+","+allSublists.get(j);
                            if(!checkElementIfExist(elementTmp, allLists)){
//                                if(lengthOfList > 2){
//                                    System.out.println(elementTmp);
//                                }
                                allLists.add(elementTmp);
                                arrayIndex++;
                            }  
                        }
                    }
                }
            }
            return allLists;
        }
    }
    
    public boolean checkElementIfExist(String target, ArrayList<String> data){
        boolean result = false;
        int i, j;
        
        for(i=0;i<data.size();i++){
            result = linearIn(target.split(","), data.get(i).split(","));

            if(result){
                break;
            }
        }
        
        return result;
    }
    
    public boolean linearIn(String[] outer, String[] inner) {
        return Arrays.asList(outer).containsAll(Arrays.asList(inner));
    }
    
    public ArrayList<String[]> generatedCombinationLists(ArrayList<String> data){
        ArrayList<String[]> result = new ArrayList<String[]>();
        int i, j, k;
        
        for(i=0;i<data.size();i++){
            String[] dataSet = data.get(i).split(",");
            String[] dataInput = new String[dataSet.length + 1];
            for(j=0;j<dataSet.length;j++){
                dataInput[j] = dataSet[j];
            }
            dataInput[dataInput.length-1] = "0";
            result.add(dataInput);
        }
        
        return result;
    }
    
    public ArrayList<String[]> getSumOfCombination(ArrayList<String[]> data){
        int i, j, k;
        boolean isMatch;
        
        for(i=0;i<data.size();i++){
            int sum = 0;
            for(j=0;j<tableTransaction.size();j++){
                isMatch = true;
                k=0;
                
                while(isMatch && k<data.get(i).length-1){
                    if(tableTransaction.get(j).get(data.get(i)[k]) != "1"){
                        isMatch = false;
                    }
                    k++;
                }
                
                if(isMatch){
                    sum = sum + 1;
                }
            }
            data.get(i)[data.get(i).length-1] = Integer.toString(sum);
        }
        
        return data;
    }

}
