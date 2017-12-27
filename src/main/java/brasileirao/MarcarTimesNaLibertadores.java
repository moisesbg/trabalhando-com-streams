package brasileirao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MarcarTimesNaLibertadores {
    public static final int QTD_TIMES_LIBERTADORES = 8;

    public static void main(String[] args) {

        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        System.out.println("--- impressão tabela original -----");
        tabelaBrasileiraoA.forEach(registro -> System.out.println("Time: "+registro.getTime()
                + " - Pontos: "+registro.getPontos()+" - Libertadores: "+registro.isLibertadores()));

        tabelaBrasileiraoA
                .sort(Comparator.comparingInt(Registro::getPontos).reversed());

        tabelaBrasileiraoA
                .subList(0,8)
                .forEach(registro -> registro.setLibertadores(true));

        System.out.println("--- impressão tabela alterada -----");
        tabelaBrasileiraoA.forEach(registro -> System.out.println("Time: "+registro.getTime()
                + " - Pontos: "+registro.getPontos()+" - Libertadores: "+registro.isLibertadores()));



        //Utilizando stream
        tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        tabelaBrasileiraoA.stream()
                .sorted(Comparator.comparingInt(Registro::getPontos).reversed())
                .collect(Collectors.toList())
                .subList(0,8)
                .forEach(registro -> registro.setLibertadores(true));

        System.out.println("--- impressão tabela com stream  -----");
        tabelaBrasileiraoA.forEach(registro -> System.out.println("Time: "+registro.getTime()
                + " - Pontos: "+registro.getPontos()+" - Libertadores: "+registro.isLibertadores()));

    }
}
