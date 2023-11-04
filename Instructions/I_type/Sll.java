package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sll extends Itype {
    public Sll() {
        super("sll", 0, randomRegister(), randomRegister(), randomShamt());
    }

    private static String randomShamt() {
        return Global.getRandom(0, 0x1f) + "";
    }
}