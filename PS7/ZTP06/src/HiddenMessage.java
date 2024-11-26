class HiddenMessage implements IMessage {
    @Override
    public int getId() {
        return -1;
    }

    @Override
    public void setId(int id) {}

    @Override
    public String getTitle() {
        return "[Ukryta wiadomość]";
    }

    @Override
    public void setTitle(String title) {}

    @Override
    public String getContent() {
        return "";
    }

    @Override
    public void setContent(String content) {}
}


