package functional;

import commons.BaseTest;
import org.junit.jupiter.api.Test;
import services.LoginServices;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.Matchers.is;

public class LoginTests extends BaseTest {
    LoginServices loginServices;

    @Test
    void efetuarLoginComSucesso() {
        loginServices = new LoginServices(requestSpecification);

        loginServices.login("fulano@qa.com", "teste")
                     .statusCode(SC_OK)
                     .body("message", is("Login realizado com sucesso"));
    }

    @Test
    void validarLoginComEmailInvalido() {
        loginServices = new LoginServices(requestSpecification);

        loginServices.login("fulano1@qa.com", "teste")
                     .statusCode(SC_UNAUTHORIZED)
                     .body("message", is("Email e/ou senha inválidos"));
    }

    @Test
    void validarLoginComSenhaInvalido() {
        loginServices = new LoginServices(requestSpecification);

        loginServices.login("fulano@qa.com", "teste12")
                     .statusCode(SC_UNAUTHORIZED)
                     .body("message", is("Email e/ou senha inválidos"));
    }
}
