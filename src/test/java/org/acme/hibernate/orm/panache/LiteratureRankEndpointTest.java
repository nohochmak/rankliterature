package org.acme.hibernate.orm.panache;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class LiteratureRankEndpointTest {

    @Test
    public void testListAllLiterature() {
        //List all, should have all 3 fruits the database has initially:
        given()
                .when().get("/literaturerank")
                .then()
                .statusCode(200)
                .body(
                        containsString("22 Apr 2015"),
                        containsString("22 Jan 2008"),
                        containsString("25 Sep 2017"));

        //Delete the Cherry:
        given()
                .when().delete("/literaturerank/1")
                .then()
                .statusCode(204);

        //List all, cherry should be missing now:
        given()
                .when().get("/literaturerank")
                .then()
                .statusCode(200)
                .body(
                        not(containsString("22 Apr 2015")),
                        containsString("22 Jan 2008"),
                        containsString("25 Sep 2017"));
    }

}
