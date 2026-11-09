public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("queijo");
        System.out.println("Pedido: " + pizza);

        pizza = nyStore.orderPizza("mariscos");
        System.out.println("Pedido: " + pizza);
    }
}