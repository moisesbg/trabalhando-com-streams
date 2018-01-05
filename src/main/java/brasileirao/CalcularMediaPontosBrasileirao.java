package brasileirao;


import java.util.List;

public class CalcularMediaPontosBrasileirao {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        //Cuidado ao acessar um valor "Optional" sem verificar se ele está presente
        Double media = tabelaBrasileiraoA.stream()
                .mapToInt(Registro::getPontos)
                .average()
                .getAsDouble();

        System.out.println("Media de pontos  = "+media);

        media = tabelaBrasileiraoA.stream()
                .mapToInt(Registro::getPontos)
                .average()
                .orElse(0);

        System.out.println("Media de pontos  = "+media);
    }
}
