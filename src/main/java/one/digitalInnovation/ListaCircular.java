package one.digitalInnovation;

import javax.swing.undo.CannotUndoException;

public class ListaCircular <T>{

    private No<T> cabeca;
    private No<T> cauda;
    private int tammanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tammanhoLista = 0;
    }

    public T getConteudo(int index){ // retorna o conteudo de um nó a partir de um indice
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){ //retorna um nó a partir de um indice
        if(isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia!");
        }
        if(index == 0){
            return this.cauda;
        }
        No<T> aux = this.cauda;
        for(int i = 0; i < index; i++){
            aux = aux.getProximo();
        }
        return aux;
    }

    public void remove(int index){ //remove um nó da lista a partir de um indice
        if(index>= tammanhoLista){
            throw new IndexOutOfBoundsException("Indice maior que a lista!");
        }
        No<T> noAuxiliar = this.cauda;
        if(index == 0){ //se o indice for zero significa que a cauda será removida
            this.cauda = this.cauda.getProximo(); //por tanto o proximo nó será a nova cauda
            this.cabeca.setProximo(this.cauda); //e a cabeça passa a apontar para a nova cauda
        }else if(index == 1){ //caso o indice 2, a remoção é feita pela cauda
            this.cauda.setProximo(this.cauda.getProximo().getProximo());
            //a cauda passa a apontar para o proximo nó de seu proximo nó
        }else{
            for(int i = 0; i < index-1;i++){
                //caso o indice nao seja zero ou um, é preciso pegar o nó antecessor ao nó a ser removido
                noAuxiliar = noAuxiliar.getProximo();
            }
            noAuxiliar.setProximo(noAuxiliar.getProximo().getProximo());
            //e esse nó passa a apontar para o proximo nó do seu proximo nó
        }
        this.tammanhoLista--;
    }

    public void add(T conteudo){ //Adiciona mais um nó a lista
        No<T> novo = new No<>(conteudo);
        if (isEmpty()){ //Se a lista estiver vazia:
            this.cauda = novo; //O novo nó é cauda
            this.cabeca = novo;//O novo nó é cabeça
            this.cabeca.setProximo(this.cauda);//a cabeça aponta para cauda
        }else{ //caso nao esteja vazia
            novo.setProximo(cauda); //o novo nó aponta para a cauda
            this.cabeca.setProximo(novo); //o ultimo a ser a adicionado aponta para o novo nó
            this.cabeca = novo; // e o novo nó se torna a nova cabeça.
        }
        this.tammanhoLista++;
    }


    public boolean isEmpty(){
        return this.tammanhoLista == 0;
    }

    public int size(){
        return this.tammanhoLista;
    }

    @Override
    public String toString() {
        String str = "";
        No<T> aux = cauda;

        for (int i = 0; i < this.size(); i++){
            str +="[NO{conteudo: " + aux.getConteudo() + " }] --->";
            aux = aux.getProximo();
        }
        if (isEmpty()) {
            return str +="Lista vazia!";
        }
        str += "Retorna ao início";
        return str;
    }
}
