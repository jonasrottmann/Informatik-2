package aufgabe_3_2_3_ringbuffer;

import aufgabe_3_2_1_doppeltverketteteliste.LinkedList;

/**
 * Created by jonas on 07.04.14.
 */
public class Ringbuffer {
    private LinkedList myList = new LinkedList();

    //TODO siehe Generic

    public void write(String value) {
        myList.addLast(value);
        myList.removeFirst();
    }

    public  void extend(String value) {
        myList.addLast(value);
    }

    public String read() {
        String str = myList.get(0);
        myList.removeFirst();
        return str;
    }

    public boolean isEmpty() {
        return myList.getSize() == 0;
    }

    public int getSize() {
        return myList.getSize();
    }
}
