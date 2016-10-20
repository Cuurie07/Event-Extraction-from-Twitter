package seminarner;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;




public class NERDemo {

    public static void main(String[] args) throws IOException {

      String serializedClassifier = "/Users/anjali/Documents/workspace/seminarner/tagger/english.muc.7class.distsim.crf.ser";

      if (args.length > 0) {
        serializedClassifier = args[0];
      }

      AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);

      
      if (args.length > 1) {
        String fileContents = IOUtils.slurpFile(args[1]);
        List<List<CoreLabel>> out = classifier.classify(fileContents);
        for (List<CoreLabel> sentence : out) {
          for (CoreLabel word : sentence) {
        	 System.out.println("in for loop 1"); 
            System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
          }
          System.out.println();
        }
        out = classifier.classifyFile(args[1]);
        for (List<CoreLabel> sentence : out) {
          for (CoreLabel word : sentence) {
        	  System.out.println("in for loop 2"); 
            System.out.print(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class) + ' ');
          }
          System.out.println();
        }

      } else {
    	  
    	FileReader fr=null;
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
  				String s1=sCurrentLine;
  				System.out.println("k::"+k+"\n");
  				System.out.println(classifier.classifyToString(s1));	
  			    k++;
  			}
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} 
    	
      }
    }

}

