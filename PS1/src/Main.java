import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> figures = new ArrayList<>();
        int choice;
        do {
            System.out.println("Choose a figure to add (1 - Circle, 2 - Rectangle, 3 - Triangle, 0 - Exit): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double radius = scanner.nextDouble();
                    figures.add(new Circle(radius));
                    break;
                case 2:
                    double width = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    figures.add(new Rectangle(width, height));
                    break;
                case 3:
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();
                    figures.add(new Triangle(a, b, c));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("\nFigures in the collection:");
            for (Object figure : figures) {
                if (figure instanceof Circle)
                    System.out.println("Circle Perimeter: " + ((Circle) figure).calculatePerimeter() + ", Area: " + ((Circle) figure).calculateArea());
                else if(figure instanceof Rectangle)
                    System.out.println("Rectangle Perimeter: " + ((Rectangle) figure).perimeter() + ", Area: " + ((Rectangle) figure).area());
                else if(figure instanceof Triangle)
                    System.out.println("Triangle Perimeter: " + ((Triangle) figure).getPerimeter() + ", Area: " + ((Triangle) figure).getArea());
            }


        } while (choice != 0) ;
        scanner.close();
    }

}