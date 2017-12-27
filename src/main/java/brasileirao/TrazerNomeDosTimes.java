package brasileirao;

import java.util.List;
import java.util.stream.Collectors;

public class TrazerNomeDosTimes {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        tabelaBrasileiraoA.stream()
                .map(Registro::getTime)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
