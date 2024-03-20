public class Teste02 {
    public static void main(String[] args) {
        ListaEncadeada02<Integer> lista = new ListaEncadeada02<>();

        lista.adiciona(5);
        lista.adiciona(2);
        lista.adiciona(7);
        lista.adiciona(3);
        lista.adiciona(1);

        System.out.println(lista);
    }
}
