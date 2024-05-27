package br.usjt.focusfit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String usuario;
    private String email;
    private String senha;
    private String peso;
    private String altura;
    private String idade;
}
