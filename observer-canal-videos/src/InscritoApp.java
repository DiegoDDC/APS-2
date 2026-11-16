public class InscritoApp implements Observer {
    private String nome;

    public InscritoApp(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String canal, String titulo) {
        System.out.println("Notificação (App) para " + nome + ": " + canal + " postou \"" + titulo + "\"");
    }
}