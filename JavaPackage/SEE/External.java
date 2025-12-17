package SEE;
import CIE.Personal;

public class External extends Personal {
    public int[] seeMarks = new int[5];

    public void getExternal(int[] marks) {
        for (int i = 0; i < 5; i++) {
            this.seeMarks[i] = marks[i];
        }
    }
}