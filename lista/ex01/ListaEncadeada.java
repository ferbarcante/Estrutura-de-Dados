public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;


    private final int NAO_ENCONTRADO = -1;
    private final String LISTA_VAZIA = "Lista está vazia";


    public void adiciona(T elemento){
        No<T> celula = new No<T>(elemento);
        if(this.tamanho == 0){
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }


    public int busca(T elemento){
        No<T> noAtual = this.inicio;
        int pos = 0;


        while (noAtual != null){
            if(noAtual.getElemento().equals(elemento) ){
                return pos;
            }


            pos++;
            noAtual = noAtual.getProximo();
        }
        return NAO_ENCONTRADO;
    }


    private boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }


    private No<T> buscaNo(int posicao) {


        if (this.posicaoNaoExiste(posicao)) {
            throw new RuntimeException("Não encontrado");
        }


        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }


        return noAtual;
    }


    public T removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;


        if (this.tamanho == 0) {
            this.ultimo = null;
        }


        return removido;
    }


    public T removeDoFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;


        return removido;
    }
    public T remove(int posicao){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException("Essa posição não existe.");
        }


        if (posicao == 0){
            return this.removeInicio();
        } else if (posicao == this.tamanho - 1){
            return this.removeDoFinal();
        }


        No<T> noAnterior = this.buscaNo(posicao - 1);
        No<T> atual = noAnterior.getProximo();
        No<T> proximo = atual.getProximo();
        noAnterior.setProximo(proximo);


        this.tamanho--;
        return atual.getElemento();
    }
    public int getTamanho(){
        return this.tamanho;
    }
    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio=" + inicio +
                '}';
    }
}
