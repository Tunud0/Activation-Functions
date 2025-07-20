package dotstudios.net;

import dotstudios.net.nn.modules.initializers.InitializerFunction;

public class Main {
    public static void main(String[] args) {
        double n = 100;
        System.out.println(new InitializerFunction().Gaussian(n,0,100));
    }
}