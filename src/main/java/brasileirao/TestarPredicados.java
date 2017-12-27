package brasileirao;

import java.util.List;

public class TestarPredicados {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        System.out.println("Existe o Bahia no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .anyMatch(registro -> "Bahia".equals(registro.getTime())));

        System.out.println("Existe o Tubarão no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .anyMatch(registro -> "Tubarão".equals(registro.getTime())));

        System.out.println("Não existe o Tubarão no brasileirão? " +
                tabelaBrasileiraoA.stream()
                        .noneMatch(registro -> "Tubarão".equals(registro.getTime())));

        System.out.println("Todos os times ganharam aos menos uma partida no brasileirão? "+
                tabelaBrasileiraoA.stream().allMatch(registro -> registro.getVitorias() > 0));

    }
}
