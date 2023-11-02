package Instructions;

import utils.Global;

public abstract class Instruction {
    protected final String name;
    protected final int currentLine =Global.getCurrentLine();
    /*
     * 0: R-type
     * add, sub
     * Format: example $rd, $rs, $rt
     * 1: I-type
     * ori,lui
     * Format: example $rt, $rs, imm
     * 2: I-type
     * lw, sw
     * Format: example $rt, imm($rs)
     * 3: I-type
     * beq
     * Format: example $rs, $rt, tag
     * 4: J-type
     * jr
     * Format: example $rs
     * 5: J-type
     * jal
     * Format: example tag
     * 6: NOP
     * nop
     */
    public Instruction(String name) {
        this.name = name;
    }

    protected String getLabel() {
        return "L" + this.currentLine + ": ";
    }

    protected static String Zero() {
        return "$zero";
    }

    protected static String randomRegister() {
        int reg = Global.getRandom(0, 31);
        // DO NOT TAMPER WITH $at,$v0,$v1,$k0,$k1,$gp,$sp,$fp,$ra
        while (reg == 1 || reg == 2 || reg == 3 || reg == 26 || reg == 27 || reg == 28 || reg == 29 || reg == 30
                || reg == 31) {
            reg = Global.getRandom(0, 31);
        }
        return Global.getRegisterName(reg);
    }

    public abstract String toString();

}
