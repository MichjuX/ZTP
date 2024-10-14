// Abstrakcyjna klasa Cell
public abstract class Cell<T> {
    private T value;

    public Cell(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%-15s", value.toString());
    }
}