package Feature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HTML {

public static void main(String[] args) {

File file = new File("C://Users/vadivelu/Desktop/MobilePhoneLists3.html");
HashMap<String,String> map=new HashMap<String,String>();
map.put("name","hello");
map.put("address","anbc");
map.put("road","ada");
FileWriter fileWriter = null;
BufferedWriter bufferedWriter = null;
try {
fileWriter = new FileWriter(file);
bufferedWriter = new BufferedWriter(fileWriter);

String htmlPage ="<html><head style='background-color:#ccc'><b><h3><center><u>Mobile Phones</u></center></h3></b><link rel='StyleSheet' type='text/css' href='style.css' /><script type='text/javascript' src='scripts/json-min.js'></script><script type='text/javascript' src='scripts/BubbleTooltips.js'></script><script type='text/javascript' src='scripts/parse.js'></script></head>";

bufferedWriter.write(htmlPage);
bufferedWriter.append("doParse2('{ 'name':'velu' }')");
//bufferedWriter.append("<strong><h4>Mobile Phone Companies</h4></strong><ul><li>Apple</li><li>Samsung</li><li>Nokia</li></ul>"); 

//bufferedWriter.append("<table style='border: 1px solid black'>");
/*
for (Map.Entry<String, String> entry : map.entrySet()) {
	bufferedWriter.append(String.format("<tr style='border: 1px solid black'><td style='border: 1px solid black'>%s</td><td style='border: 1px solid black'>%s</td></tr>",
            entry.getKey(), entry.getValue()));
}
*/
bufferedWriter.append("</>");

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