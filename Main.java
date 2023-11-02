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
            if (line.split("=")[0].equals("MaxInstr")) {
                Global.setMaxInstructions(Integer.parseInt(line.split("=")[1]));
            } else if (line.split("=")[0].trim().equals("InstrSet")) {
                String[] instrs = line.split("=")[1].split(" ");
                for (String instr : instrs) {
                    Global.addInstruction(instr.toUpperCase());
                }
            } else if (line.split("=")[0].trim().equals("Output")) {
                Global.setOutput(new File(line.split("=")[1].trim()));
            }
        }
    }
}