package dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CarrinhoDto {
    List<ProdutoCarrinhoDto> produtos;
}
