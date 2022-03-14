package br.unicap.ed2.avl;

import br.unicap.ed2.base.No;

public class NoAVL extends No {

    private int alturaMaxima;

    public NoAVL(int chave) {
        super(chave);
        alturaMaxima = 1;
    }

    public int getAltura() {
        return alturaMaxima;
    }

    public void setAltura(int novaAltura) {
        alturaMaxima = novaAltura;
    }

    public int getFatorBalanceamento(){
        NoAVL Ndir = this.getDireita();
        NoAVL Nesq = this.getEsquerda();

        int alturaDireita = Ndir != null ? Ndir.getAltura(): 0;
        int alturaEsquerda = Nesq != null ? Nesq.getAltura(): 0;

        int fator = alturaDireita - alturaEsquerda;

        return fator;
    }
    
}
