package aufgabe_3_8_csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jonas on 05.06.14.
 */
public class Writer {
    public static void clearFile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/jonas/Desktop/ergebnisse.csv"));
            out.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String artDerMessung, String datenstruktur, long zeit) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/jonas/Desktop/ergebnisse.csv", true));
            out.append(artDerMessung).append(", ").append(datenstruktur).append(", ").append(String.valueOf(zeit));
            out.newLine();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
