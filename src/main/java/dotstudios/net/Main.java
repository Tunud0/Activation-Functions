package dotstudios.net;

import dotstudios.net.nn.modules.activation.ACTFUNCType;
import dotstudios.net.nn.modules.activation.ActFunc;

public class Main {
    public static void main(String[] args) {
        double n = -4;
        System.out.println(ACTFUNCType.values().length);
        System.out.println(new ActFunc(ACTFUNCType.CeLU,n).get());
    }
}