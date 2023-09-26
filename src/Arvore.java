public class Arvore<T extends Comparable<T>> {

    public No<T> root;

    public Arvore() {
        root = null;
    }

    public void inserir(T elemento) {
        No<T> valor = new No<>(elemento);

        if (root == null) {
            root = valor;
        } else {
            No<T> atual = root;
            while (true) {
                if (valor.dado.compareTo(atual.dado) == -1) { // comparando se o valor é maior ou menor que o valor atual, para saber qual direção ir
                    if (atual.esquerda != null) { // pecorre até a esquerda esteja vazia para colocar o novo elemento
                        atual = atual.esquerda;
                    } else {
                        atual.esquerda = valor; // setando o valor na esquerda do atual
                        break;
                    }
                } else { // se for maior ou igual
                    if (atual.direita != null) { // pecorre até a direita esteja vazia para colocar o novo elemento
                        atual = atual.direita;
                    } else {
                        atual.direita = valor; // setando o valor na direita do atual
                        break;
                    }
                }
            }
        }
    }


    public boolean buscarElemento(T valor){
        No<T> atual = root;

        while (atual != null){
            if (atual.dado == valor){
                return true;
            }else {
                if (valor.compareTo(atual.dado) == -1){
                    atual = atual.esquerda;
                }else {
                    atual = atual.direita;
                }
            }
        } return false;

    }


    public void remover(T elemento) throws Exception{
        if (buscarElemento(elemento) == false){
            throw new Exception("Elemento não existe na arvore");
        }else {

        }


    }

    public void Ordem(){

    }

    public void preOrdem(){

    }
    public void posOrdem(){

    }

}
