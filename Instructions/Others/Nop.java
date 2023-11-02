package Instructions.Others;

import utils.Global;
import Instructions.Instruction;

public class Nop extends Instruction {
    public Nop() {
        super(Global.getCurrentLine(), "nop");
    }

    @Override
    public String toString() {
        return getLabel() + super.name;
    }
}
