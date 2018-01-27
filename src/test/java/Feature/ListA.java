package Feature;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class ListA {

	
	public static void main(String args[]) {
		String json=     "{" 
				   + "  \"geodata\": [" 
				   + "    {" 
				   + "      \"id\": \"1\"," 
				   + "      \"name\": \"Julie Sherman\","                  
				   + "      \"gender\" : \"female\"," 
				   + "      \"latitude\" : \"37.33774833333334\"," 
				   + "      \"longitude\" : \"-121.88670166666667\""
				   + "    }," 
				   + "    {" 
				   + "      \"id\": \"2\"," 
				   + "      \"name\": \"Johnny Depp\","          
				   + "      \"gender\" : \"male\"," 
				   + "      \"latitude\" : \"37.336453\"," 
				   + "      \"longitude\" : \"-121.884985\""
				   + "    }" 
				   + "  ]" 
				   + "}";
	    JsonElement jsonElement = new JsonParser().parse(json);
	    List<String> keys = operate(jsonElement, "", true);
	    System.out.println("Keys = " + keys);
	}

	public static List<String> operate(final JsonElement jsonElement, final String prefix, final boolean firstLayer) {
	    if(jsonElement.isJsonObject() || (!firstLayer && jsonElement.isJsonArray())) {
	    	ArrayList<String> keys = new ArrayList<>();
	        if(jsonElement.isJsonObject()) {
	            JsonObject jObj = jsonElement.getAsJsonObject();
	            for(Map.Entry<String, JsonElement> entry : jObj.entrySet()) {
	                JsonElement value = entry.getValue();
	                String newPrefix = prefix + entry.getKey();
	                if(value.isJsonArray() || value.isJsonObject()) {
	                    keys.add(newPrefix);
	                    keys.addAll(operate(value, newPrefix + "_", false));
	                }
	            }
	        } else {
	            JsonArray array = jsonElement.getAsJsonArray();
	            for(JsonElement element : array) {
	                keys.addAll(operate(element, prefix, false));
	            }
	        }
	        return keys;
	    } else {
	        return Collections.emptyList();
	    }
	}
}
