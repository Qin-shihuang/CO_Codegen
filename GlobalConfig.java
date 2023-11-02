import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class GlobalConfig {
    private static final int memorySize = 1024;
    private static final HashMap<String, Integer> supportedInstructions = new HashMap<>() {
        {
            put("ADD", 0);
            put("SUB", 1);
            put("ADDU", 2);
            put("SUBU", 3);
            put("ORI", 4);
            put("LW", 5);
            put("SW", 6);
            put("BEQ", 7);
            put("LUI", 8);
            put("JAL", 9);
            put("JR", 10);
            put("NOP", 11);
        }
    };
    private static final HashMap<Integer, String> RegisterNames = new HashMap<>() {
        {
            put(0, "$zero");
            put(1, "$at");
            put(2, "$v0");
            put(3, "$v1");
            put(4, "$a0");
            put(5, "$a1");
            put(6, "$a2");
            put(7, "$a3");
            put(8, "$t0");
            put(9, "$t1");
            put(10, "$t2");
            put(11, "$t3");
            put(12, "$t4");
            put(13, "$t5");
            put(14, "$t6");
            put(15, "$t7");
            put(16, "$s0");
            put(17, "$s1");
            put(18, "$s2");
            put(19, "$s3");
            put(20, "$s4");
            put(21, "$s5");
            put(22, "$s6");
            put(23, "$s7");
            put(24, "$t8");
            put(25, "$t9");
            put(26, "$k0");
            put(27, "$k1");
            put(28, "$gp");
            put(29, "$sp");
            put(30, "$fp");
            put(31, "$ra");
        }
    };
    private static ArrayList<Integer> instructions = new ArrayList<>();
    private static int maxInstructions = 1000;
    private static File output = null;

    public static final HashMap<String, Integer> getSupportedInstructions() {
        return supportedInstructions;
    }

    public static final int getMemorySize() {
        return memorySize;
    }

    public static void setMaxInstructions(int maxInstructions) {
        GlobalConfig.maxInstructions = maxInstructions;
    }

    public static int getMaxInstructions() {
        return maxInstructions;
    }

    public static void addInstruction(String instruction) {
        instructions.add(supportedInstructions.get(instruction));
    }

    public static ArrayList<Integer> getInstructions() {
        return instructions;
    }

    public static void setOutput(File output) {
        GlobalConfig.output = output;
    }

    public static File getOutput() {
        return output;
    }

    public static String getRegisterName(int register) {
        return RegisterNames.get(register);
    }
}
