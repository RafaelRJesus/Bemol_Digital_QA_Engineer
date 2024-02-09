package services;

import com.google.gson.Gson;
import dtos.CarrinhoDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CarrinhoServices {
    private final RequestSpecification requestSpecification;
    protected String token;

    public CarrinhoServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
        LoginServices loginServices = new LoginServices(requestSpecification);

        token = loginServices.login("fulano@qa.com", "teste")
                                    .extract()
                                    .jsonPath()
                                    .get("authorization");
    }

    public ValidatableResponse getAllCarrinhos() {
        return given().spec(requestSpecification)
                      .get("/carrinhos")
                .then();
    }

    public ValidatableResponse getCarrinhoById(String id) {
        return given().spec(requestSpecification)
                      .param("_id", id)
                      .get("/carrinhos")
                .then();
    }

    public ValidatableResponse postCarrinhoByNome(CarrinhoDto carrinhoDtos) {
        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .body(new Gson().toJson(carrinhoDtos))
                      .post("/carrinhos")
                .then();
    }

    public ValidatableResponse putCarrinhoById(String id, CarrinhoDto produtoDto) {
        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .param("_id", id)
                      .body(new Gson().toJson(produtoDto))
                      .put("/carrinhos/{_id", id)
                .then();
    }

    public ValidatableResponse deleteCarrinhoById(String id) {
        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .param("_id", id)
                      .put("/carrinhos/{_id", id)
                .then();
    }

    public ValidatableResponse cancelarCompra() {
        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .delete("/carrinhos/cancelar-compra")
                .then();
    }
}
