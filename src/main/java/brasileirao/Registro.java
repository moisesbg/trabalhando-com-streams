package brasileirao;

public class Registro {
    private String time;

    private int pontos;

    private int vitorias;

    private int empates;

    private int derrotas;

    private boolean libertadores;

    private boolean rebaixado;

    public Registro(String time, int pontos, int vitorias, int empates, int derrotas) {
        this.time = time;
        this.pontos = pontos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.libertadores = false;
        this.rebaixado = false;
    }

    public String getTime() {
        return time;
    }

    public int getPontos() {
        return pontos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public boolean isLibertadores() {
        return libertadores;
    }

    public void setLibertadores(boolean libertadores) {
        this.libertadores = libertadores;
    }

    public boolean isRebaixado() {
        return rebaixado;
    }

    public void setRebaixado(boolean rebaixado) {
        this.rebaixado = rebaixado;
    }
}
