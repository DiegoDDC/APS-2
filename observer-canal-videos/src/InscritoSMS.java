public class InscritoSMS implements Observer {
    private String telefone;

    public InscritoSMS(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void update(String canal, String titulo) {
        System.out.println("Notificação (SMS) para " + telefone + ": " + canal + " postou \"" + titulo + "\"");
    }
}