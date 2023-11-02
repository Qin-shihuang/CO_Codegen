import java.util.ArrayList;
import java.util.HashSet;
import utils.Global;
import utils.InstrFactory;
import utils.Print;
import Instructions.Instruction;

public class Generate {
    private static ArrayList<Instruction> instructions = new ArrayList<>();
    private static int[] WritableRegisters = new int[] { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25 };

    public static void run() {
        ArrayList<Integer> instrSet = Global.getAvailableInstructions();
        HashSet<Integer> instrWithoutBJ = new HashSet<>();
        int maxLine = Global.getMaxInstructions();
        int curLine = 0;
        for (int i : instrSet) {
            if (i != 7 && i != 9 && i != 10) {
                instrWithoutBJ.add(i);
            }
        }
        if (instrSet.contains(4) && instrSet.contains(8)) { // ORI LUI
            for (curLine = 0; curLine < Math.min(maxLine / 2, 21); curLine++) {
                Global.setCurrentLine(curLine);
                if (Math.random() < 0.5) {
                    instructions.add(InstrFactory.getOri(Global.getRegisterName(WritableRegisters[curLine]),
                            Global.getRegisterName(0)));
                } else {
                    instructions.add(InstrFactory.getLui(Global.getRegisterName(WritableRegisters[curLine])));
                }
            }
        } else if (instrSet.contains(4)) {
            for (curLine = 0; curLine < Math.min(maxLine, 21); curLine++) {
                Global.setCurrentLine(curLine);
                instructions.add(InstrFactory.getOri(Global.getRegisterName(WritableRegisters[curLine]),
                        Global.getRegisterName(0)));
            }
        } else if (instrSet.contains(8)) {
            for (curLine = 0; curLine < Math.min(maxLine, 21); curLine++) {
                Global.setCurrentLine(curLine);
                instructions.add(InstrFactory.getLui(Global.getRegisterName(WritableRegisters[curLine])));
            }
        }
        while (curLine < maxLine) {
            Global.setCurrentLine(curLine);
            int instrId = instrWithoutBJ.toArray(new Integer[0])[Global.getRandom(0, instrWithoutBJ.size() - 1)];
            instructions.add(InstrFactory.getInstructionNoArg(instrId));
            curLine++;
        }

        Print.printToFile(instructions);
    }

}
