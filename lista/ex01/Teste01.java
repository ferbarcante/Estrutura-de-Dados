public class Teste01 {
    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(4);
        lista.adiciona(2);
        lista.adiciona(6);
        lista.adiciona(7);
        
        System.out.println(lista);

        lista.remove(2);

        System.out.println(lista);
        System.out.println(lista.busca(1));

    }
}