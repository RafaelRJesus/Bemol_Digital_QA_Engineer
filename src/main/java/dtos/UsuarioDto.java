package dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioDto {
    String nome;
    String email;
    String password;
    String administrador;
}
