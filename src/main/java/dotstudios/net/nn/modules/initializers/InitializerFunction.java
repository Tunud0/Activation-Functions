package dotstudios.net.nn.modules.initializers;

public class InitializerFunction implements InitFuncINTFACE {
    @Override
    public double Linear(double x) {
        return x;
    }
    @Override
    public double PieceWiseLinear(double x) {
        //0 to 1
        if(x >= 0.5)
            return 1;
        else if (x < 0.5 && x > -0.5)
            return x + 0.5;
        else return 0;
    }
    @Override
    public double BinaryStep(double x) {
        if(x < 0)
            return 0;
        else return 1;
    }
    @Override
    public double Sigmoid(double x) {
        //0 to 1
        return 1f / (1 + Math.exp(-x));
    }
    @Override
    public double LogSigmoid(double x) {
        //-Infinity to 0
        return Math.log(1f / (1 + Math.exp(-x)));
    }
    @Override
    public double HardSigmoid(double x) {
        //0 to 1
        if(x <= -3)
            return 0;
        else if(x >= 3)
            return 1;
        else return x/6f + 0.5;
    }
    @Override
    public double Erf(double x) {
        //-1 to 1
        double t = 1f / (1 + 0.5 * Math.abs(x));
        double r = 1 - t * Math.exp(
                -x*x - 1.26551223 +
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
        return Math.abs(r);
    }
    @Override
    public double ReLU(double x) {
        //0 to infinite
        return Math.max(0,x);
    }
    @Override
    public double CeLU(double x, double alpha) {
        if(x < 0)
            return alpha * (Math.exp(x / alpha) - 1);
        else return x;
    }
    @Override
    public double CeLU(double x) {
        return this.CeLU(x,1);
    }
    @Override
    public double LeakyReLU(double x, double nSlope) {
        //-Infinity to +Infinity
        return Math.max(nSlope*x,x);
    }
    @Override
    public double LeakyReLU(double x) {
        //-Infinity to +Infinity
        return this.LeakyReLU(x,0.1);
    }
    @Override
    public double ReLUofN(double x, double n) {
        return Math.min(Math.max(0,x),n);
    }
    @Override
    public double ReLU6(double x) {
        return this.ReLUofN(x,6);
    }
    @Override
    public double PReLU(double x, double nSlope) {
        if(x >= 0) return x;
        else return Math.max(nSlope*x,x);
    }
    @Override
    public double PReLU(double x) {
        return this.PReLU(x,0.01);
    }
    @Override
    public double GeLU(double x) {
        return x*0.5*(1 + this.Erf(x / Math.sqrt(2)));
    }
    @Override
    public double Gaussian(double x, double standardDeviation, double medium) {
        return Math.exp(-(Math.pow(x-medium,2)) / (2*Math.pow((standardDeviation),2)));
    }
    @Override
    public double Elu(double x, double alpha) {
        if(x >= 0)
            return x;
        else return alpha*(Math.exp(x) - 1);
    }
    @Override
    public double Elu(double x) {
        return this.Elu(x,1);
    }
    @Override
    public double Selu(double x, double scale,double alpha) {
        if(x > 0)
            return scale*x;
        else return scale*alpha*(Math.exp(x)-1);
    }
    @Override
    public double Selu(double x) {
        return this.Selu(x,1.05070098,1.67326324);
    }
    @Override
    public double SiLU(double x) {
        return x*this.Sigmoid(x);
    }
    @Override
    public double HardSiLU(double x) {
        if(x < -3)
            return 0;
        else if(x > 3)
            return x;
        else return x * (x + 3) / 6;
    }
    @Override
    public double TanH(double x) {
        double r = (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        return Double.isFinite(r) ? r : 1;
    }
    @Override
    public double ArcTan(double x) {
        return 1f/this.TanH(x);
    }
    @Override
    public double TanHShrink(double x) {
        return x - this.TanH(x);
    }
    @Override
    public double HardTanH(double x, double min, double max) {
        if(x >= max)
            return max;
        else return Math.max(x,min);
    }
    @Override
    public double HardTanH(double x) {
        return this.HardTanH(x,-1,1);
    }
    @Override
    public double SoftSign(double x) {
        //-1 to 1
        return x / (1f + Math.abs(x));
    }
    @Override
    public double Swish(double x) {
        return this.SiLU(x);
    }
    @Override
    public double HardSwish(double x) {
        return this.HardSiLU(x);
    }
    @Override
    public double SoftPlus(double x) {
        return Math.log(1 + Math.exp(x));
    }
    @Override
    public double Mish(double x) {
        return x * this.TanH(this.SoftPlus(x));
    }
    @Override
    public double SoftShrink(double x, double threshold) {
        if(x > threshold)
            return x - threshold;
        else if(x < threshold)
            return threshold - x;
        else return 0;
    }
    @Override
    public double SoftShrink(double x) {
        return this.SoftShrink(x,0.5);
    }
    @Override
    public double HardShrink(double x, double threshold) {
        if(Math.abs(x) > threshold)
            return x;
        else return 0;
    }
    @Override
    public double HardShrink(double x) {
        return this.HardShrink(x,0.5);
    }
    @Override
    public double UnitStep(double x) {
        if(x < 0)
            return 0;
        else if(x > 0)
            return 1;
        else return 0.5;
    }
}
