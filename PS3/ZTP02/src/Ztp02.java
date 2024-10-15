public class Ztp02 {
    public static void main(String[] args) {
        Table table = new Table();

        // Automatyczne rozpoznawanie typu przy dodawaniu kolumn
        table.addColumn("Name", "Alice");
        table.addColumn("Age", 30);
        table.addColumn("Active", true);

        // Dodawanie wierszy z danymi
        table.addRow("Alice", 30, true);
        table.addRow("Bob", 25, false);

        System.out.println(table); // Pytanie: jak z tym .toString()?
    }
}
