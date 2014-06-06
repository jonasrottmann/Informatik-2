package aufgabe_5_upn;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by jonas on 06.06.14.
 */
public class UPN {
    private Stack<String> stack = new Stack<>();
    private String upn;

    /**
     * Konstruktor, bekommt einen UPN als String übergeben.
     * @param upn UPN als String.
     */
    public UPN(String upn) {
        this.upn = upn;
    }

    /**
     * Berechnet den UPN, nach folgendem Algorithmus <a href="http://de.wikipedia.org/wiki/Umgekehrte_Polnische_Notation#Auswertung">wikipedia.de</a>:
     *
     * <pre>
     * {@code
     *
     * compute_rpn(input)
     *      stack_init
     *      foreach (o in input)
     *          switch o
     *              isnumber
     *                  push o
     *              isbinoperator
     *                  right = pop
     *                  left = pop
     *                  result = compute(left, o, right)
     *                  push result
     *      return pop
     * }
     * </pre>
     *
     * @return Ergebnis.
     */
    public int calc() {
        StringTokenizer st = new StringTokenizer(upn);
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if(isNum(str)) {
                stack.push(str);
            } else {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int result = 0;
                switch (str) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                    default:
                        System.out.println("Fehler!");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * Prüft ob gegebener String eine Zahl ist.
     * @param str Zu prüfender String
     * @return true, wenn String eine Zahl ist.
     */
    private boolean isNum(String str) {
        try {
            int num = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
