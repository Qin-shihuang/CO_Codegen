package Instructions;

public class Nop extends Instruction {
    public Nop(int currentLine) {
        super(currentLine, "nop", "000000", "000000");
    }

    @Override
    public String toString() {
        return "nop";
    }
}
