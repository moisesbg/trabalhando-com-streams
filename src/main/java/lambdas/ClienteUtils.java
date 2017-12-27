package lambdas;

import java.util.Arrays;
import java.util.List;

public class ClienteUtils {

    public static List<Cliente> gerarLista() {
        return Arrays.asList(
                new Cliente("Leandro", 23),
                new Cliente("Íris", 100),
                new Cliente("João", 0),
                new Cliente("Alice", 44));
    }

    public static void imprimirLista(List<Cliente> clientes) {
        clientes.forEach(cliente -> System.out.println("Nome: "+ cliente.getNome()
                +" - Pontos: "+ cliente.getPontos()
                +" - Preferencial: "+cliente.isPreferencial()));
    }
}
