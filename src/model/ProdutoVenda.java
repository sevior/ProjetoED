/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Junior
 */
public class ProdutoVenda {

    static void carrinho(Joia joia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String nomeCliente;
    private String telefone;
    private String data;
    private double total = 0;
    private int parcelas;
    public static List<Joia> carrinho;

    public ProdutoVenda(String nomeCliente, String telefone, String data, List<Joia> carrinho, double total) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.data = data;
        this.carrinho = carrinho;
        this.total = total;
    }
    public ProdutoVenda(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Joia> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Joia> carrinho) {
        this.carrinho = carrinho;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome do cliente: " + nomeCliente + ", Telefone: " + telefone + ", Data da Venda: " + data + "\nProdutos: " + carrinho+"\nTotal da compra: R$"+String.format("%.2f", total);
    }

}
