package userInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class BoardController {

    @FXML
    private Tab tabOne;

    @FXML
    private Spinner<?> rowMatrixOne;

    @FXML
    private Spinner<?> columnMatrixOne;

    @FXML
    private Spinner<?> rowMatrixTwo;

    @FXML
    private Spinner<?> columnMatrixTwo;

    @FXML
    private Button tabOneMultiplyButton;

    @FXML
    private AnchorPane anchorPaneOne;

    @FXML
    private Label tabOneLabel;

    @FXML
    private Tab tabTwo;

    @FXML
    private AnchorPane anchorPaneTwo;

    @FXML
    private Spinner<?> numberRandomMatricesSpinner;

    @FXML
    private Button tabTwoGenerateButton;

    @FXML
    private Button tabTwoMultiplyButton;

    @FXML
    private Label tabTwoLabel;

}
