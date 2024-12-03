class PaidState implements IOrderState {
    @Override
    public void addProduct(Order order, String product) {
        System.out.println("Nie można dodawać produktów do opłaconego zamówienia.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Zamówienie zostało już opłacone.");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Płatność została już potwierdzona.");
    }

    @Override
    public void packProduct(Order order, String product) {
        if (!order.getProducts().containsKey(product)) {
            System.out.println("Produkt " + product + " nie znajduje się w zamówieniu.");
            return;
        }
        if (order.getProducts().get(product)) {
            System.out.println("Produkt " + product + " został już spakowany.");
            return;
        }
        order.getProducts().put(product, true);
        System.out.println("Produkt " + product + " został spakowany.");
    }

    @Override
    public void shipOrder(Order order) {
        if (order.getProducts().values().stream().anyMatch(packed -> !packed)) {
            System.out.println("Nie można wysłać zamówienia, ponieważ nie wszystkie produkty zostały spakowane.");
            return;
        }
        order.setState(new ShippedState());
        System.out.println("Zamówienie zostało wysłane.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Zamówienie zostało anulowane. Środki zwrócone.");
        order.setState(new CancelledState());
    }

    @Override
    public void showOrderDetails(Order order) {
        System.out.println("Zamówienie [Opłacone]:");
        order.getProducts().forEach((product, packed) ->
                System.out.println(" - " + product + ": " + (packed ? "Spakowany" : "Nie spakowany"))
        );
    }
}
