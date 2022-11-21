package geometrija;

public class Tocka2D {
    protected double x;
    protected double y;

    public Tocka2D() {
        this.x = 0;
        this.y = 0;
    }

    public Tocka2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double udaljenost (Tocka2D t1, Tocka2D t2) {
        double a = t1.getX() - t2.getX();
        double b = t1.getY() - t2.getY();
        return Math.sqrt(a*a + b*b);
    }

    @Override
    public String toString() {
        return "Tocka2D ( " + this.x + ", " + this.y + " )";
    }
}
