/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Junior
 */
public class TableModelVendasRealizadas extends AbstractTableModel {

    public static List<ProdutoVenda> dadosVenda = new ArrayList<>();
    public static String[] colunas = {"Nome", "Preço", "Quantidade"};

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return dadosVenda.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosVenda.get(linha).getCarrinho().get(linha).getNome();
            case 1:
                return dadosVenda.get(linha).getCarrinho().get(linha).getPreço();
            case 2:
                return dadosVenda.get(linha).getCarrinho().get(linha).getQuantidade();
        }
        return null;
    }

    public List carregarProdutos() {
        List<Object> tabela = new ArrayList<Object>();

        for (Joia v : ProdutoVenda.carrinho) {
            List<Object> ln = new ArrayList<Object>();
            ln.add(v.getNome());
            ln.add(v.getPreço());
            ln.add(v.getQuantidade());
            tabela.add(ln);
        }
        return tabela;
    }
      public void addRow(Joia joia) {
        ProdutoVenda.carrinho.add(joia);
        this.fireTableDataChanged();

    }
}
