package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class GotoCode extends BranchCode {


    /**
     * Goto has one argument, a label to jump to.
     * Goto's Label must have its address resolved before the program begins executing. More
     * on this later.
     * If dump is on, Goto is required to be dumped.
     */


    private String labelToJump;
    private int targetAddress; //target address

    @Override
    public int getTargetAddress() {
        return this.targetAddress;
    }

    @Override
    public void setTargetAddress(int index) {
        this.targetAddress = index;
    }

    @Override
    public String getLabel() {
        return this.labelToJump;
    }

    public void setLabel(int index) {
        this.labelToJump = Integer.toString(index);
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter(this.targetAddress);

    }

    public String toString() {
        return "Goto " + this.labelToJump;
    }
}
