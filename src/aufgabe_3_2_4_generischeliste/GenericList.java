package aufgabe_3_2_4_generischeliste;

/**
 * Wie Linked List, nur dass sie beliebige Datentypen statt Strings speichern kann.
 * @param <E> Zu speichernder Datentyp.
 */
public class GenericList<E> {
    private GenericListElement<E> first;
    private GenericListElement<E> last;
    private int size;

    /**
     * Trägt das Element vorne in die Liste ein.
     * @param value Das zu speichernde Object.
     */
    public void addFirst(E value) {
        GenericListElement<E> le = new GenericListElement<>(value);
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
     * @param value Der zu speichernde Object.
     */
    public void addLast(E value) {
        GenericListElement<E> le = new GenericListElement<>(value);
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
     * @param index Stelle an der das Element eingefügt werden soll.
     * @param value Der zu speichernde Object.
     */
    public void add(int index, E value) {
        assert index >= 0 : "Index kleiner 0";
        assert index <= size : "Index zu groß";

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            GenericListElement<E> le = new GenericListElement<>(value);
            GenericListElement<E> tmp = goToIndex(index);

            tmp.getPrev().setNext(le);
            le.setPrev(tmp.getPrev());
            le.setNext(tmp);
            tmp.setPrev(le);
            size++;
        }
    }

    /**
     * Liest den Wert am übergebenen Index aus.
     * @param index Stelle des zurückzugebenden Elements.
     * @return Object
     */
    public E get(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        GenericListElement<E> tmp = goToIndex(index);

        return tmp.getValue();
    }

    /**
     * Löscht das erste Element und gibt dessen Wert zurück.
     * @return Gelöschter Object an erster Stelle.
     */
    public E removeFirst() {
        assert size > 0 : "Liste ist schon leer!";

        E value = first.getValue();

        if (size > 1) {
            GenericListElement<E> tmp = first.getNext();
            tmp.setPrev(null);
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
     * @return Gelöschter Object an letzter Stelle.
     */
    public E removeLast() {
        assert size > 0 : "Liste ist schon leer!";

        E value = last.getValue();

        if (size > 1) {
            GenericListElement<E> tmp = last.getPrev();
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
     * @return Object an der gegebenen Stelle.
     */
    public E remove(int index) {
        assert index >= 0 : "Index kleiner 0";
        assert index < size : "Index zu groß";

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            GenericListElement<E> tmp = goToIndex(index);

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
     *
     * TODO: goToIndex von hinten anfangen.
     */
    private GenericListElement<E> goToIndex(int index) {
        GenericListElement<E> tmp = first;
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

        GenericListElement<E> tmp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }
}
