public class Main {
    public static void main(String[] args) {
        Canal canal = new Canal("Tecnologia na Prática");

        Observer u1 = new InscritoApp("Lucas");
        Observer u2 = new InscritoEmail("mariana.silva@gmail.com");
        Observer u3 = new InscritoSMS("(83) 98842-1904");

        canal.adicionar(u1);
        canal.adicionar(u2);
        canal.adicionar(u3);

        canal.publicarVideo("Introdução a Padrões de Projeto em Java");

        System.out.println();
        canal.remover(u2);

        canal.publicarVideo("Entendendo Arquitetura Limpa");
    }
}