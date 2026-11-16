public class InscritoEmail implements Observer {
    private String email;

    public InscritoEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(String canal, String titulo) {
        System.out.println("Notificação (E-mail) para " + email + ": " + canal + " postou \"" + titulo + "\"");
    }
}