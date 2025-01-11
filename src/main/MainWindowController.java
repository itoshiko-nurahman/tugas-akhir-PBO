package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML private Label lblResult;

    private double num1 = 0;
    private String operator = ".";
    private boolean isNewNumber = true;

    private final Pembagian pembagian = new Pembagian();
    private final Pengurangan pengurangan = new Pengurangan();
    private final Perkalian perkalian = new Perkalian();
    private final Pertambahan pertambahan = new Pertambahan();
    private final AkarKuadrat akarKuadrat = new AkarKuadrat();
    private final Kuadrat kuadrat = new Kuadrat();

    @FXML
    void onNumberClicked(MouseEvent event) {
        String value = ((Pane)event.getSource()).getId().replace("btn","");

        if (isNewNumber) {
            if (value.equals("Dot")) {
                lblResult.setText("0.");
            } else {
                lblResult.setText(value);
            }
            isNewNumber = false;
        } else {
            if (value.equals("Dot")) {
                if (!lblResult.getText().contains(".")) {
                    lblResult.setText(lblResult.getText() + ".");
                }
            } else {
                lblResult.setText(lblResult.getText() + value);
            }
        }
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        double currentNumber;

        // Handle error ketika hasilnya memiliki bukan bilangan bulat
        try {
            currentNumber = Double.parseDouble(lblResult.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            lblResult.setText("Error");
            return;
        }

        switch (symbol) {
            case "Del" -> {
                lblResult.setText("0");
                num1 = 0;
                operator = ".";
                isNewNumber = true;
                updateDisplay();
            }
            case "Sqrt" -> {
                double result = akarKuadrat.hitung(currentNumber, 0);
                lblResult.setText(formatResult(result));
                isNewNumber = true;
                updateDisplay();
            }
            case "Power" -> {
                double result = kuadrat.hitung(currentNumber, 0);
                lblResult.setText(formatResult(result));
                isNewNumber = true;
                updateDisplay();
            }
            case "Equals" -> {
                double result = switch (operator) {
                    case "+" -> pertambahan.hitung(num1, currentNumber);
                    case "-" -> pengurangan.hitung(num1, currentNumber);
                    case "*" -> perkalian.hitung(num1, currentNumber);
                    case "/" -> pembagian.hitung(num1, currentNumber);
                    default -> currentNumber;
                };
                lblResult.setText(formatResult(result));
                operator = ".";
                isNewNumber = true;
                updateDisplay();
            }
            default -> {
                num1 = currentNumber;
                operator = switch (symbol) {
                    case "Plus" -> "+";
                    case "Minus" -> "-";
                    case "Multiply" -> "*";
                    case "Divide" -> "/";
                    default -> ".";
                };
                isNewNumber = true;
                updateDisplay();
            }
        }
    }

    private void updateDisplay() {
        // Temukan semua label operator dan reset warnanya
        Pane root = (Pane) lblResult.getParent();
        root.lookupAll(".label").forEach(node -> {
            Label label = (Label) node;
            if (label.getText().equals("+") ||
                    label.getText().equals("-") ||
                    label.getText().equals("*") ||
                    label.getText().equals("/")) {
                label.setStyle("-fx-text-fill: #7FDBCA; -fx-font-size: 24px; -fx-font-weight: bold;");
            }
        });

        // Highlight operator yang aktif
        if (!operator.equals(".")) {
            root.lookupAll(".label").forEach(node -> {
                Label label = (Label) node;
                if (label.getText().equals(operator)) {
                    label.setStyle("-fx-text-fill: #E06C75; -fx-font-size: 24px; -fx-font-weight: bold;");
                }
            });
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        }
        return String.format("%.8f", result).replaceAll("0*$", "").replaceAll("\\.$", "");
    }

    public void initialize(Stage primaryStage) {
    }
}