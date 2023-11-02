package Instructions.Others;

import utils.Global;
import Instructions.Instruction;

public class Lui extends Instruction {
    private final String rt;
    private final String immediate;

    public Lui() {
        super("lui");
        this.rt = randomRegister();
        this.immediate = randomImmediate();
    }

    public Lui(String rt) {
        super("lui");
        this.rt = rt;
        this.immediate = randomImmediate();
    }

    private static String randomImmediate() {
        return Global.getRandom(0, 0xffff) + "";
    }

    @Override
    public String toString() {
        return getLabel() + super.name + " " + this.rt + ", " + this.immediate;
    }
}