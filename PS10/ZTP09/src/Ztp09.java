import java.util.HashMap;
import java.util.Map;

public class Ztp09 {
    // Program główny
    public static void main(String[] args) {
        Order order = new Order();

        // Dodawanie produktów
        order.addProduct("Laptop");
        order.addProduct("Myszka");
        order.showOrderDetails();

        // Złożenie zamówienia
        order.submitOrder();

        // Potwierdzenie płatności
        order.confirmPayment();

        // Spakowanie produktów
        order.packProduct("Laptop");
        order.packProduct("Myszka");
        order.showOrderDetails();

        // Wysłanie zamówienia
        order.shipOrder();
    }
}
