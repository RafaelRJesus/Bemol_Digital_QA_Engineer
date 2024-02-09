package functional;

import commons.BaseTest;
import dtos.ProdutoDto;
import org.junit.jupiter.api.Test;
import services.ProdutoServices;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ProdutoTests extends BaseTest {
    ProdutoServices produtoServices;

    @Test
    void consultaProdutosComSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);
        produtoServices.getAllProdutos()
                       .statusCode(SC_OK)
                       .body("quantidade", notNullValue());
    }

    @Test
    void consultaProdutosPorNomeComSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);
        produtoServices.getProdutosByNome("Logitech MX Vertical")
                       .statusCode(SC_OK)
                       .body("quantidade", notNullValue());
    }

    @Test
    void cadastraProdutosComSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);

        ProdutoDto produtoDto = ProdutoDto.builder()
                                          .descricao("fruta")
                                          .nome("maca")
                                          .preco(10)
                                          .quantidade(5)
                                          .build();

        produtoServices.postProdutos(produtoDto)
                       .statusCode(SC_CREATED)
                       .body("message", is("Cadastro realizado com sucesso"));
    }

    @Test
    void atualizaProdutosComSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);

        ProdutoDto produtoDto = ProdutoDto.builder()
                                          .descricao("fruta")
                                          .nome("maca")
                                          .preco(10)
                                          .quantidade(5)
                                          .build();

        produtoServices.postProdutos(produtoDto)
                       .statusCode(SC_CREATED);

        String id = produtoServices.getProdutosByNome("maca")
                                   .extract()
                                   .jsonPath()
                                   .get("produtos[0]._id");

        produtoDto.setPreco(9);

        produtoServices.putProdutosById(id, produtoDto)
                       .statusCode(SC_OK)
                       .body("message", is("Registro alterado com sucesso"));
    }

    @Test
    void deletaProdutosComSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);

        ProdutoDto produtoDto = ProdutoDto.builder()
                                          .descricao("fruta")
                                          .nome("maca")
                                          .preco(10)
                                          .quantidade(5)
                                          .build();

        produtoServices.postProdutos(produtoDto)
                       .statusCode(SC_CREATED);

        String id = produtoServices.getProdutosByNome("maca")
                                   .extract()
                                   .jsonPath()
                                   .get("produtos[0]._id");

        produtoServices.deleteProdutosById(id)
                       .statusCode(SC_OK)
                       .body("message", is("Registro excluído com sucesso"));
    }
}
