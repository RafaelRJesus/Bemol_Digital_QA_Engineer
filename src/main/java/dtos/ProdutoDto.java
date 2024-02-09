package dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProdutoDto {
    String nome;
    int preco;
    String descricao;
    int quantidade;
}
