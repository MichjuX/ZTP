class SubmittedState implements IOrderState {
    @Override
    public void addProduct(Order order, String product) {
        System.out.println("Nie można dodawać produktów do złożonego zamówienia.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Zamówienie zostało już złożone.");
    }

    @Override
    public void confirmPayment(Order order) {
        order.setPaid(true);
        order.setState(new PaidState());
        System.out.println("Płatność została potwierdzona.");
    }

    @Override
    public void packProduct(Order order, String product) {
        System.out.println("Nie można spakować produktów w stanie złożonego zamówienia.");
    }

    @Override
    public void shipOrder(Order order) {
        System.out.println("Nie można wysłać zamówienia w stanie złożonego zamówienia.");
    }

    @Override
    public void cancelOrder(Order order) {
        order.setState(new CancelledState());
        System.out.println("Zamówienie zostało anulowane.");
    }

    @Override
    public void showOrderDetails(Order order) {
        System.out.println("Zamówienie [Złożone]:");
        order.getProducts().forEach((product, packed) ->
                System.out.println(" - " + product + ": Nie spakowany")
        );
    }
}
