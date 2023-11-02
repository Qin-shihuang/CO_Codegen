package utils;

import Instructions.Instruction;

public class InstrFactory {
    public InstrFactory() {
    }

    public static Instruction getInstructionNoArg(int Id) {
        switch (Id) {
            case 0:
                return getAddNoArg();
            case 1:
                return getSubNoArg();
            case 2:
                return getAdduNoArg();
            case 3:
                return getSubuNoArg();
            case 4:
                return getOriNoArg();
            case 5:
                return getLwNoArg();
            case 6:
                return getSwNoArg();
            case 7:
                return getBeqNoArg();
            case 8:
                return getLuiNoArg();
            case 9:
                return getJalNoArg();
            case 10:
                return getJrNoArg();
            case 11:
                return getNopNoArg();
            default:
                return null;
        }
    }

    public static Instruction getNopNoArg() {
        return new Instructions.Others.Nop();
    }

    public static Instruction getJrNoArg() {
        return new Instructions.Others.Jr();
    }

    public static Instruction getJr(String rs) {
        return new Instructions.Others.Jr(rs);
    }

    public static Instruction getJalNoArg() {
        return new Instructions.J_type.Jal();
    }

    public static Instruction getJal(String label) {
        return new Instructions.J_type.Jal(label);
    }

    public static Instruction getAddNoArg() {
        return new Instructions.R_type.Add();
    }

    public static Instruction getAdduNoArg() {
        return new Instructions.R_type.Addu();
    }

    public static Instruction getSubNoArg() {
        return new Instructions.R_type.Sub();
    }

    public static Instruction getSubuNoArg() {
        return new Instructions.R_type.Subu();
    }

    public static Instruction getBeqNoArg() {
        return new Instructions.I_type.Beq();
    }

    public static Instruction getBeq(String rs, String rt, String label) {
        return new Instructions.I_type.Beq(rs, rt, label);
    }

    public static Instruction getLuiNoArg() {
        return new Instructions.Others.Lui();
    }

    public static Instruction getLui(String rt) {
        return new Instructions.Others.Lui(rt);
    }

    public static Instruction getOriNoArg() {
        return new Instructions.I_type.Ori();
    }

    public static Instruction getOri(String rs, String rt) {
        return new Instructions.I_type.Ori(rs, rt);
    }

    public static Instruction getLwNoArg() {
        return new Instructions.I_type.Lw();
    }

    public static Instruction getSwNoArg() {
        return new Instructions.I_type.Sw();
    }

}
