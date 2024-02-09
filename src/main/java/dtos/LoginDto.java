package dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginDto {
    String email;
    String password;
}
