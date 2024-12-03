import java.util.HashMap;
import java.util.Map;

class Order {
    private Map<String, Boolean> products = new HashMap<>();
    private IOrderState currentState;
    private boolean isPaid = false;

    public Order() {
        currentState = new CreatedState(); // Domyślny stan początkowy
    }

    public void setState(IOrderState state) {
        currentState = state;
    }

    public Map<String, Boolean> getProducts() {
        return products;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void addProduct(String product) {
        currentState.addProduct(this, product);
    }

    public void submitOrder() {
        currentState.submitOrder(this);
    }

    public void confirmPayment() {
        currentState.confirmPayment(this);
    }

    public void packProduct(String product) {
        currentState.packProduct(this, product);
    }

    public void shipOrder() {
        currentState.shipOrder(this);
    }

    public void cancelOrder() {
        currentState.cancelOrder(this);
    }

    public void showOrderDetails() {
        currentState.showOrderDetails(this);
    }
}
