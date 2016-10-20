package seminarner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class removestop {

	public static void main(String[] args) {
		
		try{
		// TODO Auto-generated method stub
		FileReader fr=null;
		fr = new FileReader("/Users/anjali/Desktop/stopwordslist.txt");
		
        BufferedReader br= new BufferedReader(fr);
        String sCurrentLine;
        ArrayList<String> stopwords = new ArrayList<String>();
         int k=0;
		
			while ((sCurrentLine = br.readLine()) != null){
				stopwords.add(sCurrentLine);
			    k++;
			}
		
		
		ArrayList<String> wordsList = new ArrayList<String>();
		
		JSONParser parser = new JSONParser();
		FileWriter fileWriter=new FileWriter("/Users/anjali/Desktop/removed1.txt");
		
		String file="/Users/anjali/Desktop/sample2.json";
		
			System.out.println("Reading JSON file from Java program"); 
			FileReader fileReader = new FileReader(file); 
			 Object obj = parser.parse(fileReader);
			 JSONArray jsonArray = (JSONArray) obj;
		        int length = jsonArray.size();
		        
		        int in=0;
		        LinkedList name = new LinkedList();
		        LinkedList author = new LinkedList();
		        LinkedList company = new LinkedList();
		       
		        for (int i =0; i< length; i++) {
		            JSONObject jsonObject = (org.json.simple.JSONObject) jsonArray.get(i);
		            Set s = jsonObject.entrySet();
		            Iterator iter = s.iterator();

		            LinkedList ll = new LinkedList();
		            LinkedList lm = new LinkedList();

		            while(iter.hasNext()){
		            	wordsList.clear();
		            	Map.Entry me = (Map.Entry) iter.next();
		            	System.out.println("value::"+in++);
		            	System.out.println(me.getValue());
		            	StringBuilder builder = new StringBuilder((String)me.getValue());
		            	StringBuilder build=new StringBuilder(builder.toString().replaceAll("\\\n", ""));
		                String[] words = build.toString().split("\\s");
		                for (String word : words){
		                    wordsList.add(word);
		                }
		          
		            
		                for(int ii = 0; ii < wordsList.size(); ii++){
		                        if(stopwords.contains(wordsList.get(ii).toLowerCase())){
		                            wordsList.set(ii, "");
		                            break;
		                        }
		                }
		                for (String str : wordsList){
		                    fileWriter.write(str+" ");
		                }   
		    			fileWriter.write("\n");
		               
		            }   
		            }     
		        fileWriter.flush();
			} 	
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception ex) 
		{ ex.printStackTrace(); }	
	}
}
