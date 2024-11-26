interface IMessageBox {
    void addMessage(IMessage message);
    IMessage getMessageById(int id);
    void displayAllMessageTitles();
}