package aufgabe_3_2_1_doppeltverketteteliste;

/**
 * Created by jonas on 27.03.14.
 */
public class LinkedList {
    private LinkedListElement first;
    private LinkedListElement last;
    private int size;

    /**
     *
     */
    public LinkedList() {
    }

    /**
     * Trägt das Element vorne in die Liste ein.
     *
     * @param value Der zu speichernde String.
     */
    public void addFirst(String value) {
        LinkedListElement le = new LinkedListElement(value);
        if (size == 0) {
            last = le;
        } else {
            first.setPrev(le);
            le.setNext(first);
        }
        first = le;
        size++;
    }

    /**
     * Hängt das Element hinten an die Liste an.
     *
     * @param value Der zu speichernde String.
     */
    public void addLast(String value) {
        LinkedListElement le = new LinkedListElement(value);
        if (size == 0) {
                first = le;
        } else {
            last.setNext(le);
            le.setPrev(last);
        }
        last = le;
        size++;
    }

    /**
     * Fügt das Element am angegebenen Index in die Liste ein.
     *
     * @param index Stelle an der das Element eingefügt werden soll.
     * @param value Der zu speichernde String.
     */
    public void add(int index, String value) {
        assert index >= 0 : "Index kleiner 0";
        assert index <= size : "Index zu groß";

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            LinkedListElement le = new LinkedListElement(value);
            LinkedListElement tmp = goToIndex(index);

            tmp.getPrev().setNext(le);
            le.setPrev(tmp.getPrev());
            le.setNext(tmp);
            tmp.setPrev(le);
            size++;
        }
    }

    /**
     * Liest den Wert am übergebenen Index aus.
     *
     * @param index Stelle des zurückzugebenden Elements.
     * @return String
     */
    public String get(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        LinkedListElement tmp = goToIndex(index);

        return tmp.getValue();
    }

    /**
     * Löscht das erste Element und gibt dessen Wert zurück.
     * @return Gelöschter String an erster Stelle.
     */
    public String removeFirst() {
        assert size > 0 : "Liste ist schon leer!";

        String value = first.getValue();

        if (size > 1) {
            LinkedListElement tmp = first.getNext();

            first.setNext(null);
            first = tmp;
        } else {
            first = null;
            last = null;
        }
        size--;
        return value;
    }

    /**
     * Löscht das letzte Element und gibt dessen Wert zurück.
     * @return Gelöschter String an letzter Stelle.
     */
    public String removeLast() {
        assert size > 0 : "Liste ist schon leer!";
        String value = last.getValue();

        if (size > 1) {
            LinkedListElement tmp = last.getPrev();
            tmp.setNext(null);
            last = tmp;
        } else {
            first = null;
            last = null;
        }
        size--;
        return value;
    }

    /**
     * Löscht das Element am angegebenen Index und gibt den darin gespeicherten Wert zurück.
     * @param index Stelle des zu löschenden Elements.
     * @return String an der gegebenen Stelle.
     */
    public String remove(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            LinkedListElement tmp = goToIndex(index);
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            size--;
            return tmp.getValue();
        }
    }

    /**
     * Gibt die Anzahl der Elemente der Liste zurück.
     * @return Anzahl der Elemente.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gibt das Element an der gegebenen Stelle zurück.
     * @param index Stelle des gewünschten Elements.
     * @return Element an der Stelle.
     */
    private LinkedListElement goToIndex(int index) {
        LinkedListElement tmp = first;
        for (int i = 1; i <= index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    /**
     * Gibt die Liste in der Konsole aus.
     */
    public void printList() {
        assert size > 0 : "Liste ist leer!";

        LinkedListElement tmp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }
}
