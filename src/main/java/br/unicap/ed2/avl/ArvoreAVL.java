package br.unicap.ed2.avl;

import br.unicap.ed2.base.AbstractArvoreBinariaDePesquisa;
import br.unicap.ed2.base.BinaryTreePrinter;

public class ArvoreAVL extends AbstractArvoreBinariaDePesquisa<NoAVL> {

    @Override
    public NoAVL novoNode(int key) {
        //Altera
        return new NoAVL(key);
    }

    @Override
    public NoAVL inserir(int key) {
        NoAVL n = inserirNoHelper(raiz, key);
        corrigirAltura(n);
        return n;
    }

    private NoAVL corrigirAltura(NoAVL noFolha) {
        NoAVL n = noFolha;
        NoAVL pai = n.getPai();
        while(pai!= null){
            if (n.getChave() > pai.getChave()){
                int altDir = n.getAltura()+1;
                if (pai.getAltura() < altDir){
                    pai.setAltura(altDir);
                } else{
                    break;
                }
            } else {
                int altEsq = n.getAltura()+1;
                if (pai.getAltura() < altEsq){
                    pai.setAltura(altEsq);
                } else {
                    break;
                }
            }
            n = pai;
            pai = pai.getPai();
        }
        return n;
    }

    @Override
    public NoAVL procurar(int key) {
        return procurarNoHelper(raiz, key);
    }

    @Override
    public void deletar(int key) {
        raiz = deletarNoHelper(raiz, key);
        //alteracao
    }

    public static void main(String[] args) {
        ArvoreAVL a = new ArvoreAVL();
        a.inserir(2);
        a.inserir(3);
        a.inserir(4);
        a.inserir(1);
        BinaryTreePrinter<NoAVL> p = new BinaryTreePrinter<NoAVL>(a);
        System.out.println("-------------");
        p.imprimir(System.out);
    }
}