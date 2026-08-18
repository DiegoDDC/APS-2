public class Banco {
    private String nome;
    private String cpf;
    private double saldo;

    public Banco (String novoNome, String novoCPF, double novoSaldo) {
        this.setNome(novoNome);
        this.cpf = novoCPF;
        this.saldo = novoSaldo;
    }

    public Banco () {
        this.setNome("Sem nome");
        this.cpf = "sem cpf";
        this.saldo = 0;
    }

    public String getNome () {
        return nome;
    }

    public void seNome(String nome) {
        this.nome = nome;
    }
}
