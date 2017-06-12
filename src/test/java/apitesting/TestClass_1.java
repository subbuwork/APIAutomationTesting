package apitesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_1 {

    @Test
    public void TC1_0001(){
        given().
                get("http://jsonplaceholder.typicode.com/posts/3").
                then().
                statusCode(200).
                log().
                all();
    }
}
