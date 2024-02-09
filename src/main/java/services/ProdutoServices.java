package services;

import com.google.gson.Gson;
import dtos.ProdutoDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ProdutoServices {
    private final RequestSpecification requestSpecification;

    public ProdutoServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse getAllProdutos() {
        return given().spec(requestSpecification)
                      .get("/produtos")
                .then();
    }

    public ValidatableResponse getProdutosByNome(String nome) {
        return given().spec(requestSpecification)
                      .param("nome", nome)
                      .get("/produtos")
                .then();
    }

    public ValidatableResponse postProdutos(ProdutoDto produtoDto) {
        LoginServices loginServices = new LoginServices(requestSpecification);

        String token = loginServices.login("fulano@qa.com", "teste")
                                    .extract()
                                    .jsonPath()
                                    .get("authorization");

        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .body(new Gson().toJson(produtoDto))
                      .post("/produtos")
                .then();
    }

    public ValidatableResponse putProdutosById(String id, ProdutoDto produtoDto) {
        LoginServices loginServices = new LoginServices(requestSpecification);

        String token = loginServices.login("fulano@qa.com", "teste")
                                    .extract()
                                    .jsonPath()
                                    .get("authorization");

        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .param("_id", id)
                      .body(new Gson().toJson(produtoDto))
                      .put("/produtos/{_id", id)
                .then();
    }

    public ValidatableResponse deleteProdutosById(String id) {
        LoginServices loginServices = new LoginServices(requestSpecification);

        String token = loginServices.login("fulano@qa.com", "teste")
                                    .extract()
                                    .jsonPath()
                                    .get("authorization");

        return given().spec(requestSpecification)
                      .header("Authorization", token)
                      .param("_id", id)
                      .put("/produtos/{_id", id)
                .then();
    }
}
