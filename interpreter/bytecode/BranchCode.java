package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Wameedh
 */

public abstract class BranchCode extends ByteCode {
    public abstract void init(ArrayList<String> args);
    public abstract void execute(VirtualMachine virtualMachine);
    public abstract int getTargetAddress();
    public abstract void setTargetAddress(int index);
    public abstract String getLabel();
}