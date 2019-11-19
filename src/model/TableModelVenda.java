/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import static model.ProdutoTableModel.dadosJoias;

/**
 *
 * @author Junior
 */
public class TableModelVenda extends AbstractTableModel {

    public static List<Joia> produtos = new ArrayList<>();
    public static String[] colunas = {"Nome", "Preço", "Quantidade"};

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return produtos.get(linha).getNome();
            case 1:
                return produtos.get(linha).getPreço();
            case 2:
                return produtos.get(linha).getQuantidade();
        }
        return null;
    }
     public void addRow(Joia joia) {
        this.produtos.add(joia);
        this.fireTableDataChanged();

    }

}
