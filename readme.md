# Activation functions

A library that collects some activation functions.

## To instance the class and calculate:
```java
import dotstudios.net.activations.InitializerFunction;

public class Main {
    public static void main(String[] args) {
        double n = 345;
        InitializerFunction f = new InitializerFunction(); //Initialize the class
        System.out.println(f.Gaussian(n,16,100)); //Print the result
    }
}
```

## Algorithms

## - Linear
#### Parameters: x
$$result = x$$
#### Codomain: $$(-\infty, +\infty)$$

## - PieceWiseLinear
#### Parameters: x
$$x < -0.5: result = 0$$
$$x >= -0.5 \wedge x < 0.5: result = x + 0.5$$
$$x >= 0.5: result = 1$$
#### Codomain: $$[0, 1]$$

## - BinaryStep
#### Parameters: x
$$x < 0: result = 0$$
$$x >= 0: result = 1$$
#### Codomain: $$0 \vee 1$$

## - Sigmoid
#### Parameters: x
$$S(x) = {{1 \over 1 + e^{-x}}}$$
#### Codomain: $$(0, 1)$$

## - LogSigmoid
#### Parameters: x
$$S(x) = log({{1 \over 1 + e^{-x}}})$$
#### Codomain: $$(-\infty, 0)$$

## - HardSigmoid
#### Parameters: x
$$x <= -3: result = 0$$
$$x >= 3: result = 1$$
$$x > -3 \wedge x < 3: result = {x \over 6} + 0.5$$
#### Codomain: $$[0, 1]$$

## - Erf
#### Parameters: x
$$t = \frac{1}{1 + 0.5 |x|}$$
$$result = 1 - t \cdot e^{-x^2 - 1.26551223 + t(1.00002368 + t(0.37409196 + t(0.09678418 + t(-0.18628806 + t(0.27886807 + t(-1.13520398 + t(1.48851587 + t(-0.82215223 + t(0.17087277)))))))))}$$
#### Codomain: $$(-1, 1)$$

## - ReLU
#### Parameters: x
$$R(x) = max(0,x)$$
#### Codomain: $$[0, +\infty)$$

## - CeLU
#### Parameters: x, alpha(default is 1)
$$x < 0: result = alpha \cdot (exp( {x \over alpha}) - 1)$$
$$x >= 0: result = x$$
#### Codomain: $$(-alpha, \infty)$$

## - LeakyReLU
#### Parameters: x, nSlope(default is 0.1)
$$LR(x) = max(nSlope \cdot x, x)$$
#### Codomain: $$(-\infty, \infty)$$

## - ReLU6
#### Parameters: x
$$ReLU6(x) = min(6,max(0,x))$$
#### Codomain: $$[0, 6]$$

## - PReLU
#### Parameters: x, nSlope(default is 0.01)
$$x >= 0: result = x$$
$$x < 0: result = nSlope \cdot x$$
#### Codomain: $$(-\infty, \infty)$$

## - GeLU
#### Parameters: x
$${1 \over 2} \cdot x \cdot ({1 + Erf({x \over sqrt(2)})})$$
#### Codomain: $$[\approx -0.17002$, +\infty)$$

## - Gaussian
#### Parameters: x, standardDeviation( sigma ), Mean ( mu )
$$exp({-\frac{(x-\mu)^2}{2\sigma^2}})$$
#### Codomain: $$(0, 1]$$

## - Elu
#### Parameters: x, alpha(default is 1)
$$x >= 0: result = x$$
$$x < 0: result = alpha \cdot (exp(x) - 1)$$
#### Codomain: $$(-alpha, +\infty)$$

## - Selu
#### Parameters: x, alpha(default is 1.67326324), scale(default is 1.05070098)
$$x > 0: result = scale * x$$
$$x <= 0: result = scale \cdot alpha \cdot (exp(x) - 1)$$
#### Codomain: $$(-scale \cdot alpha, +\infty)$$

## - SiLU
#### Parameters: x
$$SiLU(x) = x \cdot sigmoid(x)$$
#### Codomain: $$[\approx -0.27846, +\infty)$$

## - HardSiLU
#### Parameters: x
$$x < -3: result = 0$$
$$x > 3: result = x$$
$$x >= -3 \wedge x <= 3: result = x \cdot {{x + 3} \over 6}$$
#### Codomain: $$[-0.375, +\infty)$$

## - TanH
#### Parameters: x
$$tanh(x) = \frac{e^{x} - e^{-x}}{e^{x} + e^{-x}}$$
#### Codomain: $$(-1, 1)$$

## - Coth
#### Parameters: x
$$coth(x) = {1 \over tanh(x)}$$
#### Codomain: $$(-\infty, -1) \cup (1, +\infty)$$

## - TanHShrink
#### Parameters: x
$$TanHShrink(x) = x - \tanh(x)$$
#### Codomain: $$(-\infty, +\infty)$$

## - HardTanH
#### Parameters: x, min(default is -1), max(default is 1)
$$x >= max: result = max$$
$$x > min \wedge x < max: result = x$$
$$x < min: result = min$$
#### Codomain: $$[min, max]$$

## - SoftSign
#### Parameters: x
$$softsing(x) = {x \over {1 + |x|}}$$
#### Codomain: $$(-1, 1)$$

## - Swish
#### Parameters: x
$$Swish(x) = silu(x)$$
#### Codomain: $$[\approx -0.27846, +\infty)$$

## - HardSwish
#### Parameters: x
$$HardSwish(x) = HardSiLU(x)$$
#### Codomain: $$[-0.375, +\infty)$$

## - SoftPlus
#### Parameters: x
$$softplus(x) = ln({1 + exp(x)})$$
#### Codomain: $$(0, +\infty)$$

## - Mish
#### Parameters: x
$$Mish(x) = x \cdot \tanh(\text{softplus}(x))$$
#### Codomain: $$[\approx -0.3088, +\infty)$$

## - SoftShrink
#### Parameters: x, threshold(default is 0.5)
$$x > threshold: result = x - threshold$$
$$x < -threshold: result = threshold + x$$
$$x >= -threshold \wedge x < threshold: result = 0$$
#### Codomain: $$(-\infty, +\infty)$$

## - HardShrink
#### Parameters: x, threshold(default is 0.5)
$$|x| > threshold: result = x$$
$$|x| <= threshold: result = 0$$
#### Codomain: $$(-\infty, -threshold) \cup \{0\} \cup (threshold, +\infty)$$

## - UnitStep
#### Parameters: x
$$x < 0: result = 0$$
$$x > 0: result = 1$$
$$x == 0: result = 0.5$$
#### Codomain: $${0; 0.5; 1}$$

## - HardStep
#### Parameters: x, threshold(default is 0)
$$x < threshold: result = 0$$
$$x \ge threshold: result = 1$$
#### Codomain: $\{0, 1\}$

## - Squareplus
#### Parameters: x, b(default is 4)
$$Squareplus(x) = \frac{x + \sqrt{x^2 + b}}{2}$$
#### Codomain: $$(0, +\infty)$$