class Triangle {
    private double a, b, c;
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}