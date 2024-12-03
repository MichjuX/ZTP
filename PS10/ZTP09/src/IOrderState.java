interface IOrderState {
    void addProduct(Order order, String product);
    void submitOrder(Order order);
    void confirmPayment(Order order);
    void packProduct(Order order, String product);
    void shipOrder(Order order);
    void cancelOrder(Order order);
    void showOrderDetails(Order order);
}
