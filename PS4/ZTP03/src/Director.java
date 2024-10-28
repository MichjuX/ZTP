public class Director {
    private final IBuilder _builder;

    public Director(IBuilder builder) {
        this._builder = builder;
    }

    public void constructFromString(String commands) {
        String[] parts = commands.split(" ");
        int i = 0;

        while (i < parts.length) {
            String command = parts[i];

            switch (command) {
                case "M": // MoveTo
                    int moveX = Integer.parseInt(parts[i + 1]);
                    int moveY = Integer.parseInt(parts[i + 2]);
                    _builder.moveTo(moveX, moveY);
                    i += 3;
                    break;

                case "L": // LineTo
                    int lineX = Integer.parseInt(parts[i + 1]);
                    int lineY = Integer.parseInt(parts[i + 2]);
                    _builder.lineTo(lineX, lineY);
                    i += 3;
                    break;

                case "Z": // Close
                    _builder.close();
                    i += 1;
                    break;

                default:
                    throw new IllegalArgumentException("Nieznana komenda: " + command);
            }
        }
    }
}
