package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public abstract class ByteCode {

    /**
     * This method is used to initialize bytecode
     * @param args
     */
    public abstract void init(ArrayList<String> args);

    /**
     * This method is used to execute bytecode
     * @param virtualMachine virtual machine
     */
    public abstract void execute(VirtualMachine virtualMachine);

}
