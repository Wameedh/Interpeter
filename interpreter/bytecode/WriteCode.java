package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public class WriteCode extends ByteCode {

    /**
     * Prints the top of the runtime stack to the console.
     * NO OTHER information can be printed by the Write ByteCode when printing the value.
     * If dumping is on, Simply print "WRITE" to the console.
     */

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.getTopOfRunTimeStack());
    }
    public String toString(){
        return "WRITE";
    }
}
