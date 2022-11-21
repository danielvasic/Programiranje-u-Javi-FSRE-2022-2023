import geometrija.Linija;
import geometrija.Tocka2D;
import geometrija.Tocka3D;

public class Program {
    public static void main (String [] args) {
        Tocka2D t1 = new Tocka2D(1,2);
        Tocka2D t2 = new Tocka2D();
        System.out.println("Udaljenost točke "
                + t1 + " i točke "
                + t2 + " iznosi " + Tocka2D.udaljenost(t1, t2) + ".");

        Linija<Tocka2D> l0 = new Linija<Tocka2D>(t1, t2);

        System.out.println(l0 + " duljina linije je " + Tocka2D.udaljenost(t1, t2));
        Tocka3D t3 = new Tocka3D();
        Tocka3D t4 = new Tocka3D(1,2,3);

        Linija<Tocka3D> l1 = new Linija<Tocka3D>(t3, t4);

        System.out.println(l1 + " duljina linije je " + Tocka3D.udaljenost(t3, t4));
    }
}
