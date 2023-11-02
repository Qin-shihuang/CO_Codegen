package Instructions.J_type;

import Instructions.Jtype;
import utils.Global;

public class Jal extends Jtype {

    public Jal() {
        super(Global.getCurrentLine(), "jal", label());
    }

    public Jal(String label) {
        super(Global.getCurrentLine(), "jal", label);
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