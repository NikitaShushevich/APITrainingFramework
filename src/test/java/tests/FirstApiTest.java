package tests;

import api.pojos.CreateUserRequest;
import api.pojos.CreateUserResponse;
import api.pojos.GetUserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstApiTest extends BaseTest {


    @Test
    private void checkSingleUserTest() {

        GetUserResponse userResponse = utils.getUser();
        Assert.assertNotNull(userResponse);

    }

    @Test
    private void createUserTest() {
        CreateUserRequest userToBeCreated = utils.generateDataCreateUser("Name", "Job");

        CreateUserResponse user = utils.createUser(userToBeCreated);

        Assert.assertNotNull(user);
    }

    @Test
    private void checkSingleUserNFTest() {
        Response response = requests.getNotFoundUser();
        GetUserResponse userResponse = utils.getNotFoundUser();
        Assert.assertEquals(response.statusCode(), 404);

    }

    @Test
    private void checkUserDeleteTest() {
        Response response = requests.deleteUser();
        Assert.assertEquals(response.statusCode(), 204);
    }
}
