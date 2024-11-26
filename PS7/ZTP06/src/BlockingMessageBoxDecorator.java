class BlockingMessageBoxDecorator extends MessageBoxDecorator {
    private String forbiddenWord;

    public BlockingMessageBoxDecorator(IMessageBox decoratedBox, String forbiddenWord) {
        super(decoratedBox);
        this.forbiddenWord = forbiddenWord;
    }

    @Override
    public void addMessage(IMessage message) {
        if (message.getContent().contains(forbiddenWord)) {
            System.out.println("Wiadomość została zablokowana.");
        } else {
            super.addMessage(message);
        }
    }
}