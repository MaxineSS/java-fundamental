import java.util.ArrayList;

class IntClass {
    private int value;

    public IntClass(int value) {
      this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class App {

    public App() {
    }

    public static void main(String[] args) throws Exception {
        char v1[] = {'s', 'e', 'j', 'i', 'n'};
        char[] ct = new char[5];

        String str = new String(v1);
        // iteratable
        for (char c : v1) {
            if(c == 'h'){
                System.out.println("found the letter: " + c);
            }
        }

        ArrayList<Integer> myIntArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            myIntArray.add(Integer.valueOf(i));
        }

        System.out.println(myIntArray.toString());

    }

}