public class TextHeader extends Header<String> {
    public TextHeader(String name) {
        super(name);
    }

    @Override
    public Cell<String> createCell(String value) {
        return new TextCell(value);
    }

    @Override
    public Cell<String> createDefaultCell() {
        return new TextCell("");
    }
}