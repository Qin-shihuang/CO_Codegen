package Instructions.R_type;

import Instructions.Rtype;

public class Add extends Rtype {
    public Add() {
        super("add", randomRegister(), randomRegister(), randomRegister());
    }
}
