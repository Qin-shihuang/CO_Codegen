import java.util.ArrayList;
import Instructions.Instruction;
import utils.Global;

public class Generate {
    private ArrayList<Integer> instructionIds = new ArrayList<>();
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private int[] registers_to_write = new int[] {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private int backBranchPos = -1;
    private boolean backBranch = false;

    public void run() {
        ArrayList<Integer> instrSet = Global.getAvailableInstructions();
        int instrSetSize = instrSet.size();
        int maxLine = Global.getMaxInstructions();
        int curLine = 0;

        if (instrSet.contains(4) && instrSet.contains(8)) { // ORI LUI
            for (curLine = 0; curLine < Math.min(maxLine / 2, 22); curLine++) {
                
            }
        } else if (instrSet.contains(4)) {

        } else if (instrSet.contains(8)) {

        }
        while (curLine < maxLine) {

        }
    }

}
