package testdata;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
public class JsonDataReader {
    @DataProvider(name="dp")
    public String[] jsonDataReader () throws  IOException , org.json.simple.parser.ParseException {
        JSONParser jsonparser=new JSONParser();
        FileReader reader=new FileReader("C:\\Users\\test\\IdeaProjects\\Challenge_Vois\\src\\test\\java\\testdata\\testdata.json");
        Object obj=jsonparser.parse(reader);
        JSONObject bingJsonobj=(JSONObject)obj;
        JSONArray bingArray=(JSONArray)bingJsonobj.get("bing");
        String arr[]=new String[bingArray.size()];
        for (int i=0; i<bingArray.size();i++)
        {
            JSONObject webdata=(JSONObject) bingArray.get(i);
            String url=(String)webdata.get("url");
            String searchword=(String)webdata.get("searchword");
            arr[i]=url+"," +searchword ;
        }
        return arr;
    }
}
