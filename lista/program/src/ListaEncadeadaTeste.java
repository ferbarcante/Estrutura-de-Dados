public class ListaEncadeadaTeste {
    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(5);
        lista.adiciona(2);
        lista.adiciona(7);
        lista.adiciona(3);
        lista.adiciona(1);

        System.out.println(lista);

        lista.inverter();

        System.out.println(lista);
    }
}