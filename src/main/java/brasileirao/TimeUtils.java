package brasileirao;

import java.util.Arrays;
import java.util.List;

public class TimeUtils {

    public static List<Registro> gerarRegistros() {
        return Arrays.asList(
                new Registro("Botafogo", 53, 14, 11, 13),
                new Registro("Gremio", 62, 18, 8, 12),
                new Registro("Vasco", 56, 15, 11, 12),
                new Registro("Flamengo", 56, 15, 11, 12),
                new Registro("Palmeiras", 63, 19, 6, 13),
                new Registro("Bahia", 50, 13, 11, 14),
                new Registro("Chapecoense", 54, 15, 9, 14),
                new Registro("Cruzeiro", 57, 15, 12, 11),
                new Registro("Atletico-MG", 54, 14, 12, 12),
                new Registro("Santos", 63, 17, 12, 9),
                new Registro("Coritiba", 43, 11, 10, 17),
                new Registro("Atletico-PR", 51, 14, 9, 15),
                new Registro("Avai", 43, 10, 13, 15),
                new Registro("Ponte Preta", 39, 10, 9, 19),
                new Registro("Corintians", 72, 21, 9, 8),
                new Registro("Fluminense", 47, 11, 14, 13),
                new Registro("Atletico-GO", 36, 9, 9, 20),
                new Registro("Sport", 45, 12, 9, 17),
                new Registro("Vitoria", 43, 11, 10, 17),
                new Registro("São Paulo", 50, 13, 11, 14)
        );
    }
}
