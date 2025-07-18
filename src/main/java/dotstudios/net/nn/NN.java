package dotstudios.net.nn;

import lombok.Getter;

@Getter
public abstract class NN {
    private final int inputSize,outputSize;
    protected NN(int inputSize, int outputSize) {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
    }
    public abstract void calculate();
}
