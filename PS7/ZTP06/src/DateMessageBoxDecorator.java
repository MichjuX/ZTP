import java.time.LocalDate;

class DateMessageBoxDecorator extends MessageBoxDecorator {
    private LocalDate startDate = LocalDate.now().minusDays(7);

    public DateMessageBoxDecorator(IMessageBox decoratedBox) {
        super(decoratedBox);
    }

    @Override
    public void addMessage(IMessage message) {
        String dateInfo = "\nData wysłania: " + startDate.plusDays(1).toString();
        message.setContent(message.getContent() + dateInfo);
        super.addMessage(message);
    }
}