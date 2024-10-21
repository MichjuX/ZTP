import java.util.ArrayList;
import java.util.List;
public class Builder implements IBuilder {
    private List<Point> _points = new ArrayList<>();
    private List<Figure> _figures = new ArrayList<>();
    @Override
    public IBuilder moveTo(int x, int y) {
        if (!_points.isEmpty()) {
            _figures.add(new Figure(_points));
            _points = new ArrayList<>();
        }
        _points.add(new Point(x, y));
        return this;
    }

    @Override
    public IBuilder lineTo(int x, int y) {
        _points.add(new Point(x, y));
        return this;
    }

    @Override
    public IBuilder close() {
        if (!_points.isEmpty()) {
            Point firstPoint = _points.get(0);
            _points.add(firstPoint);
        }
        return this;
    }

    public Drawing build() {
        if (!_figures.isEmpty()) {
            _figures.add(new Figure(_points));
        }
        return new Drawing(_figures);
    }
}
