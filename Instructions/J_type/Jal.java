package Instructions.J_type;

import utils.Global;
import Instructions.Jtype;

public class Jal extends Jtype {

    public Jal() {
        super("jal", label());
    }

    public Jal(String label) {
        super("jal", label);
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
