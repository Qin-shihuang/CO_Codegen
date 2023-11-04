import java.util.Scanner;

import utils.Global;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String configPath = "codegen.cfg";
        Scanner scanner = null;
        if (args.length > 0) {
            configPath = args[0];
        }
        File configFile = new File(configPath);
        try {
            scanner = new Scanner(configFile);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        String line = null;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.charAt(0) == '#') {
                continue;
            }
            line = line.split("#")[0].trim();
            if (line.equals("[Config]")) {
                readConfig(scanner);
                break;
            }
        }
        scanner.close();
        Generate.run();
    }

    private static void readConfig(Scanner scanner) {
        String line = null;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.charAt(0) == '#') {
                continue;
            }
            line = line.split("#")[0].trim();
            if (line.split("=")[0].trim().equals("MaxInstr")) {
                Global.setMaxInstructions(Integer.parseInt(line.split("=")[1].trim()));
            } else if (line.split("=")[0].trim().equals("InstrSet")) {
                do {
                    line = line.split("#")[0].trim();
                    if (line.contains("=")) {
                        line = line.split("=")[1].trim();
                    }
                    String[] instrs = line.split("\\\\")[0].trim().split(" +");
                    String LastInstruction = null;
                    for (String instr : instrs) {
                        if (instr.matches("[a-zA-Z]+")) {
                            LastInstruction = instr.toUpperCase();
                            Global.addInstruction(LastInstruction);
                        } else if (instr.matches("[0-9]+")) {
                            for (int i = 0; i < Integer.parseInt(instr) - 1; i++) {
                                Global.addInstruction(LastInstruction);
                            }
                        }
                    }
                } while (line.contains("\\") && scanner.hasNextLine() && !(line = scanner.nextLine().trim()).isEmpty());
            } else if (line.split("=")[0].trim().equals("OutputFile")) {
                Global.setOutput(new File(line.split("=")[1].trim()));
            }
        }
    }
}