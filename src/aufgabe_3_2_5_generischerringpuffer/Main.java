package aufgabe_3_2_5_generischerringpuffer;

/**
 * Created by jonas on 09.04.14.
 */
public class Main {
    public static void main(String[] args) {
        GenericRingbuffer<Integer> myRingbuffer = new GenericRingbuffer<>(5);

        myRingbuffer.write(1);
        myRingbuffer.write(2);
        myRingbuffer.write(3);
        myRingbuffer.write(4);
        myRingbuffer.write(5);
        myRingbuffer.write(6);
        myRingbuffer.write(7);
        myRingbuffer.write(8);
        myRingbuffer.write(9);
        myRingbuffer.write(10);

        myRingbuffer.increaseSize(1);


        myRingbuffer.write(20);


        System.out.println(myRingbuffer.read());
        System.out.println(myRingbuffer.read());
        System.out.println(myRingbuffer.read());
        System.out.println(myRingbuffer.read());
        System.out.println(myRingbuffer.read());
        System.out.println(myRingbuffer.read());

    }
}
