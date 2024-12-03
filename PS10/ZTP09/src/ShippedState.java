class ShippedState implements IOrderState {
    @Override
    public void addProduct(Order order, String product) {
        System.out.println("Nie można dodawać produktów do wysłanego zamówienia.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Nie można ponownie złożyć wysłanego zamówienia.");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Płatność dla wysłanego zamówienia została już potwierdzona.");
    }

    @Override
    public void packProduct(Order order, String product) {
        System.out.println("Nie można pakować produktów w wysłanym zamówieniu.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Zamówienie zostało już wysłane.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Nie można anulować zamówienia, które zostało już wysłane.");
    }

    @Override
    public void showOrderDetails(Order order) {
        System.out.println("Zamówienie [Wysłane]:");
        order.getProducts().forEach((product, packed) ->
                System.out.println(" - " + product + ": " + (packed ? "Spakowany" : "Nie spakowany"))
        );
    }
}
