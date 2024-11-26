class MoveCommand implements ICommand {
    private final ChessBoard board;
    private final int fromRow, fromCol, toRow, toCol;
    private ChessPiece capturedPiece;

    public MoveCommand(ChessBoard board, int fromRow, int fromCol, int toRow, int toCol) {
        this.board = board;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    @Override
    public void execute() {
        capturedPiece = board.getPiece(toRow, toCol);
        board.movePiece(fromRow, fromCol, toRow, toCol);
    }
    public void executeOn(ChessBoard board) {
        capturedPiece = board.getPiece(toRow, toCol);
        board.movePiece(fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void undo() {
        board.movePiece(toRow, toCol, fromRow, fromCol);
        board.setPiece(toRow, toCol, capturedPiece);
    }
}
