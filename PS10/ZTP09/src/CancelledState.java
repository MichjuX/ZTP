class CancelledState implements IOrderState {
    @Override
    public void addProduct(Order order, String product) {
        System.out.println("Nie można dodawać produktów do anulowanego zamówienia.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Nie można złożyć anulowanego zamówienia.");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Nie można potwierdzić płatności dla anulowanego zamówienia.");
    }

    @Override
    public void packProduct(Order order, String product) {
        System.out.println("Nie można pakować produktów w anulowanym zamówieniu.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Nie można wysłać anulowanego zamówienia.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Zamówienie zostało już anulowane.");
    }

    @Override
    public void showOrderDetails(Order order) {
        System.out.println("Zamówienie [Anulowane]:");
        if (order.getProducts().isEmpty()) {
            System.out.println("Brak produktów w zamówieniu.");
        } else {
            order.getProducts().forEach((product, packed) ->
                    System.out.println(" - " + product + ": " + (packed ? "Spakowany" : "Nie spakowany"))
            );
        }
    }
}
