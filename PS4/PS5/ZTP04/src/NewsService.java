import java.util.ArrayList;
import java.util.List;

class NewsService implements INewsService {
    private List<Message> messages = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Response addMessage(String title, String content) {
        Message message = new Message(nextId++, title, content);
        messages.add(message);
        return new Response("Success", "Message added successfully.");
    }

    @Override
    public Response readMessage(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                return new Response("Success", message.getTitle() + ": " + message.getContent());
            }
        }
        return new Response("Error", "Message not found.");
    }

    @Override
    public Response editMessage(int id, String newContent) {
        for (Message message : messages) {
            if (message.getId() == id) {
                message.setContent(newContent);
                return new Response("Success", "Message edited successfully.");
            }
        }
        return new Response("Error", "Message not found.");
    }

    @Override
    public Response deleteMessage(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                messages.remove(message);
                return new Response("Success", "Message deleted successfully.");
            }
        }
        return new Response("Error", "Message not found.");
    }
}
