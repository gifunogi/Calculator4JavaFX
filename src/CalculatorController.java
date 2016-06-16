import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CalculatorController implements Initializable {

    @FXML
    private Label label_input;
    @FXML
    private Label label_mark;
    private String input = "";
    private Boolean clearFlag = false;

    public void initialize(URL url, ResourceBundle resourcebundle) {
    }

    private void update_input(String add) {
        if (clearFlag) {
            input = "";
            clearFlag = false;
            label_mark.setText("");
        }
        input += add;
        label_input.setText(input);
    }

    @FXML
    private void on_button_PLUS(ActionEvent event) {
        update_input("+");
    }

    @FXML
    private void on_button_MINUS(ActionEvent event) {
        update_input("-");
    }

    @FXML
    private void on_button_MUL(ActionEvent event) {
        update_input("*");
    }

    @FXML
    private void on_button_DIV(ActionEvent event) {
        update_input("/");
    }

    @FXML
    private void on_button_OPEN(ActionEvent event) {
        update_input("(");
    }

    @FXML
    private void on_button_CLOSE(ActionEvent event) {
        update_input(")");
    }

    @FXML
    private void on_button_POINT(ActionEvent event) {
        update_input(".");
    }

    @FXML
    private void on_button0(ActionEvent event) {
        update_input("0");
    }

    @FXML
    private void on_button1(ActionEvent event) {
        update_input("1");
    }

    @FXML
    private void on_button2(ActionEvent event) {
        update_input("2");
    }

    @FXML
    private void on_button3(ActionEvent event) {
        update_input("3");
    }

    @FXML
    private void on_button4(ActionEvent event) {
        update_input("4");
    }

    @FXML
    private void on_button5(ActionEvent event) {
        update_input("5");
    }

    @FXML
    private void on_button6(ActionEvent event) {
        update_input("6");
    }

    @FXML
    private void on_button7(ActionEvent event) {
        update_input("7");
    }

    @FXML
    private void on_button8(ActionEvent event) {
        update_input("8");
    }

    @FXML
    private void on_button9(ActionEvent event) {
        update_input("9");
    }

    @FXML
    private void on_button_CLEAR(ActionEvent event) {
        clearFlag = true;
        update_input("");
    }

    @FXML
    private void on_button_DEL(ActionEvent event) {
        if (!input.isEmpty() || !Objects.equals(input, "")) {
            input = input.substring(0, input.length() - 1);
            update_input("");
        }
    }

    @FXML
    private void on_button_EQUAL(ActionEvent event) {
        if (clearFlag || input.equals("") || input.isEmpty()) {
            return;
        }
        try {
            BigDecimal result = Calculation.calculate(input);
            input = result.toPlainString();
            label_mark.setText("=");
        } catch (ParseException e) {
            // e.printStackTrace();
            input = "Syntax Error";
            label_mark.setText("E");
        } catch (ArithmeticException e) {
            // e.printStackTrace();
            input = "Div-by-zero";
            label_mark.setText("E");
        }
        update_input("");
        clearFlag = true;
    }
}
