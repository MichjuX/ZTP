import java.util.HashMap;
import java.util.Map;

class NewsServiceProxy implements INewsService {
    private final NewsService newsService;
    private final User user;
    private final Map<Integer, Response> cache = new HashMap<>();

    public NewsServiceProxy(NewsService newsService, User user) {
        this.newsService = newsService;
        this.user = user;
    }

    @Override
    public Response addMessage(String title, String content) {
        if (user.getRole() == UserRole.GUEST) {
            return new Response("Error", "Access denied.");
        }
        Response response = newsService.addMessage(title, content);
        cache.clear();
        return response;
    }

    @Override
    public Response readMessage(int id) {
        if (cache.containsKey(id)) {
            System.out.println("Returning cached result for message ID " + id);
            return cache.get(id);
        }
        Response response = newsService.readMessage(id);
        if (response.getStatus().equals("Success")) {
            cache.put(id, response);
        }
        return response;
    }

    @Override
    public Response editMessage(int id, String newContent) {
        if (user.getRole() != UserRole.MODERATOR && user.getRole() != UserRole.ADMIN) {
            return new Response("Error", "Access denied.");
        }
        Response response = newsService.editMessage(id, newContent);
        cache.remove(id);
        return response;
    }

    @Override
    public Response deleteMessage(int id) {
        if (user.getRole() != UserRole.ADMIN) {
            return new Response("Error", "Access denied.");
        }
        Response response = newsService.deleteMessage(id);
        cache.remove(id);
        return response;
    }
}