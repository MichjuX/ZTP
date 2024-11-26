public class ZTP06 {
    public static void main(String[] args) {
        IMessageBox messageBox = new MessageBox();
        messageBox = new BlockingMessageBoxDecorator(messageBox, "zakazane");
        messageBox = new BlockingGetMessageDecorator(messageBox, "zakazane");
        messageBox = new DateMessageBoxDecorator(messageBox);
        messageBox = new ReadFlagMessageBoxDecorator(messageBox);

        messageBox.addMessage(new Message("Spotkanie zespołu", "Spotkanie odbędzie się jutro o 10:00."));
        messageBox.addMessage(new Message("Zakazany komunikat", "Ta wiadomość zawiera zakazane słowo."));
        messageBox.addMessage(new Message("Wyniki kwartalne", "Zysk wzrósł o 15% w ostatnim kwartale."));

        messageBox.displayAllMessageTitles();

        for (int id = 1; id <= 3; id++) {
            IMessage message = messageBox.getMessageById(id);
            if (message != null) {
                System.out.println("\nID: " + message.getId());
                System.out.println("Tytuł: " + message.getTitle());
                System.out.println("Treść: " + message.getContent());
            } else {
                System.out.println("Nie znaleziono wiadomości o ID: " + id);
            }
        }

        System.out.println("\nLista tytułów wiadomości (po odczytaniu):");
        messageBox.displayAllMessageTitles();

    }
}
