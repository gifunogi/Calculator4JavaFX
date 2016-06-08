import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

public class Calculation {

    public static BigDecimal calculate(String input) throws ParseException {
        Reader r = new StringReader(input);
        Parser parser = new Parser(r);
        Node tree = parser.start();
        if (tree == null) {
            return BigDecimal.ONE;
        }
        return tree.eval().stripTrailingZeros();
    }
}
