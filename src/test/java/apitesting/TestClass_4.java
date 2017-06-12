package apitesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_4 {
    // Normal test case without any response verification
    //@Test
    public void TC_001(){
        given().
                get("http://services.groupkt.com/country/get/iso3code/IND").
                then().
                statusCode(200).log().all();

    }

    //Basic way to test all the values in the response..
    // @Test
    public void TC_002_Without_Root(){
        given().
                get("http://services.groupkt.com/country/get/iso3code/IND").
                then().
                body("RestResponse.result.name", Matchers.equalTo("India")).
                body("RestResponse.result.alpha2_code",Matchers.equalTo("IN")).
                body("RestResponse.result.alpha3_code",Matchers.equalTo("IND")).
                log().all();
    }

    //Advanced way to test response
    // @Test
    public void TC_003_With_Root(){
        given().
                get("http://services.groupkt.com/country/get/iso3code/IND").
                then().
                root("RestResponse.result").     //default root
                body("name",Matchers.is("India")).
                body("alpha2_code",Matchers.is("IN")).
                body("alpha3_code",Matchers.is("IND")).
                log().all();
    }

    @Test
    public void TC_004_Detach_Root(){
        given().
                get("http://services.groupkt.com/country/get/iso3code/IND").
                then().
                root("RestResponse.result").     //default root
                body("name",Matchers.is("India")).
                body("alpha2_code",Matchers.is("IN")).
                detachRoot("result").
                body("result.alpha3_code",Matchers.is("IND")).
                log().all();
    }

}
