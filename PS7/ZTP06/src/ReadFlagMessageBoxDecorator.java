class ReadFlagMessageBoxDecorator extends MessageBoxDecorator {
    public ReadFlagMessageBoxDecorator(IMessageBox decoratedBox) {
        super(decoratedBox);
    }

    @Override
    public IMessage getMessageById(int id) {
        IMessage message = super.getMessageById(id);
        if (message != null) {
            return new ReadFlagMessage(message);
        }
        return null;
    }
}