public class Ztp02 {
    public static void main(String[] args) {
        Table table = new Table();

        // Dodajemy kolumny z automatycznym rozpoznawaniem typu
        table.addColumn("Name", "Alice");  // Nagłówek tekstowy
        table.addColumn("Age", 30);        // Nagłówek liczbowy
        table.addColumn("Active", true);   // Nagłówek logiczny

        // Dodawanie wierszy z danymi
        table.addRow("Alice", 30, true);
        table.addRow("Bob", 25, false);

        // Wyświetlenie tabeli
        System.out.println(table);
    }
}
