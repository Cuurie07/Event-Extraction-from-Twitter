package seminarner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class abbreviate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader fr=null;
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter("/Users/anjali/Desktop/abb1.txt");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
  		try {
  			fr = new FileReader("/Users/anjali/Desktop/removed1.txt");
  		} catch (FileNotFoundException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
          BufferedReader br= new BufferedReader(fr);
          String sCurrentLine;
           int k=0;
           
  		try {
  			while ((sCurrentLine = br.readLine()) != null){
  				HashMap<String, String> dictionary = new HashMap<String, String>();
  				
  				dictionary.put("Jan", "January");
  				dictionary.put("Feb","Febraury");
  				dictionary.put("Mar", "March");
  				dictionary.put("Apr", "April");
  				dictionary.put("Jun", "June");
  				dictionary.put("Jul", "July");
  				dictionary.put("Aug", "August");
  				dictionary.put("Sep", "September");
  				dictionary.put("Oct", "October");
  				dictionary.put("Nov", "November");
  				dictionary.put("Dec", "December");
  				
  				Iterator it = dictionary.entrySet().iterator();
  				
  				
  				StringBuilder builder = new StringBuilder(sCurrentLine);
  				String[] words = builder.toString().split("\\s");
  				 ArrayList<String> wordsList = new ArrayList<String>();
  				//wordsList.clear();
  	            for (String word : words){
  	                wordsList.add(word);
  	            }		
  	          // int index=0; 
  	          while (it.hasNext()) {
  		        Map.Entry pair = (Map.Entry)it.next();
  		        
  		        if(wordsList.contains(pair.getKey())){
  		        	
  		        	int index=wordsList.indexOf(pair.getKey());
  		        	wordsList.set(index, (String) pair.getValue());
  		        //	System.out.println(pair.getKey() + "found at::"+wordsList.get(index));
  		        }
  		       // index++;
  		        //System.out.println(pair.getKey() + " = " + pair.getValue());
  		        it.remove(); // avoids a ConcurrentModificationException
  		    }
  	          
  	         for(String word:wordsList){
  	        	fileWriter.write(word+"  ");
  	         }
  	        // fileWriter.write(sCurrentLine)
  	         fileWriter.write("\n");
  			  k++;
  			}
  
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} finally{
  			try {
				fileWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}

	}

}
