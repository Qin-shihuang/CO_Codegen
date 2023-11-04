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
            case 12:
                return getJNoArg();
            case 13:
                return getAndNoArg();
            case 14:
                return getOrNoArg();
            case 15:
                return getAddiuNoArg();
            case 16:
                return getSllNoArg();
            case 17:
                return getSrlNoArg();
            case 18:
                return getSraNoArg();
            case 19:
                return getSltNoArg();
            case 20:
                return getSllvNoArg();
            case 21:
                return getSrlvNoArg();
            case 22:
                return getSravNoArg();
            case 23:
                return getLhNoArg();
            case 24:
                return getLhuNoArg();
            case 25:
                return getShNoArg();
            case 26:
                return getLbNoArg();
            case 27:
                return getLbuNoArg();
            case 28:
                return getSbNoArg();
            case 29:
                return getAndiNoArg();
            default:
                return null;
        }
    }

    public static Instruction getJump(int id, String label) {
        //beq j jal
        switch (id) {
            case 7:
                return getBeq(Global.getRegisterName(0),Global.getRegisterName(0),label);
            case 9:
                return getJal(label);
            case 12:
                return getJ(label);
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

    public static Instruction getJNoArg() {
        return new Instructions.J_type.J();
    }

    public static Instruction getJ(String label) {
        return new Instructions.J_type.J(label);
    }

    public static Instruction getAndNoArg() {
        return new Instructions.R_type.And();
    }

    public static Instruction getOrNoArg() {
        return new Instructions.R_type.Or();
    }

    public static Instruction getAddiuNoArg() {
        return new Instructions.I_type.Addiu();
    }

    public static Instruction getSllNoArg() {
        return new Instructions.I_type.Sll();
    }

    public static Instruction getSrlNoArg() {
        return new Instructions.I_type.Srl();
    }

    public static Instruction getSraNoArg() {
        return new Instructions.I_type.Sra();
    }

    public static Instruction getSltNoArg() {
        return new Instructions.R_type.Slt();
    }

    public static Instruction getSllvNoArg() {
        return new Instructions.R_type.Sllv();
    }

    public static Instruction getSrlvNoArg() {
        return new Instructions.R_type.Srlv();
    }

    public static Instruction getSravNoArg() {
        return new Instructions.R_type.Srav();
    }

    public static Instruction getLhNoArg() {
        return new Instructions.I_type.Lh();
    }

    public static Instruction getLhuNoArg() {
        return new Instructions.I_type.Lhu();
    }

    public static Instruction getShNoArg() {
        return new Instructions.I_type.Sh();
    }

    public static Instruction getLbNoArg() {
        return new Instructions.I_type.Lb();
    }

    public static Instruction getLbuNoArg() {
        return new Instructions.I_type.Lbu();
    }

    public static Instruction getSbNoArg() {
        return new Instructions.I_type.Sb();
    }

    public static Instruction getAndiNoArg() {
        return new Instructions.I_type.Andi();
    }
}
