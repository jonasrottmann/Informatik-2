package vorlesung;

/**
 * Einführungsbeispiel aus Vorlesung zu verketteten Listen.
 * Int Liste -> LinkedListElement.java kann nur Int-Werte speichern.
 * Liste kennt erstes und letztes Element. Jedes Element kennt Vorgänger und Nachfolger.
 */
public class LinkedList {
    private LinkedListElement first;
    private LinkedListElement last;
    private int size;

    public LinkedList() {
    }

    public void append(int value) {
        if (size == 0) {
            //1. Liste ist leer
            LinkedListElement le = new LinkedListElement(value);
            first = le;
            last = le;
            size++;
        } else {
            //2. Liste nicht leer
            LinkedListElement le = new LinkedListElement(value);
            last.setNext(le);
            le.setPrev(last);
            last = le;
            size++;
        }
    }

    /**
     * ACHTUNG! INEFFIZIENT!
     *
     * @param index
     * @return
     */
    public int getValueAt(int index) {
        assert index >= 0 && index < size : "Index out of bounds!";

        LinkedListElement current = first;
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        return current.getValue();
    }
}
