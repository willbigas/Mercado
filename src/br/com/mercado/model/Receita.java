package br.com.mercado.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

/**
 *
 * @author william.mauro
 */
public class Receita {

    private Integer id;
    @NotNull
    private LocalDateTime dataCadastro;
    private LocalDateTime dataPagamento;
    @NotNull
    @Future
    private Date dataVencimento;
    @DecimalMin(value = "0.00")
    @DecimalMax("999999999.00")
    private Double valorTotal;
    private Double valorRecebido;
    @NotNull
    private Integer codVenda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", dataCadastro=" + dataCadastro + ", dataPagamento=" + dataPagamento + ", dataVencimento=" + dataVencimento + ", valorTotal=" + valorTotal + ", valorRecebido=" + valorRecebido + ", codVenda=" + codVenda + '}';
    }

}
