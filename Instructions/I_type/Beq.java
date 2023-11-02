package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Beq extends Itype {
    public Beq() {
        super(Global.getCurrentLine(), "beq", 2, randomRegister(), randomRegister(), label());
    }

    public Beq(String rs, String rt, String label) {
        super(Global.getCurrentLine(), "beq", 2, rs, rt, label);
    }

    private static String label() {
        boolean back = Math.random() < 0.5;
        if (back) {
            int line = Global.getRandom(0, Global.getCurrentLine() - 1);
            return "L" + line;
        } else {
            int line = Global.getRandom(Global.getCurrentLine() + 1, Global.getMaxInstructions());
            return "L" + line;
        }
    }
}
