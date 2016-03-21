import javax.json.*;
import javax.json.stream.JsonParsingException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Iterator;

/**
	Example that uses JSON Processing API (JSR 353).  This package is not available in the 
	standard libraries; rather it comes from the separately downloaded file: javax.json-api-1.0.jar
	Remember to add this to your classpath.
*/
public class ReadJSON
{	
	public static void main( String[] args )
	{
		String infile = "dictionary.json";
		JsonReader jsonReader;
		JsonObject jobj = null;
		try
		{
			jsonReader = Json.createReader( new FileReader(infile) );
			// assumes the top level JSON entity is an "Object", i.e. a dictionary
			jobj = jsonReader.readObject();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find the file to read: ");
			e.printStackTrace();	
		}
		catch(JsonParsingException e)
		{
			System.out.println("There is a problem with the JSON syntax; could not parse: ");
			e.printStackTrace();
		}
		catch(JsonException e)
		{
			System.out.println("Could not create a JSON object: ");
			e.printStackTrace();
		}
		catch(IllegalStateException e)
		{
			System.out.println("JSON input was already read or the object was closed: ");
			e.printStackTrace();
		}
		if( jobj == null )
			return;
		
		System.out.printf("The dictionary file %s has %d entries\n",infile,jobj.size());
		
		int numToPrint = 100;
		System.out.printf("The first %d of which are:\n",numToPrint);
        Iterator< Map.Entry<String,JsonValue> > it = jobj.entrySet().iterator();
        while( it.hasNext() && numToPrint > 0 )
        {
            Map.Entry<String,JsonValue> me = it.next();
			String word = me.getKey();
			String definition = me.getValue().toString();
			System.out.println(word + "|" + definition);
			--numToPrint;
		}	
	}
}
