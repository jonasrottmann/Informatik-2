package vorlesung;

/**
 * Created by jonas on 27.03.14.
 */
public class Ringbuffer {
    private int[] values;
    private int ri; //read-Index
    private int wi; //write-Index
    private boolean written; //default: false

    public Ringbuffer(int size) {
        values = new int[size];
    }

    public void write(int value) {
        assert ri != wi || !written;

        values[wi++] = value;
        if (wi == values.length) {
            wi = 0;
        }
        written = true;
    }

    public int read() {
        assert !isEmpty();
        int value = values[ri++];
        ri %= values.length; //ri = ri % values.length
//        if (ri == values.length) {
//            ri = 0;
//        }
        written = false;
        return value;
    }

    public int read_alternativ() {
        assert !isEmpty();
        written = false;
        ri = (ri + 1) % values.length;
        return values[ri == 0 ? values.length - 1 : ri - 1];
    }

    public boolean isFull() {
        return ri == wi && written;
    }

    public boolean isEmpty() {
        return ri == wi && !written;
    }
}