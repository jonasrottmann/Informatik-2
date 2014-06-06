package aufgabe_3_7_collections;

import aufgabe_3_8_csv.Writer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

import static aufgabe_3_7_collections.Test.*;

/**
 * Created by jonas on 30.05.14.
 */
public class Main {

    public static final int REP = 50;
    public static final int AMOUNT = 999999;

    public static void main(String[] args) {
        Writer.clearFile();

        Vector vectorConstructor = new Vector<Integer>(AMOUNT + 1);
        ArrayList arrayListConstructor = new ArrayList<Integer>(AMOUNT + 1);
        Vector vector = new Vector<Integer>();
        ArrayList arrayList = new ArrayList<Integer>();
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet<Integer>();
        TreeSet treeSet = new TreeSet();

        System.out.println("EINFÜGEN (hinten anhängen)");

            System.out.println("\nMit Größe im Konstruktor: ");
                insertEnd(vectorConstructor, REP, AMOUNT);
                insertEnd(arrayListConstructor, REP, AMOUNT);

            System.out.println("\nOhne Größe im Konstruktor: ");
                insertEnd(vector, REP, AMOUNT);
                insertEnd(arrayList, REP, AMOUNT);
                insertEnd(linkedList, REP, AMOUNT);
                insertEnd(hashSet, REP, AMOUNT);
                insertEnd(treeSet, REP, AMOUNT);

            System.out.println("\nSUCHE (Iterator): ");
                searchIterator(vector, REP, AMOUNT - 1);
                searchIterator(arrayList, REP, AMOUNT - 1);
                searchIterator(linkedList, REP, AMOUNT - 1);
                searchIterator(hashSet, REP, AMOUNT - 1);
                searchIterator(treeSet, REP, AMOUNT - 1);

            System.out.println("\nSUCHE (Binär-Suche): ");
                searchBinary(vector, REP, AMOUNT - 1);
                searchBinary(arrayList, REP, AMOUNT - 1);

            System.out.println("\nSUCHE (contains()): ");
                search(vector, REP, AMOUNT - 1);
                search(arrayList, REP, AMOUNT - 1);
                search(linkedList, REP, AMOUNT - 1);
                search(hashSet, REP, AMOUNT - 1);
                search(treeSet, REP, AMOUNT - 1);

        System.out.println("\n\n ########################################################## \n\n");
        vectorConstructor.clear();
        arrayListConstructor.clear();
        vector.clear();
        arrayList.clear();
        linkedList.clear();
        hashSet.clear();
        treeSet.clear();

        System.out.println("EINFÜGEN (vorne anhängen)");

            System.out.println("\nMit Größe im Konstruktor: ");
                insertBeginning(vectorConstructor, REP, AMOUNT);
                insertBeginning(arrayListConstructor, REP, AMOUNT);

            System.out.println("\nOhne Größe im Konstruktor: ");
                insertBeginning(vector, REP, AMOUNT);
                insertBeginning(arrayList, REP, AMOUNT);
                insertBeginning(linkedList, REP, AMOUNT);

            System.out.println("\nSUCHE (Iterator): ");
                searchIterator(vector, REP, AMOUNT - 1);
                searchIterator(arrayList, REP, AMOUNT - 1);
                searchIterator(linkedList, REP, AMOUNT - 1);

            System.out.println("\nSUCHE (Binär-Suche): ");
                searchBinary(vector, REP, AMOUNT - 1);
                searchBinary(arrayList, REP, AMOUNT - 1);

            System.out.println("\nSUCHE (contains()): ");
                search(vector, REP, AMOUNT - 1);
                search(arrayList, REP, AMOUNT - 1);
                search(linkedList, REP, AMOUNT - 1);
                search(hashSet, REP, AMOUNT - 1);
                search(treeSet, REP, AMOUNT - 1);


        System.out.println("\n\n ########################################################## \n\n");
        arrayList.clear();

        System.out.println("Füllen mit ADD");
            fillArrayListADD(arrayList, REP, AMOUNT);

        System.out.println("Füllen mit GENERATE");
            fillArrayListGENERATE(arrayList, REP, AMOUNT);


        System.out.println("Addieren mit Iterator");
            addIterator(arrayList, REP);
    }
}
