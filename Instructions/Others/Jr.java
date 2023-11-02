package Instructions.Others;

import Instructions.Instruction;
import utils.Global;

public class Jr extends Instruction {
    private String rs;
    public Jr() {
        super(Global.getCurrentLine(), "jr");
        rs = randomRegister();
    }
    public Jr(String rs) {
        super(Global.getCurrentLine(), "jr");
        this.rs = rs;
    }

    @Override
    public String toString() {
        return getLabel() + super.name + " " + this.rs;
    }
}
