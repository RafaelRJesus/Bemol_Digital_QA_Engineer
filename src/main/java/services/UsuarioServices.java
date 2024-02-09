package services;

import com.google.gson.Gson;
import dtos.UsuarioDto;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UsuarioServices {
    private final RequestSpecification requestSpecification;

    public UsuarioServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse getAllUsuarios() {
        return given().spec(requestSpecification)
                      .get("/usuarios")
                .then();
    }

    public ValidatableResponse getUsuariosById(String id) {
        return given().spec(requestSpecification)
                      .get("/usuarios/{_id}", id)
                .then();
    }

    public ValidatableResponse getUsuariosByNome(String nome) {
        return given().spec(requestSpecification)
                      .param("nome", nome)
                      .get("/usuarios")
                .then();
    }

    public ValidatableResponse getUsuariosByEmail(String email) {
        return given().spec(requestSpecification)
                      .param("email", email)
                      .get("/usuarios")
                .then();
    }

    public ValidatableResponse getUsuariosByPassword(String password) {
        return given().spec(requestSpecification)
                      .param("password", password)
                      .get("/usuarios")
                .then();
    }

    public ValidatableResponse getUsuariosByAdministrador(boolean administrador) {
        return given().spec(requestSpecification)
                      .param("administrador", administrador)
                      .get("/usuarios")
                .then();
    }

    public ValidatableResponse postUsuario(UsuarioDto usuario) {
        return given().spec(requestSpecification)
                      .basePath("/usuarios")
                      .body(new Gson().toJson(usuario))
                      .post()
                .then();
    }

    public ValidatableResponse atualizaUsuario(String id, UsuarioDto usuario) {
        return given().spec(requestSpecification)
                      .body(usuario)
                      .put("/usuarios/{_id}", id)
                .then();
    }

    public ValidatableResponse deleteUsuario(String id) {
        return given().spec(requestSpecification)
                      .delete("/usuarios/{_id}", id)
                .then();
    }
}
