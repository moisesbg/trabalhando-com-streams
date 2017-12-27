package brasileirao;

import java.util.List;

public class SomarVitoriasBrasileirao {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        int vitorias = tabelaBrasileiraoA.stream()
                .mapToInt(Registro::getVitorias)
                .sum();

        System.out.println("Total de vitórias: "+vitorias);

        int valorInicial = 0;
        vitorias = tabelaBrasileiraoA.stream()
                .map(Registro::getVitorias)
                .reduce(valorInicial, (a, b) -> a + b);

        System.out.println("Total de vitorias: "+vitorias);

        vitorias = tabelaBrasileiraoA.stream()
                .map(Registro::getVitorias)
                .reduce(valorInicial, Integer::sum);

        System.out.println("Total de vitorias: "+vitorias);

    }
}
