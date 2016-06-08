import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.MathContext;

public class Main extends Application {

    public static void main(String arg[]) {
        launch(arg);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
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
    public static Node connectToLeft(Node n) {
        Op result = new Op();
        result.left = n;
        return result;
    }

    public Op() {
    }

    private char op;
    private Node left;
    private Node right;


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