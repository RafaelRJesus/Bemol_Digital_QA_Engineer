package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class ServeRestSpecification {

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder().setConfig(new RestAssuredConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation())
                                                                         .logConfig(logConfig().enablePrettyPrinting(true)
                                                                                               .enableLoggingOfRequestAndResponseIfValidationFails(ALL)))
                                       .setRelaxedHTTPSValidation()
                                       .setContentType(JSON)
                                       .setAccept(JSON)
                                       .log(ALL)
                                       .setBaseUri("https://serverest.dev")
                                       .build();
    }
}
