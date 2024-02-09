package dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProdutoCarrinhoDto {
    String idProduto;
    int quantidade;
}
