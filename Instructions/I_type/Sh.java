package Instructions.I_type;

import utils.Global;
import Instructions.Itype;

public class Sh extends Itype {
    public Sh() {
        super("sh", 1, Zero(), randomRegister(), randomImmediate());
    }

    private static String randomImmediate() {
        int RandOffset = Global.getRandom(0, 0x2ffe) & 0xfffffffe;
        Global.addWrittenMemoryOffset(RandOffset);
        return Integer.toString(RandOffset);
    }
}
