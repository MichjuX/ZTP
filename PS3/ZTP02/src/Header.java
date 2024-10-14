// Abstrakcyjna klasa Header z generykiem <T>
public abstract class Header<T> {
    private String name;

    public Header(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Cell<T> createCell(T value);
    public abstract Cell<T> createDefaultCell();
}
