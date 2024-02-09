package commons;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import specifications.ServeRestSpecification;

public class BaseTest {
    protected RequestSpecification requestSpecification;
    @BeforeEach
    public void setUp() {
        this.requestSpecification = new ServeRestSpecification().getRequestSpecification();
    }
}
