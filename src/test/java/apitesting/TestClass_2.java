package apitesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_2 {
//This class mainly focus on JSON output format..
    //@Test
    public void TC_001(){
        given().
                get("http://jsonplaceholder.typicode.com/posts/3").
                then().statusCode(200).log().all();

    }

    //Validating response
    //@Test
    public void TC_002(){
        given().
                get("http://services.groupkt.com/country/get/iso3code/IND").
                then().
                body("RestResponse.result.name", Matchers.equalTo("India")).
                and().log().all();
    }

    //Verifying multiple content in the response
    //@Test
    public void TC_003(){
        given().
                get("http://services.groupkt.com/country/get/all").
                then().
                body("RestResponse.result.name",Matchers.hasItems("India","China","Brazil"));

    }

    //Parameter and header set
    // @Test
    public void TC_004(){
        given().
                param("key","value12").
                header("headA","Value123").
                when().
                get("http://services.groupkt.com/country/get/all").
                then().statusCode(200).log().all();
    }

    //Using and to increase readability
    //Generally used when writing one line xpath style.
    @Test
    public void TC_005(){
        given().param("key","value").
                and().header("key","value").
                when().get("http://services.groupkt.com/country/get/iso2code/CN").
                then().statusCode(200).
                and().body("RestResponse.result.alpha3_code",Matchers.equalTo("CHN"));
    }
}
