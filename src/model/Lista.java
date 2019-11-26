package model;

public class Lista<T> {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) {
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe!");
        }

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getAnterior();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;

        }
    }

    public int tamanho() {
        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    public void adicionaNoComeco(Object elemento) {
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe!");
        }
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe!");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe!");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Celula atual = primeira;

        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            sb.append(atual.getElemento());
            sb.append(", ");
            atual = atual.getProxima();
        }

        sb.append(atual.getElemento());
        sb.append("]");

        return sb.toString();
    }

}
