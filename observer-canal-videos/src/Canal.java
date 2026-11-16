import java.util.ArrayList;
import java.util.List;

public class Canal implements Subject {
    private String nome;
    private List<Observer> inscritos = new ArrayList<>();
    private String ultimoVideo;

    public Canal(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(Observer observer) {
        inscritos.add(observer);
    }

    @Override
    public void remover(Observer observer) {
        inscritos.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer inscrito : inscritos) {
            inscrito.update(nome, ultimoVideo);
        }
    }

    public void publicarVideo(String titulo) {
        this.ultimoVideo = titulo;
        System.out.println("[" + nome + "] Novo vídeo publicado: " + titulo);
        notificar();
    }
}