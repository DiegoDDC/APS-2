public class Principal {

    public static void main(string[] args){
        Banco b3 = new Banco ("José", "111", 10);

        System.out.println(b3.getNome());
        b3.setNome("Joaquim");
        System.out.println(b3.getNome());
    }
}
