public class Director {
    private IBuilder builder;

    public Director(IBuilder builder) {
        this.builder = builder;
    }

    public void constructFromString(String commands) {
        String[] parts = commands.split(" ");
        int i = 0;

        while (i < parts.length) {
            String command = parts[i];  // Pobierz bieżącą komendę

            switch (command) {
                case "M": // MoveTo
                    int moveX = Integer.parseInt(parts[i + 1]);
                    int moveY = Integer.parseInt(parts[i + 2]);
                    builder.moveTo(moveX, moveY);
                    i += 3;  // Przesuwamy indeks o 3, bo mamy komendę i dwie współrzędne
                    break;

                case "L": // LineTo
                    int lineX = Integer.parseInt(parts[i + 1]);
                    int lineY = Integer.parseInt(parts[i + 2]);
                    builder.lineTo(lineX, lineY);
                    i += 3;  // Przesuwamy indeks o 3, bo mamy komendę i dwie współrzędne
                    break;

                case "Z": // Close
                    builder.close();
                    i += 1;  // Przesuwamy indeks o 1, bo mamy tylko komendę "Z"
                    break;

                default:
                    throw new IllegalArgumentException("Nieznana komenda: " + command);
            }
        }
    }
}
