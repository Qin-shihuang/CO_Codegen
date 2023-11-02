package Instructions.R_type;

import utils.Global;
import Instructions.Rtype;

public class Add extends Rtype {
    public Add() {
        super(Global.getCurrentLine(), "add", randomRegister(), randomRegister(), randomRegister());
    }
}
