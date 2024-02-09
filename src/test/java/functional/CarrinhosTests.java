package functional;

import commons.BaseTest;
import dtos.CarrinhoDto;
import dtos.ProdutoCarrinhoDto;
import org.junit.jupiter.api.Test;
import services.CarrinhoServices;

import java.util.List;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class CarrinhosTests extends BaseTest {
    CarrinhoServices carrinhoServices;

    @Test
    void consultaCarrinhosComSucesso() {
        carrinhoServices = new CarrinhoServices(requestSpecification);
        carrinhoServices.getAllCarrinhos()
                        .statusCode(SC_OK)
                        .body("quantidade", notNullValue());
    }

    @Test
    void consultaCarrinhosByIdComSucesso() {
        carrinhoServices = new CarrinhoServices(requestSpecification);
        carrinhoServices.getCarrinhoById("qbMqntef4iTOwWfg")
                        .statusCode(SC_OK)
                        .body("quantidade", notNullValue());
    }

    @Test
    void cadastraCarrinhosComSucesso() {
        carrinhoServices = new CarrinhoServices(requestSpecification);
        ProdutoCarrinhoDto produtoCarrinhoDto = ProdutoCarrinhoDto.builder()
                                                                  .idProduto("BeeJh5lz3k6kSIzA")
                                                                  .quantidade(1)
                                                                  .build();
        carrinhoServices.cancelarCompra()
                        .statusCode(SC_OK);
        CarrinhoDto carrinhoDto = CarrinhoDto.builder()
                                             .produtos(List.of(produtoCarrinhoDto))
                                             .build();

        carrinhoServices.postCarrinhoByNome(carrinhoDto)
                        .statusCode(SC_CREATED)
                        .body("message", is("Cadastro realizado com sucesso"));
    }

    @Test
    void alteraCarrinhosByIdComSucesso() {
        carrinhoServices = new CarrinhoServices(requestSpecification);
        ProdutoCarrinhoDto produtoCarrinhoDto = ProdutoCarrinhoDto.builder()
                                                                  .idProduto("BeeJh5lz3k6kSIzA")
                                                                  .quantidade(1)
                                                                  .build();
        CarrinhoDto carrinhoDto = CarrinhoDto.builder()
                                             .produtos(List.of(produtoCarrinhoDto))
                                             .build();

        carrinhoServices.cancelarCompra()
                        .statusCode(SC_OK);
        String id = carrinhoServices.postCarrinhoByNome(carrinhoDto)
                                    .extract()
                                    .jsonPath()
                                    .get("_id");

        carrinhoServices.putCarrinhoById(id, carrinhoDto)
                        .statusCode(SC_OK)
                        .body("carrinhos.produtos.idProduto", containsInAnyOrder("BeeJh5lz3k6kSIzA"));
    }

    @Test
    void cancelaCarrinhosByIdComSucesso() {
        carrinhoServices = new CarrinhoServices(requestSpecification);
        ProdutoCarrinhoDto produtoCarrinhoDto = ProdutoCarrinhoDto.builder()
                                                                  .idProduto("BeeJh5lz3k6kSIzA")
                                                                  .quantidade(1)
                                                                  .build();
        CarrinhoDto carrinhoDto = CarrinhoDto.builder()
                                             .produtos(List.of(produtoCarrinhoDto))
                                             .build();

        carrinhoServices.postCarrinhoByNome(carrinhoDto);

        carrinhoServices.cancelarCompra()
                        .statusCode(SC_OK)
                        .body("message", is("Registro excluído com sucesso"));
    }
}
