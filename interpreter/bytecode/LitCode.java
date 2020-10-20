package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public class LitCode extends ByteCode {


    /**
     * The Lit ByteCode takes 1 or 2 arguments.
     *The Lit ByteCode should only push 1 value to the top of the runtime stack.
     * If dumping is on, Lit ByteCode needs to be dumped according the specifications in the Dumping formats section. Lit ByteCode Format
     */


    private int value;
    private String id;

    @Override
    public void init(ArrayList<String> args) {

        this.value = Integer.parseInt(args.get(0));
        if(args.size() > 1) this.id = args.get(1);


    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        //load the value onto the run time stack
        if(id == null) {
            virtualMachine.pushToRunTimeStack(value);
        } else {
            virtualMachine.pushToRunTimeStack(0);
        }

    }

    public String toString(){

        String bass = "LIT " + value;
        if(id != null){
            bass +=" int " + id;
        }
        return bass;
    }


}
