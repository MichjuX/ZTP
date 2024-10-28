public class Ztp04P {
    public static void main(String[] args) {
        NewsService realService = new NewsService();
        User adminUser = new User("Alice", UserRole.ADMIN);
        INewsService proxyService = new NewsServiceProxy(realService, adminUser);

        // Adding messages
        System.out.println(proxyService.addMessage("Breaking News", "Major update in software."));
        System.out.println(proxyService.addMessage("Market Update", "Stocks hit record highs."));

        // Reading a message (first time - uncached)
        System.out.println(proxyService.readMessage(1));

        // Reading the same message (should be cached)
        System.out.println(proxyService.readMessage(1));

        // Editing the message (cache should be cleared for ID 1)
        System.out.println(proxyService.editMessage(1, "Updated content for breaking news."));

        // Reading the message after edit (uncached again)
        System.out.println(proxyService.readMessage(1));
    }
}
