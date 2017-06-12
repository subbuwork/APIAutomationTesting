package apitesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_5 {
    // This class mainly focus on Post method in Restful web services...

    //This method explains how we can pass values  in post method..
    @Test
    public void TC_001_PostRequest(){
        given().
                header("AppKey","App-Value").
                param("","").
                param("","").
                param("","").
                param("","").
                when().
                post("http://jsonplaceholder.typicode.com/posts/3").

                then().
                statusCode(200).log().all();

    }
}
