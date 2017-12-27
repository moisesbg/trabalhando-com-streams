package lambdas;

import java.util.List;

public class TesteLambda {
    public static void main(String[] args) {
        List<Cliente> clientes = ClienteUtils.gerarLista();

        /*Como era iterar a lista no Java 7 */
        for (Cliente cliente: clientes) {
            System.out.println("Nome: "+cliente.getNome()+" - Pontos: "+cliente.getPontos());
        }

        /*Como é iterar a lista com lambda */
        clientes.forEach(cliente -> System.out.println(cliente.getNome()+" - Pontos: "+cliente.getPontos()));
    }
}
