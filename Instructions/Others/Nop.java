package Instructions.Others;

import Instructions.Instruction;

public class Nop extends Instruction {
    public Nop() {
        super("nop");
    }

    @Override
    public String toString() {
        return getLabel() + super.name;
    }
}
