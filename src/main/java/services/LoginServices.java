package services;

import com.google.gson.Gson;
import dtos.LoginDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class LoginServices {
    private final RequestSpecification requestSpecification;

    public LoginServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse login(String usuario, String senha) {
        LoginDto loginDto = LoginDto.builder()
                                    .email(usuario)
                                    .password(senha)
                                    .build();

        return given().spec(requestSpecification)
                      .body(new Gson().toJson(loginDto))
                      .post("/login")
                .then();
    }
}
