import java.util.Stack;
public class CommandManager {
    private final Stack<ICommand> executedCommands = new Stack<>();
    private final Stack<ICommand> undoneCommands = new Stack<>();

    public void executeCommand(ICommand command) {
        command.execute();
        executedCommands.push(command);
        undoneCommands.clear();
    }

    public void undo() {
        if (!executedCommands.isEmpty()) {
            ICommand command = executedCommands.pop();
            command.undo();
            undoneCommands.push(command);
        } else {
            System.out.println("Brak ruchów do cofnięcia.");
        }
    }

    public void redo() {
        if (!undoneCommands.isEmpty()) {
            ICommand command = undoneCommands.pop();
            command.execute();
            executedCommands.push(command);
        } else {
            System.out.println("Brak ruchów do ponowienia.");
        }
    }

    public void replay(ChessBoard board) {
        System.out.println("Odtwarzanie ruchów...");
        ChessBoard tempBoard = new ChessBoard();
        tempBoard.initializeFromString(board.getInitialState());

        for (ICommand command : executedCommands) {
            try {
                Thread.sleep(500);
                if (command instanceof MoveCommand moveCommand) {
                    moveCommand.executeOn(tempBoard);
                    System.out.println(tempBoard);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}

