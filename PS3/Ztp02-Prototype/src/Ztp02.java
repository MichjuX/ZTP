import java.util.ArrayList;
import java.util.List;

// Klasa reprezentująca komórkę tabeli
class Cell {
    private String value;

    public Cell(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%-15s", value);
    }
}

// Klasa reprezentująca nagłówek kolumny w tabeli
class Header
{
    private String name;

    public Header(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Klasa reprezentująca tabelę
class Table {
    private List<Header> headers = new ArrayList<>();  // Lista nagłówków kolumn
    private List<List<Cell>> rows = new ArrayList<>(); // Lista wierszy (każdy wiersz to lista komórek)

    public void addColumn(Header header) {
        headers.add(header);

        // Dodajemy puste komórki do każdego z istniejących wierszy
        for (List<Cell> row : rows) {
            row.add(new Cell(""));
        }
    }

    public void addRow(String... cellValues) {
        if (cellValues.length != headers.size()) {
            throw new IllegalArgumentException("Liczba wartości nie zgadza się z liczbą kolumn.");
        }

        // Dodajemy wiersz wypełniony komórkami z wartością
        List<Cell> newRow = new ArrayList<>();
        for (String value : cellValues) {
            newRow.add(new Cell(value));
        }
        rows.add(newRow);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Dodajemy nagłówki
        for (Header header : headers) {
            sb.append(String.format("%-15s", header.getName()));
        }
        sb.append("\n");

        // Separator
        sb.append("-".repeat(headers.size() * 15)).append("\n");

        // Dodajemy wiersze
        for (List<Cell> row : rows) {
            for (Cell cell : row) {
                sb.append(cell.toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

public class Ztp02 {
    public static void main(String[] args) {
        // Tworzymy tabelę
        Table table = new Table();

        // Dodajemy kolumny
        table.addColumn(new Header("Name"));
        table.addColumn(new Header("Age"));
        table.addColumn(new Header("City"));

        // Dodajemy wiersze
        table.addRow("Alice", "30", "New York");
        table.addRow("Bob", "25", "Los Angeles");
        table.addRow("Charlie", "35", "Chicago");

        // Wyświetlamy tabelę
        System.out.println(table.toString());
    }
}

