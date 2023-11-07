import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import utils.Global;
import utils.InstrFactory;
import utils.Print;
import Instructions.Instruction;

public class Generate {
    private static ArrayList<Instruction> instructions = new ArrayList<>();
    private static int[] WritableRegisters = new int[] { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
            22, 23, 24, 25 };
    private static ArrayList<Integer> selectedLabelsList;
    private static ArrayList<Integer> instrList = Global.getAvailableInstructions();
    private static ArrayList<Integer> instrWithoutBJ = new ArrayList<>();
    private static HashSet<Integer> instrBJ = new HashSet<>();
    private static ArrayList<Integer> randomJumpInstr = new ArrayList<>();

    public static void run() {
        int maxLine = Global.getMaxInstructions();
        int curLine = 1;
        for (int i : instrList) {
            if (i != 7 && i != 9 && i != 10 && i != 12) {
                instrWithoutBJ.add(i);
            } else {
                instrBJ.add(i);
            }
        }
        if (instrList.contains(4) && instrList.contains(8)) { // ORI LUI
            for (curLine = 1; curLine < Math.min(maxLine / 2, 21); curLine++) {
                Global.setCurrentLine(curLine);
                if (Math.random() < 0.5) {
                    instructions.add(InstrFactory.getOri(Global.getRegisterName(WritableRegisters[curLine]),
                            Global.getRegisterName(0)));
                } else {
                    instructions.add(InstrFactory.getLui(Global.getRegisterName(WritableRegisters[curLine])));
                }
            }
        } else if (instrList.contains(4)) {
            for (curLine = 1; curLine < Math.min(maxLine, 21); curLine++) {
                Global.setCurrentLine(curLine);
                instructions.add(InstrFactory.getOri(Global.getRegisterName(WritableRegisters[curLine]),
                        Global.getRegisterName(0)));
            }
        } else if (instrList.contains(8)) {
            for (curLine = 1; curLine < Math.min(maxLine, 21); curLine++) {
                Global.setCurrentLine(curLine);
                instructions.add(InstrFactory.getLui(Global.getRegisterName(WritableRegisters[curLine])));
            }
        }
        while (curLine <= maxLine) {
            Global.setCurrentLine(curLine);
            int instrId = instrWithoutBJ.toArray(new Integer[0])[Global.getRandom(0, instrWithoutBJ.size() - 1)];
            instructions.add(InstrFactory.getInstructionNoArg(instrId));
            curLine++;
        }
        if (instrBJ.size() > 0 && !(instrBJ.size() == 1 && instrBJ.contains(10))) { // empty or only jr
            if (instrList.contains(7)) {
                randomJumpInstr.add(7); // Beq
            }
            if (instrList.contains(9) && !instrList.contains(10)) {
                randomJumpInstr.add(9); // Jal without Jr
            }
            if (instrList.contains(12)) {
                randomJumpInstr.add(12); // J
            }
            final int selectedLabelCount = ((maxLine - 50) / 50 + 1) * 5;
            HashSet<Integer> selectedLabels = new HashSet<>();
            while (selectedLabels.size() < selectedLabelCount) {
                selectedLabels.add(Global.getRandom(50, maxLine - 1));
            }
            selectedLabelsList = new ArrayList<>(selectedLabels);
            selectedLabelsList.sort(Comparator.naturalOrder());
            for (int i = 0; i < selectedLabelCount; i += 5) {
                insertBranches(i);
            }
        }
        Print.printToFile(instructions);
    }

    private static String getLabel(int line) {
        return "L" + line;
    }

    private static void insertBranches(int i) {
        if (!instrBJ.contains(10)) {
            int pattern = Global.getRandom(0, 5);
            switch (pattern) {
                case 0:
                    JumpInstr(i, i + 3);
                    JumpInstr(i + 1, i + 4);
                    JumpInstr(i + 2, i + 1);
                    JumpInstr(i + 3, i + 2);
                    break;
                case 1:
                    // 4352n
                    JumpInstr(i, i + 3);
                    JumpInstr(i + 1, i + 2);
                    JumpInstr(i + 2, i + 4);
                    JumpInstr(i + 3, i + 1);
                    break;
                case 2:
                    // 3542n
                    JumpInstr(i, i + 2);
                    JumpInstr(i + 1, i + 4);
                    JumpInstr(i + 2, i + 3);
                    JumpInstr(i + 3, i + 1);
                    break;
                case 3:
                    // 3425n
                    JumpInstr(i, i + 2);
                    JumpInstr(i + 1, i + 3);
                    JumpInstr(i + 2, i + 1);
                    JumpInstr(i + 3, i + 4);
                    break;
                case 4:
                    // 4n52n
                    JumpInstr(i, i + 3);
                    JumpInstr(i + 2, i + 4);
                    JumpInstr(i + 3, i + 1);
                    break;
                case 5:
                    // 35n2n
                    JumpInstr(i, i + 2);
                    JumpInstr(i + 1, i + 4);
                    JumpInstr(i + 3, i + 1);
                    break;
            }
        } else if (instrBJ.size() == 2 && instrBJ.contains(9) && instrBJ.contains(10)) { // jal and jr
            int pattern = Global.getRandom(0, 5);
            switch (pattern) {
                case 0: // 45r23
                    JalInstr(i, i + 3);
                    JalInstr(i + 1, i + 4);
                    JrInstr(i + 2);
                    JalInstr(i + 3, i + 1);
                    JalInstr(i + 4, i + 2);
                    break;
                case 1: // 352r4
                    JalInstr(i, i + 2);
                    JalInstr(i + 1, i + 4);
                    JalInstr(i + 2, i + 1);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 3);
                    break;
                case 2: // 4r532
                    JalInstr(i, i + 3);
                    JrInstr(i + 1);
                    JalInstr(i + 2, i + 4);
                    JalInstr(i + 3, i + 2);
                    JalInstr(i + 4, i + 1);
                    break;
                case 3: // 3r4n2
                    JalInstr(i, i + 2);
                    JrInstr(i + 1);
                    JalInstr(i + 2, i + 3);
                    JalInstr(i + 4, i + 1);
                    break;
                case 4: // 24r53
                    JalInstr(i, i + 1);
                    JalInstr(i + 1, i + 3);
                    JrInstr(i + 2);
                    JalInstr(i + 3, i + 4);
                    JalInstr(i + 4, i + 2);
                    break;
                case 5: // 34r5n
                    JalInstr(i, i + 2);
                    JalInstr(i + 1, i + 3);
                    JrInstr(i + 2);
                    JalInstr(i + 3, i + 4);
                    break;
            }
        } else {
            int pattern = Global.getRandom(0, 10);
            switch (pattern) {
                case 0: // 24r5l3
                    JumpInstr(i, i + 1);
                    JumpInstr(i + 1, i + 3);
                    JrInstr(i + 2);
                    JumpInstr(i + 3, i + 4);
                    JalInstr(i + 4, i + 2);
                    break;
                case 1: // 5r42l3
                    JumpInstr(i, i + 4);
                    JrInstr(i + 1);
                    JumpInstr(i + 2, i + 3);
                    JumpInstr(i + 3, i + 1);
                    JalInstr(i + 4, i + 2);
                    break;
                case 2: // l45rrl3
                    JalInstr(i, i + 3);
                    JumpInstr(i + 1, i + 4);
                    JrInstr(i + 2);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 2);
                    break;
                case 3: // 4rrl2l3
                    JumpInstr(i, i + 3);
                    JrInstr(i + 1);
                    JrInstr(i + 2);
                    JalInstr(i + 3, i + 1);
                    JalInstr(i + 4, i + 2);
                    break;
                case 4: // 24rnl3
                    JumpInstr(i, i + 1);
                    JumpInstr(i + 1, i + 3);
                    JrInstr(i + 2);
                    JalInstr(i + 4, i + 2);
                    break;
                case 5: // 2l54rl3
                    JumpInstr(i, i + 1);
                    JalInstr(i + 1, i + 4);
                    JumpInstr(i + 2, i + 3);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 2);
                    break;
                case 6: // 4r2l3n
                    JumpInstr(i, i + 3);
                    JrInstr(i + 1);
                    JumpInstr(i + 2, i + 1);
                    JalInstr(i + 3, i + 2);
                    break;
                case 7: // 542rl3
                    JumpInstr(i, i + 4);
                    JumpInstr(i + 1, i + 3);
                    JumpInstr(i + 2, i + 1);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 2);
                    break;
                case 8: // 3rn5l2
                    JumpInstr(i, i + 2);
                    JrInstr(i + 1);
                    JumpInstr(i + 3, i + 4);
                    JalInstr(i + 4, i + 1);
                    break;
                case 9: // 352rl4
                    JumpInstr(i, i + 2);
                    JumpInstr(i + 1, i + 4);
                    JumpInstr(i + 2, i + 1);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 3);
                    break;
                case 10: // l35rrl4
                    JalInstr(i, i + 2);
                    JumpInstr(i + 1, i + 4);
                    JrInstr(i + 2);
                    JrInstr(i + 3);
                    JalInstr(i + 4, i + 3);
                    break;
                default:
                    break;
            }
        }
    }

    private static void JumpInstr(int line, int label) {
        int instrId = randomJumpInstr.get(Global.getRandom(0, randomJumpInstr.size() - 1));
        Global.setCurrentLine(selectedLabelsList.get(line) + 1);
        instructions.set(selectedLabelsList.get(line), InstrFactory.getJump(instrId, getLabel(selectedLabelsList.get(label) + 1)));
    }

    private static void JalInstr(int line, int label) {
        Global.setCurrentLine(selectedLabelsList.get(line) + 1);
        instructions.set(selectedLabelsList.get(line), InstrFactory.getJal(getLabel(selectedLabelsList.get(label) + 1)));
    }

    private static void JrInstr(int line) {
        Global.setCurrentLine(selectedLabelsList.get(line) + 1);
        instructions.set(selectedLabelsList.get(line), InstrFactory.getJr(Global.getRegisterName(31)));
    }
}
