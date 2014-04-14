package aufgabe_3_2_5_generischerringpuffer;

import aufgabe_3_2_4_generischeliste.GenericList;

/**
 * Created by jonas on 07.04.14.
 */
public class GenericRingbuffer<E> {
    private GenericList<E> myList = new GenericList<>();
    private int size;

    public GenericRingbuffer(int size) {
        this.size = size;
    }

    /**
     * Speichert einen Wert im Ringpuffer.
     * @param value Zu speichernder Wert.
     */
    public void write(E value) {
        if (myList.getSize() >= size) {
            myList.removeFirst();
        }
        myList.addLast(value);
    }

    /**
     * Erhöht die Größe des Puffers.
     * @param value
     */
    public  void increaseSize(int value) {
        size += value;
    }

    /**
     * Gibt den Wert des ersten Elementes zurück.
     * @return Wert des ersten Elementes.
     */
    public E read() {
        assert myList.getSize() > 0 : "Liste ist leer";

        E value = myList.get(0);
        myList.removeFirst();
        return value;
    }

    public boolean isEmpty() {
        return myList.getSize() == 0;
    }

    public int getSize() {
        return myList.getSize();
    }
}
