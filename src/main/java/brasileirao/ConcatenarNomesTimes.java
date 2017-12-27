package brasileirao;


import java.util.List;
import java.util.stream.Collectors;

public class ConcatenarNomesTimes {
    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        String nomes = tabelaBrasileiraoA.stream()
                .map(Registro::getTime)
                .collect(Collectors.joining("  "));

        System.out.println(nomes);

        System.out.println("----- Outra forma de imprimir os nomes ---------");
        // Evitar essa forma pois ela cria varios StringBuilder, uma para cada concatenação usando o operador +
        // Em java o correto é utilizar um unico StringBuilder para contruir Strings complexas.
        tabelaBrasileiraoA.stream()
                .map(registro -> registro.getTime() + "  ")
                .reduce(String::concat)
                .ifPresent(System.out::println);
    }
}
