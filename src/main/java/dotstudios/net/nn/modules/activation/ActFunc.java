package dotstudios.net.nn.modules.activation;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ActFunc {
    private final ACTFUNCType type;
    private final double number;
    @Setter
    //Used in the PReLU function
    private double aPReLU = 0.01,
        //Used in HardTanH function
        aHardTanH = -1, bHardTanH = 1,
        //Default value for leaky relu negative slope
        slopeNLReLU = 0.1,
        //By default, it has the same value of relu6
        reLUof = 6,
        aElu = 1,
        //Used in Shrink functions
        threshold = 0.5,
        //Used on Selu function
        alphaSelu = 1.67326324,
        scaleSelu = 1.05070098,
        //Used in ceLU function
        alphaCeLU = 1;
    public ActFunc(ACTFUNCType type, double number) {
        this.type = type;
        this.number = number;
    }
    public double get() {
        switch (type) {
            case Sigmoid -> {
                //0 to 1
                return 1f / (1 + Math.exp(-number));
            }
            case LogSigmoid -> {
                return Math.log(1f / (1 + Math.exp(-number)));
            }
            case HardSigmoid -> {
                if(number <= -3)
                    return 0;
                else if(number >= 3)
                    return 1;
                else return number/6f + 0.5;
            }
            case Erf -> {
                double t = 1f / (1 + 0.5 * Math.abs(number));
                double r = 1 - t * Math.exp(
                        -number*number - 1.26551223 +
                        t * ( 1.00002368 +
                        t * ( 0.37409196 +
                        t * ( 0.09678418 +
                        t * (-0.18628806 +
                        t * ( 0.27886807 +
                        t * (-1.13520398 +
                        t * ( 1.48851587 +
                        t * (-0.82215223 +
                        t * ( 0.17087277)))))))))
                );
                return number >= 0 ? r : -r;
            }
            case ReLU -> {
                //0 to infinite
                return Math.max(0,number);
            }
            case CeLU -> {
                if(number < 0)
                    return alphaCeLU * (Math.exp(number / alphaCeLU) - 1);
                else return number;
            }
            case LeakyReLU -> {
                return Math.max(slopeNLReLU*number,number);
            }
            case ReLU6 -> {
                return Math.min(Math.max(0,number),6);
            }
            case ReLUofN -> {
                return Math.min(Math.max(0,number),reLUof);
            }
            case PReLU -> {
                if(number >= 0) return number;
                else return Math.max(aPReLU*number,number);
            }
            case GELU -> {
                return number*0.5*(1 + new ActFunc(ACTFUNCType.Erf,number / Math.sqrt(2)).get());
            }
            case Elu -> {
                if(number >= 0)
                    return number;
                else return aElu*(Math.exp(number) - 1);
            }
            case Selu -> {
                if(number > 0)
                    return scaleSelu*number;
                else return scaleSelu*alphaSelu*(Math.exp(number)-1);
            }
            case SiLU -> {
                return number*new ActFunc(ACTFUNCType.Sigmoid,number).get();
            }
            case HardSiLU -> {
                if(number < -3)
                    return 0;
                else if(number > 3)
                    return number;
                else return number * (number + 3) / 6;
            }
            case TanH -> {
                //-1 to 1
                double r = (Math.exp(number) - Math.exp(-number)) / (Math.exp(number) + Math.exp(-number));
                return Double.isFinite(r) ? r : 1;
            }
            case ArcTan -> {
                return 1f/new ActFunc(ACTFUNCType.TanH,number).get();
            }
            case TanHShrink -> {
                return number - new ActFunc(ACTFUNCType.TanH,number).get();
            }
            case HardTanH -> {
                if(number >= aHardTanH)
                    return aHardTanH;
                else if(number <= bHardTanH)
                    return bHardTanH;
                else return number;
            }
            case SoftSign -> {
                //-1 to 1
                return number / (1f + Math.abs(number));
            }
            case Swish -> {
                //non linear
                return number * new ActFunc(ACTFUNCType.Sigmoid,number).get();
            }
            case HardSwish -> {
                return number * (new ActFunc(ACTFUNCType.ReLU6,number + 3).get() / 6f);
            }
            case SoftPlus -> {
                return Math.log(1 + Math.exp(number));
            }
            case Mish -> {
                return number * new ActFunc(ACTFUNCType.TanH,new ActFunc(ACTFUNCType.SoftPlus,number).get()).get();
            }
            case SoftShrink -> {
                if(number > threshold)
                    return number - threshold;
                else if(number < threshold)
                    return threshold - number;
                else return 0;
            }
            case HardShrink -> {
                if(Math.abs(number) > threshold)
                    return number;
                else return 0;
            }
            case Linear -> {
                return number;
            }
        }
        return Integer.MAX_VALUE;
    }
}
