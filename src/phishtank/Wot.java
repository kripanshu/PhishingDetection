package phishtank;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;


import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class Wot {

	static String host="",reputation="",str="",output="",finalreputationvalue="",exception="";
	static int negative1=0,questionable1=0,netural1=0,positive1=0,valuesize=0,status=0;;
	static Object categories,name,target,zero,blacklisted;
	static Object hashvalue="";
	
 static  int[] value;
	static int[] code;
	static  String[] s;

	
	public void input() //Method to get input
	{
		//String [] s=new String[str.length()];
		
		
		int j=0,k=0;
		for(int i=1; i<s.length;i++)
		{
			
	if(i%2==0)
	{
		value[j]=Integer.parseInt(s[i].toString());
		j++;
	}
	else
	{
	code[k]=Integer.parseInt(s[i].toString());	
	k++;
	}
		}

	/*	for(int i=0;i<value.length;i++)
		{
			
			System.out.print(code[i] +" : "+value[i]+"  ");
			
		}
		//System.out.println("cool");*/
	}	
	public String count() // method to count and show status
	{
		

		for(int i=0;i<code.length;i++){

			if(101<=code[i]&&code[i]<=105)
			{
				negative1++;
				
			}
			else
				if(201<=code[i]&&code[i]<=207)
				{
					
					questionable1++;
				}
				else
				if(301<=code[i]&&code[i]<=304)
				{
					netural1++;
					
				}
				else
					if(code[i]==501)
					{
					positive1++;	
					
					}
					else
					{
						System.out.print("not in WOT database");
					}
			
			
			
		}
		
		String Negative ="Negative",Questionable="Questionable",Netural="Netural",Positive="Positive",default1="Default";
		int max1=Math.max(negative1,questionable1 );
		int max2=Math.max(netural1,positive1);
		int max3=Math.max(max1, max2);
		if(max3==negative1)
		{
			return Negative;
		}else if (max3==questionable1)
		{
			return Questionable;
		}
		if(max3==netural1)
		{
			return Netural;
		}if(max3==positive1)
		{
			return Positive;
		}else
		return default1;
	}
		
		
	
	
	public String compare() // Method to check if value is there
	{
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
	    // Put elements to the map
	    hm.put(101, "Malware or viruses");
	    hm.put(102, "Poor customer experience");
	    hm.put(103, "Phisihng");
	    hm.put(104, "Scam");
	    hm.put(105, "Potentially illegal");
	   
	    hm.put(201, "Misleading claims or unethical");
	    hm.put(202, "Privacy risks");
	    hm.put(203, "Suspicious");
	    hm.put(204, "Hate, discrimination");
	    hm.put(205, "Spam");
	    hm.put(206, "Potentially unwanted programs");
	    hm.put(207, "Ads / pop-ups");
	    
	    hm.put(301, "Online tracking");
	    hm.put(302, "Alternative or controversial medicine");
	    hm.put(303, "Opinions, religion, politics");
	    hm.put(304, "Other");
	    hm.put(501, "Good site");
		
	    
	    for(int i=0;i<code.length;i++)
	    { 
	   	
	    
	    	int key=code[i];
	    
	    	if(hm.containsKey(key))
	    	{
	    		hashvalue=hm.get(code[i]);
	    		output=output+"\n"+hashvalue.toString()+" : "+value[i];
	    	System.out.println(output);	
	    	}
	    }
	    
		
		
	    return output;
	}
	

	
	public String check1(String input) throws Exception {
		String finalresult="",finaloutput="",finaldata="",urlvalue="";
	Wot object= new Wot();	
		host=input;
		URL aURL = new URL(host);
		String url = "http://api.mywot.com/0.4/public_link_json2?hosts="+host+"/&key=ccf2b2d349a3516c1fd2034fccf30ab64adb0b54";
		URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
			//JSONObject jsonObject = new JSONObject();
			

	JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
	 name= json.get(aURL.getHost());
	 target=((JSONObject) name).get("target");
try{
	 JSONArray zero=(JSONArray) ((JSONObject) name).get("0");
	 categories=((JSONObject) name).get("categories");
		if(null==categories && null==zero)
		{
			
			blacklisted=((JSONObject) name).get("blacklists");
			finalresult="This site is Blacklisted  : "+blacklisted.toString();
		} // what to do
		
		else
			
		{
			
		s=new String[str.length()];
			str = categories.toString();
			str = str.replaceAll("[^-?0-9]+", " ");
			s=str.split(" ");
			valuesize=(s.length/2);
			value=new int[valuesize];
			code=new int[valuesize];
			object.input();
			
			//object.compare();
			
			finaloutput=object.count();
			//finalreputationvalue=object.reputationvalue();
			
			finaldata=object.compare();
			
			urlvalue=input;
			finalresult="URL : "+urlvalue+"\n\n"+"CATEGORIES : "+finaldata+"\n"+"REPUTATION : "+finaloutput+"\n";
			//finalresult1="";
			System.out.println(finalresult );
			
			
			
		
		}
		
		
}catch(Exception e)

{
	System.out.println("");
exception="Warning : Phishing website";
	return exception;

}

return finalresult;



	



}
	

}