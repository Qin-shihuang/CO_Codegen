package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sra extends Itype {
    public Sra() {
        super("sra", 0, randomRegister(), randomRegister(), randomShamt());
    }

    private static String randomShamt() {
        return Global.getRandom(0, 0x1f) + "";
    }
}