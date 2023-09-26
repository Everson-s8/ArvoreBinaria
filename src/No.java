public class No<T>{
    
    public No<T> direita;
    public T dado;
    public No<T> esquerda;

    public No(T valor){
        dado = valor;
        direita = esquerda = null;
    }
}
