package aufgabe_5_upn;

/**
 * Created by jonas on 06.06.14.
 */
public class Main {
    public static void main (String[] args) {
        UPN upn = new UPN("15 42 18 + 61 24 - * 71 + *");
        System.out.println(upn.calc());
    }
}
