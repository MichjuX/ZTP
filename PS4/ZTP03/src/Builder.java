import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Builder implements IBuilder {
    private List<Point> _points = new ArrayList<>();
    private List<Figure> _figures = new ArrayList<>();
    private Graphics2D g2d;  // Referencja do Graphics2D

    public Builder(Graphics2D g2d) {
        this.g2d = g2d;  // Przekazujemy obiekt Graphics2D do buildera
    }

    @Override
    public IBuilder moveTo(int x, int y) {
        if (!_points.isEmpty()) {
            _figures.add(new Figure(_points));  // Zapisujemy figurę, jeśli istnieje
            _points = new ArrayList<>();        // Tworzymy nową listę punktów
        }
        _points.add(new Point(x, y));            // Dodajemy pierwszy punkt figury
        return this;
    }

    @Override
    public IBuilder lineTo(int x, int y) {
        if (!_points.isEmpty()) {
            Point lastPoint = _points.get(_points.size() - 1);
            g2d.drawLine(lastPoint.getX(), lastPoint.getY(), x, y);  // Rysujemy linię
        }
        _points.add(new Point(x, y));  // Dodajemy punkt do bieżącej figury
        return this;
    }

    @Override
    public IBuilder close() {
        if (!_points.isEmpty()) {
            Point firstPoint = _points.get(0);
            Point lastPoint = _points.get(_points.size() - 1);
            g2d.drawLine(lastPoint.getX(), lastPoint.getY(), firstPoint.getX(), firstPoint.getY());  // Zamykamy figurę
            _points.add(firstPoint);  // Dodajemy początkowy punkt, by zamknąć pętlę
        }
        return this;
    }

    public Drawing build() {
        if (!_points.isEmpty()) {
            _figures.add(new Figure(_points));  // Zapisujemy ostatnią figurę
        }
        return new Drawing(_figures);  // Zwracamy obiekt rysunku
    }
}
