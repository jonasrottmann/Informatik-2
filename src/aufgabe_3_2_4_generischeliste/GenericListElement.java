package aufgabe_3_2_4_generischeliste;

/**
 * Created by jonas on 01.04.14.
 */
public class GenericListElement<E> {
    private E value;
    private GenericListElement<E> next;
    private GenericListElement<E> prev;

    public GenericListElement(E value) {
        this.value = value;
    }


    public void setNext(GenericListElement<E> le) {
        this.next = le;
    }
    public void setPrev(GenericListElement<E> le) {
        this.prev = le;
    }

    public GenericListElement<E> getPrev() {
        return prev;
    }
    public GenericListElement<E> getNext() {
        return next;
    }
    public E getValue() {
        return value;
    }
}
