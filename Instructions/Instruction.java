package Instructions;

import utils.Global;

public abstract class Instruction {
    private final String name;
    private final String opcode;
    private final String funct;
    private final int currentline;
    private String tag = "Line1";

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
    public Instruction(int currentLine, String name, String opcode, String funct) {
        this.currentline = currentLine;
        this.name = name;
        this.opcode = opcode;
        this.funct = funct;
    }

    protected String Zero() {
        return "$zero";
    }

    protected String randomRegister() {
        int reg = (int) (Math.random() * 32);
        // DO NOT TAMPER WITH $at,$v0,$v1,$k0,$k1,$gp,$sp,$fp,$ra
        while (reg == 1 || reg == 2 || reg == 3 || reg == 26 || reg == 27 || reg == 28 || reg == 29 || reg == 30
                || reg == 31) {
            reg = (int) (Math.random() * 32);
        }
        return Global.getRegisterName(reg);
    }

    public abstract String toString();

}
