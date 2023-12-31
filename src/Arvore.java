public class Arvore<T extends Comparable<T>> {

    public No<T> root;

    int cont;

    public Arvore() {
        root = null;
    }

    public void inserir(T elemento) {
        No<T> valor = new No<>(elemento);

        if (root == null) {
            root = valor;
            root.pai = null;
        } else {
            No<T> atual = root;
            while (true) {
                if (valor.dado.compareTo(atual.dado) == -1) { // comparando se o valor é maior ou menor que o valor atual, para saber qual direção ir
                    if (atual.esquerda != null) { // pecorre até a esquerda esteja vazia para colocar o novo elemento
                        atual = atual.esquerda;
                    } else {
                        atual.esquerda = valor; // setando o valor na esquerda do atual
                        atual.esquerda.pai = atual; // dizendo que o pai do novo valor setado é o atual
                        break;
                    }
                } else { // se for maior ou igual
                    if (atual.direita != null) { // pecorre até a direita esteja vazia para colocar o novo elemento
                        atual = atual.direita;
                    } else {
                        atual.direita = valor; // setando o valor na direita do atual
                        atual.direita.pai = atual; // dizendo que o pai do novo valor setado é o atual
                        break;
                    }
                }
            }
        }
    }


    public No<T> buscarElemento(T valor){
        No<T> atual = root;

        while (atual != null){
            if (atual.dado == valor){
                return atual;
            }else {
                if (valor.compareTo(atual.dado) == -1){
                    atual = atual.esquerda;
                }else {
                    atual = atual.direita;
                }
            }
        } return null;
    }

    // Na remoção existe 3 casos
    // 1ª Caso
    // Se não tiver filhos, no caso se for remover uma folha
    // Sendo assim só tem que descobrir se o elemento que deseja ser removido está a esquerda ou direita do seu pai
    // Após descobrir só setar a posição como null , mas no caso se for uma raiz tem que fazer um ajuste já que o pai é null

    // 2º Caso
    // Se tem filho apenas a direita ou esquerda
    // nesse caso usa-se uma auxiliar para salvar o filho do No atual
    // depois disso comparamos se o filho vai ficar a esquerda ou direita do pai
    // depois seta o filho do No atual como filho do pai do No atual, assim substitui o no atual pelo seu filho removendo da lista
    // tendo que também fazer um ajuste se for raiz

    // 3ª Caso
    // Se tem dois filhos
    //


    // Quando eu uso atual.pai estou me referindo ao pai do atual, também podendo ser lido como paiatual = atual.pai
    public void remover(T elemento) throws Exception{
        if (buscarElemento(elemento) == null){
            throw new Exception("Elemento não existe na arvore");
        }
        else {
            No<T> atual = buscarElemento(elemento);
            No<T> filhosubstituto = null;
            No<T> paisubstituto = atual;

            // Quando não é raiz e se tem dois filhos
            if (atual.direita != null && atual.esquerda != null){
               filhosubstituto = atual.getEsquerda();

               while (filhosubstituto.getDireita() != null){
                   paisubstituto = filhosubstituto;
                   filhosubstituto = filhosubstituto.direita;
               }
               filhosubstituto.direita = atual.direita;


               if (atual.pai == null) {
                   root.dado = filhosubstituto.dado;

               }else{
                   if (atual.dado.compareTo(atual.pai.dado) == -1) {
                       atual.pai.esquerda = filhosubstituto;
                   } else {
                       atual.pai.direita = filhosubstituto;
                   }
               }




            // Quando se tem um filho a esquerda ou direita
            } else if (atual.direita != null) {

                filhosubstituto = atual.direita;     // estou salvando o filho do atual que se encontra a direita

                if (atual == root){
                    root = filhosubstituto;
                }
                else{
                    if (filhosubstituto.dado.compareTo(atual.pai.dado) == -1){   // agora estou comparando se o filho é menor que o pai
                        atual.pai.esquerda = filhosubstituto;                    // se for menor eu seto ele a esquerda
                    }else{
                        atual.pai.direita = filhosubstituto;                     // se for maior eu seto ele a direita
                    }
                }
            } else if (atual.esquerda != null) {                            // se tem apenas um filho a esquerda

                filhosubstituto = atual.esquerda;     // salvando o filho que se encontra a esquerda

                if (root == atual) {
                    root = filhosubstituto;
                }else{

                    if (filhosubstituto.dado.compareTo(atual.pai.dado) == -1){   // mesmo processo que acontece se tiver um filho a direita
                        atual.pai.esquerda = filhosubstituto;
                    }else{
                        atual.pai.direita = filhosubstituto;
                    }
                }

            }
            // Quando não se tem filhos
            else {
                if (atual == root){
                    root = null;
                }else {
                    if (atual.dado.compareTo(atual.pai.dado) == -1){            // está comparando se o valor está a direita ou a esquerda do seu pai
                        atual.pai.esquerda = null;                               // se estiver a direita então o pai está setando como null a sua direita removendo o elemento
                    }else {
                        atual.pai.direita = null;                                // se estiver a esquerda então o pai está setando como null a sua direita removendo o elemento
                    }
                }

            }

        }
    }

    public void emOrdem(No<T> no){
        if (no != null){
            emOrdem(no.esquerda);
            System.out.println(no.dado);
            emOrdem(no.direita);
        }
    }

    public void preOrdem(No<T> no){
        System.out.println(no.dado);
        if (no.esquerda != null){
            preOrdem(no.esquerda);
        }
        if (no.direita != null){
            preOrdem(no.direita);
        }

    }
    public void posOrdem(No<T> no){
        if (no != null){
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.println(no.dado);
        }
    }






}
