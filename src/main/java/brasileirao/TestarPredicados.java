package brasileirao;

import java.util.List;

public class TestarPredicados {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        System.out.println("Existe o Bahia no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .map(Registro::getTime)
                        .anyMatch("Bahia"::equals));

        System.out.println("Existe o Tubarão no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .map(Registro::getTime)
                        .anyMatch("Tubarão"::equals));

        System.out.println("Não existe o Tubarão no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .map(Registro::getTime)
                        .noneMatch("Tubarão"::equals));

        System.out.println("Todos os times ganharam aos menos uma partida no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .allMatch(registro -> registro.getVitorias() > 0));

    }
}
