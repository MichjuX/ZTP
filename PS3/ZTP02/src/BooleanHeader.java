public class BooleanHeader extends Header<Boolean> {
    public BooleanHeader(String name) {
        super(name);
    }

    @Override
    public Cell<Boolean> createCell(Boolean value) {
        return new BooleanCell(value);
    }

    @Override
    public Cell<Boolean> createDefaultCell() {
        return new BooleanCell(false);
    }
}