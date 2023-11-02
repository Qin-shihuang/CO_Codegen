package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sw extends Itype {
    public Sw() {
        super("sw", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        int RandOffset = Global.getRandom(0, 0x2ffc) & 0xfffffffc;
        Global.addWrittenMemoryOffset(RandOffset);
        return Integer.toString(RandOffset);
    }
}
