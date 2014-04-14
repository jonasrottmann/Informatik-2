package aufgabe_3_2_1_doppeltverketteteliste;

/**
 * Created by jonas on 27.03.14.
 */
public class LinkedListElement {
    private String value;
    private LinkedListElement next;
    private LinkedListElement prev;

    public LinkedListElement(String value) {
        this.value = value;
    }


    public void setNext(LinkedListElement le) {
        this.next = le;
    }
    public void setPrev(LinkedListElement le) {
        this.prev = le;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public LinkedListElement getPrev() {
        return prev;
    }
    public LinkedListElement getNext() {
        return next;
    }
    public String getValue() {
        return value;
    }
}
