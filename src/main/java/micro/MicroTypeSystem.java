package micro;
import java.math.BigDecimal;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.*;

@TypeSystem({long.class, double.class})
public class MicroTypeSystem {
    @ImplicitCast
    @TruffleBoundary
    public static double castDouble(long value) {
        return Long.valueOf(value).doubleValue();
    }
}
