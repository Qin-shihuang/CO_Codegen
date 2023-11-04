package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sb extends Itype {
    public Sb() {
        super("sb", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        int RandOffset = Global.getRandom(0, 0x2fff);
        Global.addWrittenMemoryOffset(RandOffset);
        return Integer.toString(RandOffset);
    }
}
