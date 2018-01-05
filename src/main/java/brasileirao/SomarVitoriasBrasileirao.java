package brasileirao;

import java.util.List;

public class SomarVitoriasBrasileirao {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        int vitorias = tabelaBrasileiraoA.stream()
                .mapToInt(Registro::getVitorias)
                .sum();

        System.out.println("Total de vitórias: " + vitorias);

        vitorias = tabelaBrasileiraoA.stream()
                .map(Registro::getVitorias)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total de vitorias: " + vitorias);

        vitorias = tabelaBrasileiraoA.stream()
                .map(Registro::getVitorias)
                .reduce(0, Integer::sum);

        System.out.println("Total de vitorias: " + vitorias);

    }
}
