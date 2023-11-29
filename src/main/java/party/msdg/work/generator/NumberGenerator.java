package party.msdg.work.generator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Wow! Sweet moon.
 */
@Component
public class NumberGenerator {
    
    /**
     * 随机生成指定范围的整数
     * [min, max]
     * @param max   最大
     * @param min   最小
     */
    public int nextInt(int max, int min) {
        
        return (int) (min + Math.random() * (max + 1 - min));
    }
    
    public double nextDouble(double max, double min, int precision) {
        double value = ThreadLocalRandom.current().nextDouble(min, max);
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(precision, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
