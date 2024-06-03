package searching;
import base.Basetests;
import org.testng.annotations.*;
public class Searchtests extends Basetests {
    @Test (dataProvider="dp")
    public void countSearchResults(String data) throws InterruptedException {
         String bingdata[]=data.split(",");
        home.setSeachWord(bingdata[1]);
        Thread.sleep ( 6000 );
        search.nextPageClick();
        int resultsofpage2= search.countResultsofpage();
        search.lastPageClick();
        int resultsofpage3=search.countResultsofpage();
        System.out.println ( "number of results of page 2= " + resultsofpage2 );
        Thread.sleep ( 9000 );
        System.out.println ( "number of results of page 3= " + resultsofpage3 );
        soft.assertEquals ( resultsofpage2, resultsofpage2, "The results of two pages are not equal" );
        soft.assertAll ( );
    }
    }



