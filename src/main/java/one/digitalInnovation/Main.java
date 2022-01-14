package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();
        System.out.println(lista);

        lista.add("1");
        lista.add("2");
        lista.add("3");
        lista.add("4");
        System.out.println(lista);

        lista.remove(0);
        System.out.println(lista);

        for(int i = 0; i<20; i++){
            System.out.println(lista.getConteudo(i));
        }


    }
}
