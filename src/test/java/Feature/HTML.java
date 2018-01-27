package Feature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class HTML {
	static ArrayList al=new ArrayList();
	  private static void listJson(JSONObject json) {
	    listJSONObject("", json);
	  }

	  private static void listObject(String parent, Object data) {
	    if (data instanceof JSONObject) {
	      listJSONObject(parent, (JSONObject)data);
	    } else if (data instanceof JSONArray) {
	      listJSONArray(parent, (JSONArray) data);
	    } else {
	      listPrimitive(parent, data);
	    }    
	  }

	  private static void listJSONObject(String parent, JSONObject json) {
	    Iterator it = json.keys();
	    while (it.hasNext()) {
	      String key = (String)it.next();
	      Object child = json.get(key);
	      String childKey = parent.isEmpty() ? key : parent + "." + key;
	      listObject(childKey, child);
	    }
	  }

	  private static void listJSONArray(String parent, JSONArray json) {
	    for (int i = 0; i < json.length(); i++) {
	      Object data = json.get(i);
	      listObject(parent + "[" + i + "]", data);
	    }
	  }

	  private static void listPrimitive(String parent, Object obj) {
		  al.add(parent+":"+obj);
	   // System.out.println(parent + ":"  + obj);
	  }
public static void main(String[] args) {

File file = new File("C://Users/vadivelu/Desktop/MobilePhoneLists3.html");

FileWriter fileWriter = null;
BufferedWriter bufferedWriter = null;
try {
fileWriter = new FileWriter(file);
bufferedWriter = new BufferedWriter(fileWriter);
String data = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"NigelRees\",\"title\":\"SayingsoftheCentury\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"HermanMelville\",\"title\":\"MobyDick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10}";
JSONObject json = new JSONObject(data);    
System.out.println(json.toString(2));
listJson(json);
String htmlPage ="<html><head style='background-color:#ccc'><b><h3><center><u>Mobile Phones</u></center></h3></b><link rel='StyleSheet' type='text/css' href='style.css' /><script type='text/javascript' src='scripts/json-min.js'></script><script type='text/javascript' src='scripts/BubbleTooltips.js'></script><script type='text/javascript' src='scripts/parse.js'></script></head>";

bufferedWriter.write(htmlPage);

//bufferedWriter.append("<strong><h4>Mobile Phone Companies</h4></strong><ul><li>Apple</li><li>Samsung</li><li>Nokia</li></ul>"); 

bufferedWriter.append("<table style='border: 1px solid black'>");
StringBuilder sb=new StringBuilder();
for(int i=0;i<al.size();i++)
{
	String k,parent="";
	String a=(String)al.get(i);
	
	String[] value=a.split(":");
	if(value[0].contains(".")) {
	String key[]=value[0].split("\\.");
	k=key[key.length-1];
	//k=k.substring(0, k.length()-1);

	parent=value[0].substring(0,value[0].length()- k.length()-1);}else
		 k=value[0];
	System.out.println("parent-"+parent+" Key-"+k+" value-"+value[1]);
	sb.append("<tr style='background-color: #f2f2f2'><td style='border: 1px solid black'>"+parent+"</td><td style='border: 1px solid black'>"+k+"</td><td style='border: 1px solid black'>"+value[1]+"</td></tr>");
	
}
/*
for (Map.Entry<String, String> entry : map.entrySet()) {
	bufferedWriter.append(String.format("<tr style='border: 1px solid black'><td style='border: 1px solid black'>%s</td><td style='border: 1px solid black'>%s</td></tr>",
            entry.getKey(), entry.getValue()));
}
*/
bufferedWriter.append(sb+"</Table>");

bufferedWriter.append("</html>");



bufferedWriter.flush();
fileWriter.flush();

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}finally{
try {

bufferedWriter.close();
fileWriter.close();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

}

}