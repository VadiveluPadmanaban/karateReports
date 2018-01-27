package Feature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HTMLpage {

	public static void main() throws NoSuchMethodException, ScriptException, IOException
	{
	ScriptEngineManager manager = new ScriptEngineManager();
	ScriptEngine engine = manager.getEngineByName("JavaScript");
	// read script file
	engine.eval(Files.newBufferedReader(Paths.get("C:/Users/vadivelu/Desktop/json2html-master/scripts/parse.js")));

	Invocable inv = (Invocable) engine;
	// call function from script file
	inv.invokeFunction("yourFunction", "param");
}
}