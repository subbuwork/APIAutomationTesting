package apitesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_3 {

    //Basic test
    //@Test
    public void TC_001(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().statusCode(200).log().all();
    }

    //Verifying response against CITY
    //@Test
    public void TC_002(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().
                body("CUSTOMER.CITY", Matchers.equalTo("Dallas"));
    }
    //Verifying response against First Name
    // @Test
    public void TC_003(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/11/").
                then().
                body("CUSTOMER.FIRSTNAME", Matchers.equalTo("Julia"));
    }

    //Compare complete text in one go..
    // @Test
    public void TC_004(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().
                body("CUSTOMER.text()",Matchers.equalTo("10SueFuller135 Upland Pl.Dallas")).
                log().all();

    }

    //Using xpath to find value in xml response
    //@Test
    public void TC_005_XPATH(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
                then().
                body(Matchers.hasXPath("/CUSTOMER/FIRSTNAME"),Matchers.containsString("Sue")).
                log().all();

    }
    //Reg ex xpath
    //@Test
    public void TC_006_XPATH(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
                then().
                statusCode(200).
                body(Matchers.hasXPath("/INVOICEList/INVOICE[text()='40']")).
                log().all();
    }

    //xpath
    @Test
    public void TC_007(){
        given().
                get("http://www.thomas-bayer.com/sqlrest/INVOICE/10/").
                then().
                statusCode(200).
                body("INVOICE.TOTAL",Matchers.equalTo("3274.50")).
                log().all();

    }

}
