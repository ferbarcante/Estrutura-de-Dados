public class ListaEncadeada03<T extends Comparable<T>> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    private final int NAO_ENCONTRADO = -1;
    private final String LISTA_VAZIA = "Lista está vazia";

    public void adiciona(T elemento){
        adicionaOrdenado(elemento);
    }

    private void adicionaOrdenado(T elemento) {
        No<T> novoNo = new No<T>(elemento);

        if (tamanho == 0) {
            inicio = novoNo;
            ultimo = novoNo;
        } else if (elemento.compareTo(inicio.getElemento()) < 0) { // Inserção no início
            novoNo.setProximo(inicio);
            inicio = novoNo;
        } else if (elemento.compareTo(ultimo.getElemento()) >= 0) { // Inserção no final
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        } else { //meio
            No<T> atual = inicio;
            while (atual.getProximo() != null && elemento.compareTo(atual.getProximo().getElemento()) >= 0) {
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
        }
        tamanho++;
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
    public void inverter() {
        No<T> anterior = null;
        No<T> atual = inicio;
        No<T> proximo;

        while (atual != null) {
            proximo = atual.getProximo();

            atual.setProximo(anterior);

            anterior = atual;
            atual = proximo;
        }

        ultimo = inicio;
        inicio = anterior;
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
