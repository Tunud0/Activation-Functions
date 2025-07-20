package dotstudios.net;

import dotstudios.net.nn.modules.initializers.InitializerFunction;

public class Main {
    public static void main(String[] args) {
        double n = 138;
        System.out.println(new InitializerFunction().Gaussian(n,16,100));
    }
}