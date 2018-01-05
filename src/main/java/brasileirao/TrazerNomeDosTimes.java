package brasileirao;

import java.util.List;

public class TrazerNomeDosTimes {

    public static void main(String[] args) {
        List<Registro> tabelaBrasileiraoA = TimeUtils.gerarRegistros();

        //Não precisa coletar para uma lista
        tabelaBrasileiraoA.stream()
                .map(Registro::getTime)
                .forEach(System.out::println);
    }
}
