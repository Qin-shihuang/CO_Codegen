package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;

public class Global {
    private static int currentLine = 0;
    private static final int memorySize = 1024;
    private static final HashMap<String, Integer> supportedInstructions = new HashMap<>() {
        {
            put("ADD", 0);
            put("SUB", 1);
            put("ADDU", 0);
            put("SUBU", 1);
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
    private static ArrayList<Integer> availableInstructions = new ArrayList<>();
    private static int maxInstructions = 1000;
    private static File output = null;
    private static HashSet<String> linkedRegisters = new HashSet<>();

    public static final HashMap<String, Integer> getSupportedInstructions() {
        return supportedInstructions;
    }

    public static final int getMemorySize() {
        return memorySize;
    }

    public static void setMaxInstructions(int maxInstructions) {
        Global.maxInstructions = maxInstructions;
    }

    public static int getMaxInstructions() {
        return maxInstructions;
    }

    public static void addInstruction(String instruction) {
        availableInstructions.add(supportedInstructions.get(instruction));
    }

    public static ArrayList<Integer> getAvailableInstructions() {
        return availableInstructions;
    }

    public static void setOutput(File output) {
        Global.output = output;
    }

    public static File getOutput() {
        return output;
    }

    public static String getRegisterName(int register) {
        return RegisterNames.get(register);
    }

    public static void addLinkedRegister(String register) {
        linkedRegisters.add(register);
    }

    public static void removeLinkedRegister(String register) {
        linkedRegisters.remove(register);
    }

    public static boolean isLinkedRegisterEmpty() {
        return linkedRegisters.isEmpty();
    }

    public static String getRamdomLinkedRegister() {
        int size = linkedRegisters.size();
        int item = getRandom(0, size - 1);
        int i = 0;
        for (String register : linkedRegisters) {
            if (i == item)
                return register;
            i++;
        }
        return null;
    }

    public static void setCurrentLine(int currentLine) {
        Global.currentLine = currentLine;
    }

    public static int getCurrentLine() {
        return currentLine;
    }

    public static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
