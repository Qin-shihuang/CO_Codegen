package Instructions.Others;

import utils.Global;
import Instructions.Instruction;

public class Jr extends Instruction {
    private String rs;

    public Jr() {
        super("jr");
        rs = randomJumpableRegister();
    }

    public Jr(String rs) {
        super("jr");
        this.rs = rs;
    }

    public static String randomJumpableRegister() {
        return Global.getRamdomLinkedRegister();
    }

    @Override
    public String toString() {
        return getLabel() + super.name + " " + this.rs;
    }
}
