package utils;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import Instructions.Instruction;

public class Print {
    public void printToFile(ArrayList<Instruction> instructions) {
        try {
            File output = Global.getOutput();
            FileWriter writer = new FileWriter(output);
            for (int i = 0; i < instructions.size(); i++) {
                writer.write(instructions.get(i).toString() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
