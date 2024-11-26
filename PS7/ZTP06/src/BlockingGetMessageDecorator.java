class BlockingGetMessageDecorator extends MessageBoxDecorator {
    private String forbiddenWord;
    private IMessage hiddenMessage = new HiddenMessage();

    public BlockingGetMessageDecorator(IMessageBox decoratedBox, String forbiddenWord) {
        super(decoratedBox);
        this.forbiddenWord = forbiddenWord;
    }

    @Override
    public IMessage getMessageById(int id) {
        IMessage message = super.getMessageById(id);
        if (message != null && message.getContent().contains(forbiddenWord)) {
            return hiddenMessage;
        }
        return message;
    }
}