import java.util.*;

class Table {
    private List<Header<?>> headers = new ArrayList<>();  // Lista nagłówków kolumn
    private List<List<Cell<?>>> rows = new ArrayList<>(); // Lista wierszy (każdy wiersz to lista komórek)

    public void addColumn(String name, Object sampleValue) {
        Header<?> header = HeaderFactory.createHeader(name, sampleValue);
        headers.add(header);

        // Dodajemy domyślne komórki do każdego z istniejących wierszy
        for (List<Cell<?>> row : rows) {
            row.add(header.createDefaultCell());  // Tworzymy komórkę za pomocą nagłówka
        }
    }

    public void addRow(Object... cellValues) {
        if (cellValues.length != headers.size()) {
            throw new IllegalArgumentException("Liczba wartości nie zgadza się z liczbą kolumn.");
        }

        // Dodajemy wiersz wypełniony komórkami z wartościami
        List<Cell<?>> newRow = new ArrayList<>();
        for (int i = 0; i < cellValues.length; i++) {

            // Tu rzutowanie, żeby rozpoznać typy
            newRow.add(createCellForHeader(headers.get(i), cellValues[i]));
        }
        rows.add(newRow);
    }

    // Metoda to rzutowania, podaje typ nagłówka i wartość, zwraca komórkę odpowiedniego typu
    @SuppressWarnings("unchecked")
    private <T> Cell<T> createCellForHeader(Header<?> header, Object value) {
        return ((Header<T>) header).createCell((T) value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Dodajemy nagłówki
        for (Header<?> header : headers) {
            sb.append(String.format("%-15s", header.getName()));
        }
        sb.append("\n");

        // Separator
        sb.append("-".repeat(headers.size() * 15)).append("\n");

        // Dodajemy wiersze
        for (List<Cell<?>> row : rows) {
            for (Cell<?> cell : row) {
                sb.append(cell.toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
