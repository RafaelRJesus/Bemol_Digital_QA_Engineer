package functional;

import com.github.javafaker.Faker;
import commons.BaseTest;
import dtos.UsuarioDto;
import org.junit.jupiter.api.Test;
import services.UsuarioServices;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UsuariosTests extends BaseTest {
    UsuarioServices usuarioServices;

    @Test
    void consultaTodosUsuariosComSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        usuarioServices.getAllUsuarios()
                       .statusCode(SC_OK)
                       .body("quantidade", notNullValue());
    }

    @Test
    void consultaUsuariosPorEmailComSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        usuarioServices.getUsuariosByEmail("baby@email.com")
                       .statusCode(SC_OK)
                       .body("usuarios.email", is("baby@email.com"));
    }

    @Test
    void cadastraUsuarioComSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        Faker faker = new Faker();

        UsuarioDto usuarioDto = UsuarioDto.builder()
                                          .nome(faker.name()
                                                     .fullName())
                                          .email(faker.internet()
                                                      .emailAddress())
                                          .password("123456")
                                          .administrador("true")
                                          .build();

        usuarioServices.postUsuario(usuarioDto)
                       .statusCode(SC_CREATED)
                       .body("message", is("Cadastro realizado com sucesso"));
    }

    @Test
    void deletaUsuarioComSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        Faker faker = new Faker();
        String nome = faker.name()
                           .fullName();
        UsuarioDto usuarioDto = UsuarioDto.builder()
                                          .nome(nome)
                                          .email(faker.internet()
                                                      .emailAddress())
                                          .password("123456")
                                          .administrador("true")
                                          .build();

        usuarioServices.postUsuario(usuarioDto)
                       .statusCode(SC_CREATED);

        String id = usuarioServices.getUsuariosByNome(nome).log().all()
                                   .extract()
                                   .jsonPath()
                                   .get("usuarios[0]._id");

        usuarioServices.deleteUsuario(id)
                       .statusCode(SC_OK)
                       .body("message", is("Registro excluído com sucesso"));//Bug1: De acordo com a documentação a mensagem deveria ser "Nenhum registro excluído"
    }

    @Test
    void atualizaUsuarioComSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        Faker faker = new Faker();
        String nome = faker.name()
                           .fullName();
        UsuarioDto usuarioDto = UsuarioDto.builder()
                                          .nome(nome)
                                          .email(faker.internet()
                                                      .emailAddress())
                                          .password("123456")
                                          .administrador("true")
                                          .build();

        usuarioServices.postUsuario(usuarioDto)
                       .statusCode(SC_CREATED);

        String id = usuarioServices.getUsuariosByNome(nome).log().all()
                                   .extract()
                                   .jsonPath()
                                   .get("usuarios[0]._id");

        usuarioDto.setNome(faker.name().fullName());
        usuarioServices.atualizaUsuario(id,usuarioDto)
                       .statusCode(SC_OK)
                       .body("message", is("Registro alterado com sucesso"));
    }
}
