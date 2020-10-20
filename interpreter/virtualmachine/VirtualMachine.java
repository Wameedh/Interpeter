package interpreter.virtualmachine;

import java.util.Stack;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;


public class VirtualMachine {


    // Used to store all variables in program .
    private RunTimeStack runTimeStack;
    // Used to store return addresses for each called function ( excluding main )
    private Stack<Integer> returnAddress;
    // Reference to the program object where all ByteCodes are stored .
    private Program program;
    // the program counter ( current ByteCode being executed ).
    private int programCounter;
    // Used to determine whether the VirtualMachine should be executing ByteCodes .
    private boolean isRunning;
    private boolean dumpFlag;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);

            code.execute(this);

            if (dumpFlag && !(code instanceof DumpCode)) {
                System.out.println(code);
                runTimeStack.dump();
            }

            programCounter++;
        }

    }


    /**********************************************
     Methods that manages the Return Address Stack
     *********************************************/

    public void pushReturnAddress(int returnAddress) {
        this.returnAddress.push(returnAddress);
    }

    public int popReturnAddress() {
        return this.returnAddress.pop();
    }

    /**************************************
     Methods that manages the Dumb Flag
     *************************************/
    public boolean getDumbFlag() {
        return this.dumpFlag;
    }

    public void setDumbFlag(boolean status) {
        this.dumpFlag = status;
    }

    /*************************************
     Methods that manages the Virtual Machine Running Status
     *************************************/
    public boolean getRunningStatus() {
        return this.isRunning;
    }

    public void setRunningStatus(boolean status) {
        this.isRunning = status;
    }

    /*************************************
     Methods that manages the Program Counter
     *************************************/
    public int getProgramCounter() {
        return this.programCounter;
    }

    /**
     * Takes a programCounter
     *
     * @param programCounter
     */
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }


    /*************************************
     Methods that manages the Run Time Stack
     *************************************/
    /**
     * returns the top of the runtime stack , but does not remove
     *
     * @return copy of the top of the stack .
     */
    public int getTopOfRunTimeStack() {
        return this.runTimeStack.peek();
    }

    /**
     * @return the Run Time Stack.
     */
    public RunTimeStack getRunTimeStack() {
        return this.runTimeStack;
    }

    /**
     * removes to the top of the runtime stack .
     *
     * @return the value popped .
     */
    public int popTopOfRunTimeStack() {
        return this.runTimeStack.pop();
    }

    /**
     * push the value i to the top of the stack .
     *
     * @param valueToPush value to be pushed .
     * @return value pushed
     **/

    public int pushToRunTimeStack(int valueToPush) {
        return this.runTimeStack.push(valueToPush);
    }

    /**
     * Takes the top item of the run time stack , and stores
     * it into a offset starting from the current frame .
     *
     * @param offset number of slots above current frame marker
     * @return the item just stored
     */
    public int storeItemTopItemOfRunTimeStackIntoAnOffset(int offset) {
        return this.runTimeStack.store(offset);
    }

    /**
     * Takes a value from the run time stack that is at offset
     * from the current frame marker and pushes it onto the top of
     * the stack .
     *
     * @param offset number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int loadValueOnTopOfRunTimeStack(int offset) {
        return this.runTimeStack.load(offset);
    }

    /**
     * create a new frame pointer at the index offset slots down
     * from the top of the runtime stack .
     *
     * @param offset slots down from the top of the runtime stack
     */
    public void newFrameAtOffsetDownFromTopOfRunTimeStack(int offset) {
        this.runTimeStack.newFrameAt(offset);
    }

    /**
     * pop the current frame off the runtime stack. Also removes
     * the frame pointer value from the FramePointer Stack .
     */
    public void popCurrentFrameOfRunTimeStack() {
        this.runTimeStack.popFrame();
    }


}
