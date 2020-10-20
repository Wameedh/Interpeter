package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public class PopCode extends ByteCode {

    /**
     * Pop takes one argument which is the number of values to remove from the run time
     * stack.
     * Pop is not allowed operate across frame boundaries.
     * If dump is on, Pop is required to be dumped. Examples are given in this document.
     */

    protected int numberOfValuesToBePopped;

    @Override
    public void init(ArrayList<String> args) {
        numberOfValuesToBePopped = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        //pop top n level of the run time stack
        for (int i = 0; i < numberOfValuesToBePopped; i++) {
            virtualMachine.popTopOfRunTimeStack();
        }
    }

    public String toString(){
        return "POP " + numberOfValuesToBePopped;
    }


}
