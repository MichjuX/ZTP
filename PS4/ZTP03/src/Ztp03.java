import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ztp03 {
    public static void main(String[] args) {
        // Ustawiamy rozmiar obrazu
        int width = 500;
        int height = 500;

        // Tworzymy obiekt BufferedImage o rozmiarze 500x500 pikseli
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Tworzymy obiekt Graphics2D do rysowania na obrazie
        Graphics2D g2d = image.createGraphics();

        // Wypełniamy tło na biało
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Ustawiamy czarne pióro o grubości 2 pikseli
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        // Tworzymy buildera
        Builder builder = new Builder(g2d);

        // Tworzymy directora i konstruujemy rysunek na podstawie ciągu tekstowego
        Director director = new Director(builder);
        director.constructFromString("M 100 400 L 200 50 L 450 300 L 250 250 Z M 300 350 L 350 100 L 50 200");

        // Generujemy rysunek
        Drawing drawing = builder.build();

        // Wyświetlamy rysunek w konsoli (opcjonalnie)
        System.out.println(drawing);

        // Zwalniamy zasoby Graphics2D
        g2d.dispose();

        // Zapisujemy obraz jako plik PNG
        try {
            ImageIO.write(image, "png", new File("drawing.png"));
            System.out.println("Rysunek został zapisany jako drawing.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
