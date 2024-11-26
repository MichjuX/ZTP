import java.util.Scanner;

public class Ztp08 {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        CommandManager commandManager = new CommandManager();

        String defaultNotation = """
            ra8 nb8 bc8 qd8 ke8 bf8 ng8 rh8
            pa7 pb7 pc7 pd7 pe7 pf7 pg7 ph7
            Pa2 Pb2 Pc2 Pd2 Pe2 Pf2 Pg2 Ph2
            Ra1 Nb1 Bc1 Qd1 Ke1 Bf1 Ng1 Rh1
        """;
        board.initializeFromString(defaultNotation);
        System.out.println(board);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Wprowadź polecenie (ruch np. 'e2 e4', undo, redo, replay, exit): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Gra zakończona.");
                break;
            }

            switch (input.toLowerCase()) {
                case "undo":
                    commandManager.undo();
                    System.out.println(board);
                    break;
                case "redo":
                    commandManager.redo();
                    System.out.println(board);
                    break;
                case "replay":
                    commandManager.replay(board);
                    break;
                default:
                    String[] parts = input.split(" ");
                    if (parts.length != 2) {
                        System.out.println("Nieprawidłowy format. Użyj formatu 'e2 e4'.");
                        continue;
                    }

                    int fromRow = 8 - (parts[0].charAt(1) - '0');
                    int fromCol = parts[0].charAt(0) - 'a';
                    int toRow = 8 - (parts[1].charAt(1) - '0');
                    int toCol = parts[1].charAt(0) - 'a';

                    MoveCommand moveCommand = new MoveCommand(board, fromRow, fromCol, toRow, toCol);
                    commandManager.executeCommand(moveCommand);
                    System.out.println(board);
            }
        }
    }
}
