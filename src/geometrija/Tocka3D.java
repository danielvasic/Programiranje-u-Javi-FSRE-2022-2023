package geometrija;

public class Tocka3D extends Tocka2D {
    private double z;

    public Tocka3D() {
        super();
        this.z = 0;
    }

    public Tocka3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Tocka3D ( " + x + ", " + y + ", " + z + " )";
    }

    public static double udaljenost (Tocka3D t1, Tocka3D t2) {
        double a = t1.getX() - t2.getX();
        double b = t1.getY() - t2.getY();
        double c = t1.getZ() - t2.getZ();
        return Math.sqrt(a*a + b*b + c*c);
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
