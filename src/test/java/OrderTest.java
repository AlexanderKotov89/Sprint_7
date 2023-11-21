import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderTest {
    private Order order;

    @Before
    public void setUp() {
        RestAssured.baseURI = Courier.BASE_URL;
        order = new Order();
    }

    @Test
    @DisplayName("Список заказов")
    @Description("Проверяем список заказов")
    public void getOrder() {
        order.getOrderList()
                .then()
                .statusCode(200)
                .body("orders", notNullValue());
    }
}
