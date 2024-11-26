import java.util.ArrayList;
import java.util.List;

class MessageBox implements IMessageBox {
    private List<IMessage> messages = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void addMessage(IMessage message) {
        message.setId(nextId++);
        messages.add(message);
    }

    @Override
    public IMessage getMessageById(int id) {
        for (IMessage message : messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }

    @Override
    public void displayAllMessageTitles() {
        System.out.println("\nLista wiadomości:");
        if (messages.isEmpty()) {
            System.out.println("Brak wiadomości w skrzynce.");
        } else {
            for (IMessage message : messages) {
                System.out.println("ID: " + message.getId() + " - " + message.getTitle());
            }
        }
    }
}