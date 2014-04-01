package vorlesung;

/**
 * Created by jonas on 27.03.14.
 */
public class LinkedListElement {
    private int value;
    private LinkedListElement next;
    private LinkedListElement prev;

    public LinkedListElement(int value) {
        this.value = value;
    }
    public void setNext(LinkedListElement le){
        this.next = le;
    }
    public void setPrev(LinkedListElement le){
        this.prev = le;
    }
    public LinkedListElement getPrev() {
        return prev;
    }
    public LinkedListElement getNext() {
        return next;
    }
    public int getValue() {
        return value;
    }
}
