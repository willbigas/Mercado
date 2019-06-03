package br.com.mercado.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author William
 */
public class Categoria {

    @NotNull(message = "Para criar uma categoria, preencha os campos obrigatórios")
    private Integer id;
//    @NotEmpty(message = "O campo Categoria não pode estar vazio")
//    @NotNull(message = "O campo Categoria não pode ser nulo")
    @NotBlank(message = "O campo categoria não poder somente espaços..")
    @Size(min = 5, max = 255, message = "O campo Nome deve ter entre 5 e 255 caracteres")
    private String nome;
    @NotNull(message = "O campo de seleção Ativo deve estar preenchido")
    private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return nome;
    }

}
