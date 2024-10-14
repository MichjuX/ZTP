public class NumberHeader extends Header<Number> {
    public NumberHeader(String name) {
        super(name);
    }

    @Override
    public Cell<Number> createCell(Number value) {
        return new NumberCell(value);
    }

    @Override
    public Cell<Number> createDefaultCell() {
        return new NumberCell(0);
    }
}