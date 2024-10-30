public class Ztp04P {
    public static void main(String[] args) {
        NewsService realService = new NewsService();
        User adminUser = new User("Alice", UserRole.ADMIN);
        INewsService proxyService = new NewsServiceProxy(realService, adminUser);
        User guestUser = new User("Bob", UserRole.GUEST);
        INewsService proxyService2 = new NewsServiceProxy(realService, guestUser);

        System.out.println(proxyService.addMessage("Breaking News", "Major update in software."));
        System.out.println(proxyService.addMessage("Market Update", "Stocks hit record highs."));

        // Nie powinien cache
        System.out.println(proxyService.readMessage(1));

        // Powinien brać z cache
        System.out.println(proxyService.readMessage(1));

        // Cache powinien sie wyczyscic na id 1
        System.out.println(proxyService.editMessage(1, "Updated content for breaking news."));

        // Powinno nie być cache
        System.out.println(proxyService.readMessage(1));

        System.out.println(proxyService2.deleteMessage(1));
    }
}
