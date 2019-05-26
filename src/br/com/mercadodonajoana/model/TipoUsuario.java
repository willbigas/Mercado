/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mercadodonajoana.model;

/**
 *
 * @author william.mauro
 */
public class TipoUsuario {

    private Integer id;
    private String nome;
    private Boolean ativo;
    private Integer tipoPermissao;
    

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

    public Integer getTipoPermissao() {
        return tipoPermissao;
    }

    public void setTipoPermissao(Integer tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "id=" + id + ", nome=" + nome + '}';
    }

}
