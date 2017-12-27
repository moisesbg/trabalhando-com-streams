package lambdas;

public class Cliente {
    private String nome;
    private Integer pontos;
    private boolean preferencial;

    public Cliente(String nome, Integer pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public boolean isPreferencial() {
        return preferencial;
    }
}
