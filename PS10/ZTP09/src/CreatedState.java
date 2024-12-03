class CreatedState implements IOrderState {
    @Override
    public void addProduct(Order order, String product) {
        if (order.getProducts().containsKey(product)) {
            System.out.println("Produkt już został dodany do zamówienia.");
            return;
        }
        order.getProducts().put(product, false);
        System.out.println("Dodano produkt: " + product);
    }

    @Override
    public void submitOrder(Order order) {
        if (order.getProducts().isEmpty()) {
            System.out.println("Nie można złożyć zamówienia bez produktów.");
            return;
        }
        order.setState(new SubmittedState());
        System.out.println("Zamówienie zostało złożone i oczekuje na opłatę.");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Nie można potwierdzić płatności w stanie nowego zamówienia.");
    }

    @Override
    public void packProduct(Order order, String product) {
        System.out.println("Nie można spakować produktów w stanie nowego zamówienia.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Nie można wysłać zamówienia w stanie nowego zamówienia.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
        System.out.println("Zamówienie zostało anulowane.");
    }

    @Override
    public void showOrderDetails(Order order) {
        System.out.println("Zamówienie [Nowe]:");
        order.getProducts().forEach((product, packed) ->
                System.out.println(" - " + product + ": Nie spakowany")
        );
    }
}
