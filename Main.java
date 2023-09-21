/*geometrik şekilleri kapsayan bir yapı olacak;
shape ana class
kenarı toString çeviren metot
interfaceleri tanımlı olacak
abstract yazalım burada içi dolu olacak metotlara karar verelim (alan hesaplama,çevre hesaplama,uzunluk hesaplama, ortak metotlarıda koymaya çalışalım)
polimorfizm kullanalım*/
interface GeometricShape {
    double calculateArea();
    double calculatePerimeter();
    double calculateLength();
}

interface GeometricSolid {
    double calculateVolume();
}

abstract class Shape {
    protected int sides;

    public Shape(int sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "Bu bir " + getClass().getSimpleName() + " ve kenar sayısı: " + sides;
    }
}

class Rectangle extends Shape implements GeometricShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super(4);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateLength() {
        return 2 * (length + width);
    }
}

class Square extends Shape implements GeometricShape {
    private double side;

    public Square(double side) {
        super(4);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public double calculateLength() {
        return 4 * side;
    }
}
class Circle extends Shape implements GeometricShape {
   
	private double radius;

    public Circle(double radius) {
        super(1);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI*radius;
    }

    @Override
    public double calculateLength() {
        return 2 * Math.PI*radius;
    }
}

class Cube extends Shape implements GeometricShape, GeometricSolid {
    private double side;

    public Cube(double side) {
        super(12);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 6 * side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 12 * side;
    }

    @Override
    public double calculateLength() {
        return 12 * side;
    }

    @Override
    public double calculateVolume() {
        return side * side * side;
    }
}


public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        Shape square = new Square(5);
        Shape cube = new Cube(3);
        Shape circle = new Circle(3);
 

        System.out.println(rectangle);
        System.out.println("Alan: " + ((GeometricShape) rectangle).calculateArea());
        System.out.println("Çevre: " + ((GeometricShape) rectangle).calculatePerimeter());

        System.out.println(square);
        System.out.println("Alan: " + ((GeometricShape) square).calculateArea());
        System.out.println("Çevre: " + ((GeometricShape) square).calculatePerimeter());

        System.out.println(cube);
        System.out.println("Alan: " + ((GeometricShape) cube).calculateArea());
        System.out.println("Çevre: " + ((GeometricShape) cube).calculatePerimeter());
        System.out.println("Hacim: " + ((GeometricSolid) cube).calculateVolume());
        
        System.out.println(circle);
        System.out.println("Alan: " + ((GeometricShape) circle).calculateArea());
        System.out.println("Çevre: " + ((GeometricShape) circle).calculatePerimeter());
    }
}
