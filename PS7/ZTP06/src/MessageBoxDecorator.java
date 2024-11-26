abstract class MessageBoxDecorator implements IMessageBox {
    protected IMessageBox decoratedBox;

    public MessageBoxDecorator(IMessageBox decoratedBox) {
        this.decoratedBox = decoratedBox;
    }

    @Override
    public void addMessage(IMessage message) {
        decoratedBox.addMessage(message);
    }

    @Override
    public IMessage getMessageById(int id) {
        return decoratedBox.getMessageById(id);
    }

    @Override
    public void displayAllMessageTitles() {
        decoratedBox.displayAllMessageTitles();
    }
}