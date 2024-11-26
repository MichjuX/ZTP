// Reprezentuje szachownicę, przechowując stan wszystkich pól i figur.
// Umożliwia ustawianie, usuwanie i przesuwanie figur na planszy.
class ChessBoard {
    private String initialState;
    private final ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    // Zwraca figurę na podanym polu.
    public ChessPiece getPiece(int row, int col) {
        return board[row][col];
    }

    // Ustawia figurę na podanym polu.
    public void setPiece(int row, int col, ChessPiece piece) {
        board[row][col] = piece;
    }

    // Usuwa figurę z podanego pola.
    public void removePiece(int row, int col) {
        board[row][col] = null;
    }

    // Przesuwa figurę z jednego pola na drugie.
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        // Pobierz figurę z pola startowego
        ChessPiece piece = getPiece(fromRow, fromCol);
        if (piece == null) {
            return false; // Brak figury do przesunięcia (pole startowe było puste)
        }

        // Usunięcie figury z pola startowego
        removePiece(fromRow, fromCol);

        // Ustawienie figury na polu docelowym
        setPiece(toRow, toCol, piece);
        return true;
    }

    // Inicjalizuje szachownicę na podstawie tekstowego opisu figur, np. "Pa2 Rb1 kf8".
    public void initializeFromString(String notation) {
        this.initialState = notation;
        // Wyczyszczenie planszy
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = null;
            }
        }

        // Rozdziel tekst na figury (używając białych znaków jako separatorów)
        String[] pieces = notation.trim().split("\\s+");
        for (String pieceNotation : pieces) {
            // Walidacja formatu opisu figury (np. 'Pa2')
            if (pieceNotation.length() != 3) {
                throw new IllegalArgumentException("Nieprawidłowy format notacji: " + pieceNotation + " " + pieceNotation.length());
            }

            // Rozbicie tekstu na kod figury, kolumnę i wiersz
            char code = pieceNotation.charAt(0);
            char colChar = pieceNotation.charAt(1);
            char rowChar = pieceNotation.charAt(2);

            // Konwersja kolumny i wiersza na indeksy tablicy
            int col = colChar - 'a';          // 'a' → 0, 'b' → 1, ...
            int row = 8 - (rowChar - '0');    // '8' → 0, '7' → 1, ...

            // Utworzenie obiektu figury na podstawie kodu
            ChessPiece piece = ChessPiece.fromCode(code);
            // Ustawienie figury na planszy
            board[row][col] = piece;
        }
    }

    // Zwraca planszę jako tekst - używane do wyświetlenia aktualnego stanu szachownicy w konsoli.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Wiersz z literami kolumn
        sb.append("  a b c d e f g h\n");

        for (int row = 0; row < 8; row++) {
            // Numer wiersza na początku
            sb.append(8 - row + " ");

            for (int col = 0; col < 8; col++) {
                // Pobierz figurę z planszy i wypisz jej kod
                ChessPiece piece = board[row][col];
                sb.append(piece != null ? piece.getCode() + " " : ". ");
            }

            // Przejście do nowej linii po każdej iteracji wiersza
            sb.append('\n');
        }
        return sb.toString();
    }
    public String getInitialState() {
        return initialState;
    }

}
