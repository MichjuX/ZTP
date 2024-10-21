import java.util.List;
import java.util.stream.Collectors;

// Klasa reprezentująca rysunek
class Drawing {
    // Lista figur tworzących rysunek
    private List<Figure> figures;

    public Drawing(List<Figure> figures) {
        this.figures = figures;
    }

    // Getter do pobierania figur rysunku
    public List<Figure> getFigures() {
        return figures;
    }

    @Override
    public String toString() {
        return "Rysunek: \n" + figures.stream().map(figure -> figure.toString()).collect(Collectors.joining("\n"));
    }
}
