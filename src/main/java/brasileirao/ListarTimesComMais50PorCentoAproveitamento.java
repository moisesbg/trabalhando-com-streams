package brasileirao;


import java.util.List;

public class ListarTimesComMais50PorCentoAproveitamento {

    // 38 * 3 / 2
    public static final int PONTOS_50_POR_CENTO = 57;

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        tabelaBrasileiraoA.stream()
                .filter(registro -> registro.getPontos() >= 57)
                .forEach(registro -> System.out.println("Time: " + registro.getTime() + " - Pontos: " + registro.getPontos()));

        System.out.println("------ imprimir tabela original ----------");
        tabelaBrasileiraoA.forEach(registro -> System.out.println("Time: " + registro.getTime() + " - Pontos: " + registro.getPontos()));
    }
}
