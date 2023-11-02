package Instructions;

public class InstrFactory {
    public InstrFactory() {
    }

    public Instruction getInstr(int currentline, int id) {
        return new Nop(currentline);
    }
}
