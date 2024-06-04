package searching;
import base.Basetests;
import org.testng.annotations.*;
public class Searchtests extends Basetests {
    @Test (dataProvider="dp")
    public void countSearchResults(String data)  {
        String bingdata[]= data.split(",");
        home.setSeachWord(bingdata[1]);
        search.nextPageClick();
        int resultsofpage2= search.countResultsofpage();
        search.lastPageClick();
        int resultsofpage3=search.countResultsofpage();
        System.out.println ( "number of results of page 2= " + resultsofpage2 );
        System.out.println ( "number of results of page 3= " + resultsofpage3 );
        soft.assertEquals ( resultsofpage2, resultsofpage2, "The results of two pages are not equal" );
        soft.assertAll ( );
    }
    }