public class Teste03 {
    public static void main(String[] args) {
        ListaEncadeada03<Integer> lista = new ListaEncadeada03<>();

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
