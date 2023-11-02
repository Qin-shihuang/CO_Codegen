package utils;

import Instructions.Instruction;
import Instructions.Others.Nop;

public class InstrFactory {
    public InstrFactory() {
    }

    public Instruction getInstr(int currentline, int id) {
        return new Nop();
    }
}
