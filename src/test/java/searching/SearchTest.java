package searching;
import base.BaseTest;
import org.testng.annotations.*;
import pages.SearchResultsPage;
public class SearchTest extends BaseTest {
    @Test (dataProvider="dp")
    public void countSearchResults(String data)  {
        String bingdata[]= data.split(",");
        home.setSeachWord(bingdata[1]);
        search = home.searchelementclick();
        nextpage= search.nextPageClick();
        int resultsofpage2= lastPage.countResultsofpage();
        lastPage=nextpage.lastPageClick();
        int resultsofpage3=lastPage.countResultsofpage();
        System.out.println ( "number of results of page 2= " + resultsofpage2 );
        System.out.println ( "number of results of page 3= " + resultsofpage3 );
        soft.assertEquals ( resultsofpage2, resultsofpage2, "The results of two pages are not equal" );
        soft.assertAll ( );
    }
    }