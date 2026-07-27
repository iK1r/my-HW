package hw8;

public class GraphicEditor {
    public static void main(String[] args) {
        ShapePrinter printer = new ShapePrinter();

        Shape circle = new Circle();
        Shape quad = new Quad();
        Shape triangle = new Triangle();
        Shape rectangle = new Rectangle();
        Shape ellipse = new Ellipse();

        printer.printShapeName(circle);
        printer.printShapeName(quad);
        printer.printShapeName(triangle);
        printer.printShapeName(rectangle);
        printer.printShapeName(ellipse);
    }
}
