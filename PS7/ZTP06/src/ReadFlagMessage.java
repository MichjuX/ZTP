class ReadFlagMessage implements IMessage {
    private IMessage originalMessage;
    private boolean isRead = false;

    public ReadFlagMessage(IMessage originalMessage) {
        this.originalMessage = originalMessage;
    }

    @Override
    public int getId() {
        return originalMessage.getId();
    }

    @Override
    public void setId(int id) {
        originalMessage.setId(id);
    }

    @Override
    public String getTitle() {
        return (isRead ? "[Odczytana] " : "[Nowa] ") + originalMessage.getTitle();
    }

    @Override
    public void setTitle(String title) {
        originalMessage.setTitle(title);
    }

    @Override
    public String getContent() {
        isRead = true;
        return originalMessage.getContent();
    }

    @Override
    public void setContent(String content) {
        originalMessage.setContent(content);
    }
}
