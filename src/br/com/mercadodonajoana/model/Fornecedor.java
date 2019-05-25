package br.com.mercadodonajoana.model;

/**
 *
 * @author William
 */
public class Fornecedor {

    private Integer id;
    private String nome;
    private String telefone;
    private Endereco Endereco;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", Endereco=" + Endereco + '}';
    }

}
