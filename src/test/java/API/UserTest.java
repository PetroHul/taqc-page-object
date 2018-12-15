package API;

import data.IUser;
import data.UserRepository;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {
    @BeforeTest
    public void setUp () {
        RestAssured.baseURI = "http://ZBWJI8GLDFZSRD4QNP76A9D6RKDXN6GT@studio5f.online/api/";
    }

    @Test
    public void getMyUserTest() {
        get("customers/?display=[firstname,lastname,email]&filter[id]=[3]").then().statusCode(200).assertThat()
                .body("prestashop.customers.customer.lastname", equalTo("Pupkin"))
                .body("prestashop.customers.customer.firstname", equalTo("Vasia"))
                .body("prestashop.customers.customer.email", equalTo("local_part@domain.com"));
    }

    @Test
    public void createUser() throws IOException {
        IUser user = UserRepository.get().creatingUser();
        given()
            .contentType("text/xml")
            .body(APItools.createUserXML(user)).
        when().
            post("customers").
        then().
            statusCode(201)
                .body("prestashop.customers.customer.firstname", equalTo(user.getFirstName()))
                .body("prestashop.customers.customer.lastname", equalTo(user.getLastName()))
                .body("prestashop.customers.customer.email", equalTo(user.getEmail()))
        //        .body("prestashop.customer.id", equalTo("")) TODO getId
        ;
    }

    @Test
    public void deleteUser(String id) throws IOException {
        given().
        when().
            delete("customers/" + id).
        then().
            statusCode(200);
    }


}
