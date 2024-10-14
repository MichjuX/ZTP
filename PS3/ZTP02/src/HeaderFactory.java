public class HeaderFactory {
    public static Header<?> createHeader(String name, Object sampleValue) {
        if (sampleValue instanceof String) {
            return new TextHeader(name);
        } else if (sampleValue instanceof Number) {
            return new NumberHeader(name);
        } else if (sampleValue instanceof Boolean) {
            return new BooleanHeader(name);
        } else {
            throw new IllegalArgumentException("Nieobsługiwany typ danych dla nagłówka.");
        }
    }
}
