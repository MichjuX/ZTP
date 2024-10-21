import java.util.List;

// Klasa reprezentująca figurę
class Figure {
    // Punkty, które tworzą figurę
    private List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    // Getter do pobierania punktów figury
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Figura: " + points.toString();
    }
}
