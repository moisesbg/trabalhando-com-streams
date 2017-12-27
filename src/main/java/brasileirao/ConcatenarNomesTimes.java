package brasileirao;


import java.util.List;

public class ConcatenarNomesTimes {
    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        String nomes = tabelaBrasileiraoA.stream()
                .map(registro -> registro.getTime()+"  ")
                .reduce(String::concat)
                .orElse("");

        System.out.println(nomes);

        System.out.println("----- Outra forma de imprimir os nomes ---------");
        tabelaBrasileiraoA.stream()
                .map(registro -> registro.getTime()+"  ")
                .reduce(String::concat)
                .ifPresent(System.out::println);
    }
}
