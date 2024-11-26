// Reprezentuje pojedynczą figurę szachową, w tym jej typ (np. pion, wieża)
// oraz kolor (biały lub czarny).
class ChessPiece {
    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING}

    public enum Color {WHITE, BLACK}

    private final Type type;
    private final Color color;

    public ChessPiece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    // Zwraca kod literowy figury, używany do wyświetlania jej na planszy.
    public char getCode() {
        // Dopasowanie litery do typu figury
        char baseCode = switch (type) {
            case PAWN -> 'P';
            case ROOK -> 'R';
            case KNIGHT -> 'N';
            case BISHOP -> 'B';
            case QUEEN -> 'Q';
            case KING -> 'K';
        };

        // Zwrócenie wielkiej litery dla białych figur, małej dla czarnych
        return color == Color.WHITE ? baseCode : Character.toLowerCase(baseCode);
    }

    // Tworzy obiekt figury szachowej na podstawie kodu literowego.
    public static ChessPiece fromCode(char code) {
        // Określenie koloru figury na podstawie wielkości litery
        Color color = Character.isUpperCase(code) ? Color.WHITE : Color.BLACK;

        // Dopasowanie typu figury do litery
        Type type = switch (Character.toUpperCase(code)) {
            case 'P' -> Type.PAWN;
            case 'R' -> Type.ROOK;
            case 'N' -> Type.KNIGHT;
            case 'B' -> Type.BISHOP;
            case 'Q' -> Type.QUEEN;
            case 'K' -> Type.KING;
            default -> throw new IllegalArgumentException("Nieznany kod figury: " + code);
        };

        // Zwrócenie nowej figury
        return new ChessPiece(type, color);
    }
}
