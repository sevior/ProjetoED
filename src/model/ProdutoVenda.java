/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Junior
 */
public class ProdutoVenda {

    private String nomeCliente;
    private String telefone;
    private String data;
    private double total = 0;
    private int parcelas;
    public static Lista<Joia> carrinho;

    public ProdutoVenda(String nomeCliente, String telefone, String data, Lista<Joia> carrinho, double total) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.data = data;
        this.carrinho = carrinho;
        this.total = total;
    }

    public ProdutoVenda() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Lista<Joia> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Lista<Joia> carrinho) {
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
        return "Nome do cliente: " + nomeCliente + ", Telefone: " + telefone + ", Data da Venda: " + data + "\nProdutos: " + carrinho + "\nTotal da compra: R$" + String.format("%.2f", total);
    }

}
