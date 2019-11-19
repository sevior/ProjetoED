package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {

    public static List<Joia> dadosJoias = new ArrayList<>();
    public static String[] colunas = {"Nome", "Preço", "Quantidade"};

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return dadosJoias.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dadosJoias.get(linha).getNome();
            case 1:
                return dadosJoias.get(linha).getPreço();
            case 2:
                return dadosJoias.get(linha).getQuantidade();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dadosJoias.get(linha).setNome((String) valor);
                break;
            case 1:
                dadosJoias.get(linha).setPreço(Double.parseDouble((String) valor));
                break;
            case 2:
                dadosJoias.get(linha).setQuantidade(Integer.parseInt((String) valor));
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addRow(Joia joia) {
        this.dadosJoias.add(joia);
        this.fireTableDataChanged();

    }

    public void removeRow(int linha) {
        this.dadosJoias.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public List carregarProdutos() {
        List<Object> tabela = new ArrayList<Object>();
        
        for (Joia joias : ProdutoTableModel.dadosJoias) {
            List<Object> ln = new ArrayList<Object>();
            ln.add(joias.getNome());
            ln.add(joias.getPreço());
            ln.add(joias.getQuantidade());
            tabela.add(ln);
        }
        return tabela;
    }
   
}
