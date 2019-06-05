package br.com.mercado.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author william.mauro
 */
public class Venda {

    private Integer id;
    private LocalDateTime dataVenda;
    private Cliente cliente;
    private Usuario usuario;
    private List<ItemVenda> itemVendas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }

    public void setItemVendas(List<ItemVenda> itemVendas) {
        this.itemVendas = itemVendas;
    }
    

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", cliente=" + cliente + ", funcionario=" + usuario + '}';
    }

}
