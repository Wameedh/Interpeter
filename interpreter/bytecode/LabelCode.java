
package interpreter.bytecode;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;
/**
 *
 * @author Wameedh
 */
public class LabelCode extends ByteCode{

    /**
     * Label takes one argument, a label which is used to denote a location in the program.
     * Dumping Label ByteCodes is optional.
     */

    private String label;

    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    @Override
    public void execute(VirtualMachine virtualMachine){ }

    public String getLabel() {
        return label;
    }

    public String toString(){
        return "LABEL " + label;
    }

}