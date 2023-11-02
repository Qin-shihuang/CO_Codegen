package Instructions.Others;

import Instructions.Instruction;
import utils.Global;

public class Nop extends Instruction {
    public Nop() {
        super(Global.getCurrentLine(), "nop");
    }

    @Override
    public String toString() {
        return getLabel() + super.name;
    }
}
