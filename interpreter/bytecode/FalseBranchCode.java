package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * @author Wameedh
 */

public class FalseBranchCode extends BranchCode {


    /**
     * FalseBranch takes one argument, a label to jump to.
     * FalseBranch's label address will need to be resolved. This requires computing where
     * FalseBranch will jump to if the value popped from the stack is 0. Address resolution
     * needs to be done before you began executing the program. This will be discussed later
     * in this document.
     * Remove the top value of the stack.
     * - if value is 0, jump to label.
     * - if value is not 0, move to next ByteCode.
     * If dump is on, FalseBranch ByteCode is required to be dumped. Examples are given
     * later in this document.
     */

    private String label;
    private int targetAddress; //target address

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //if it is false(0), branch to the address

        if (virtualMachine.getTopOfRunTimeStack() == 0) {
            virtualMachine.setProgramCounter(this.targetAddress);
        }
    }

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
        return this.label;
    }

    public void setLabel(int index) {
        this.label = Integer.toString(index);
    }

    public String toString() {
        return "FALSE BRANCH " + label;
    }
}
