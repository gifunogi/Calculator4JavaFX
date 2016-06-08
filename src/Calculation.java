import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class Calculation {

    public static BigDecimal calculate(String input) throws ParseException {
        Reader r = new StringReader(input);
        Parser parser = new Parser(r);
        Node tree = parser.start();
        if (tree == null) {
            return BigDecimal.ZERO;
        }
        return tree.eval().stripTrailingZeros();
    }
}

abstract class Node {
    public abstract void setOp(char c);

    public abstract void addLeft(Node node);

    public abstract void addRight(Node node);

    public abstract BigDecimal eval();
}

class Num extends Node {

    public Num(BigDecimal n) {
        value = n;
    }

    public void setOp(char c1) {
    }

    public void addLeft(Node node) {
    }

    public void addRight(Node node) {
    }

    public BigDecimal eval() {
        return value;
    }

    private BigDecimal value;
}

class Op extends Node {

    private char op;
    private Node left;
    private Node right;

    public static Node connectToLeft(Node n) {
        Op result = new Op();
        result.left = n;
        return result;
    }

    public Op() {
    }

    public void setOp(char c) {
        op = c;
    }

    public void addLeft(Node n) {
        left = n;
    }

    public void addRight(Node n) {
        right = n;
    }

    public BigDecimal eval() {
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal leftValue = BigDecimal.ZERO;
        BigDecimal rightValue = BigDecimal.ZERO;
        if (left != null)
            leftValue = left.eval();
        if (right != null)
            rightValue = right.eval();
        switch (op) {
            case '+':
                value = leftValue.add(rightValue, MathContext.DECIMAL128);
                break;
            case '-':
                value = leftValue.subtract(rightValue, MathContext.DECIMAL128);
                break;
            case '*':
                value = leftValue.multiply(rightValue, MathContext.DECIMAL128);
                break;
            case '/':
                value = leftValue.divide(rightValue, MathContext.DECIMAL128);
                break;
        }
        return value;
    }
}
