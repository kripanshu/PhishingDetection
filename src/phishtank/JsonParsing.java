package phishtank;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonParsing

{
	
	
	
	static String name,url1,result;
	static String res="This is a phishing site",res1="This is not a phishing site", validation="please enter the URL properly";
	public String  Check (String input) throws FileNotFoundException, IOException, ParseException
	{
		if(input==null){}else{
		
		JSONParser parser = new JSONParser();
		HashMap<String, String> h=new HashMap<String, String>(); 
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:/Users/kripanshu/workspace/verified_online.json"));

            for (Object o : a)
            {
              JSONObject person = (JSONObject) o;

              name = (String) person.get("phish_id");
             
             
               url1 = (String) person.get("url");
             // System.out.println(city);
               h.put(name, url1);
            //  String job = (String) person.get("target");
              //System.out.println(job);

              
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        Set<Entry<String, String>> set = h.entrySet();
        // Get an iterator
        Iterator<Entry<String, String>> i = set.iterator();
        // Display elements
        while(i.hasNext()) {
           Entry<String, String> me = i.next();
          System.out.print(me.getKey() + ": ");
           System.out.println(me.getValue());
          
           
		
        }
        if(h.containsValue(input))
        {
        	return res;
        }else {return res1;}
		
	}
		return validation;
}
	}
