package automation.fx;

import automation.FileUtils;
import automation.data.AutomationElement;
import automation.data.thingsWhatCanGetLocked.Window;
import automation.data.thingsWhatCanRaiseOrLower.Blind;
import automation.data.thingsWhatCanRaiseOrLower.GarageDoor;
import automation.data.thingsWhatHaveSwitches.Heating;
import automation.data.thingsWhatHaveSwitches.Light;
import automation.data.thingsWhatHaveSwitches.Oven;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button buttonGarageDoor;

    private boolean buttonGarageDoorState;

    @FXML
    private ComboBox<Integer> comboBoxGarageDoor;

    @FXML
    private Button buttonLivingRoomWindow;

    private boolean buttonLivingRoomWindowState;

    @FXML
    private ComboBox<Integer> comboBoxLivingRoomWindow;

    @FXML
    private Button buttonBathRoomHeating;

    private boolean buttonBathRoomHeatingState;

    @FXML
    private TextField textFieldBathroomHeating;

    @FXML
    private Button buttonKitchenOven;

    private boolean buttonKitchenOvenState;

    @FXML
    private TextField textFieldKitchenOven;

    @FXML
    private Button buttonBathRoomLight;

    private boolean buttonBathRoomLightState;

    @FXML
    private Button buttonLivingRoomLight;

    private boolean buttonLivingRoomLightState;

    private AutomationElement[] automationElements;

    private final Integer[] comboBoxValues = new Integer[] { 0, 25, 50, 75, 100 };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        automationElements = new AutomationElement[]{
                new GarageDoor("Garage Door", false, 0),
                new Window("Living Room Window", new Blind("Living Room Window Blind", 0)),
                new Heating("Bathroom Heating", 0, false),
                new Oven("Kitchen Oven", 0, false),
                new Light("Bathroom Light"),
                new Light("Living Room Light")
        };
        FileUtils.setAutomationElements(automationElements);
        setAllButtons();
        setAllOnActionButton();
        setAllComboBox();
        setAllOnActionComboBox();
        setAllTextFields();
        setAllOnActionTextFields();
    }

    private void setAllButtons() {
        buttonGarageDoorState = switchButton(buttonGarageDoor, ((GarageDoor)automationElements[0]).isLocked());
        buttonLivingRoomWindowState = switchButton(buttonLivingRoomWindow, ((Window)automationElements[1]).getStatus());
        buttonBathRoomHeatingState = switchButton(buttonBathRoomHeating, ((Heating)automationElements[2]).isRunning());
        buttonKitchenOvenState = switchButton(buttonKitchenOven, ((Oven)automationElements[3]).isRunning());
        buttonBathRoomLightState = switchButton(buttonBathRoomLight, ((Light)automationElements[4]).isRunning());
        buttonLivingRoomLightState = switchButton(buttonLivingRoomLight, ((Light)automationElements[5]).isRunning());
    }

    private void setAllOnActionButton() {
        buttonGarageDoor.setOnAction(event -> {
            buttonGarageDoorState = switchButton(buttonGarageDoor, buttonGarageDoorState);
            ((GarageDoor)automationElements[0]).setLocked(!buttonGarageDoorState);
        });

        buttonLivingRoomWindow.setOnAction(event -> {
            buttonLivingRoomWindowState = switchButton(buttonLivingRoomWindow, buttonLivingRoomWindowState);
            ((Window)automationElements[1]).setLocked(!buttonLivingRoomWindowState);
        });

        buttonBathRoomHeating.setOnAction(event -> {
            buttonBathRoomHeatingState = switchButton(buttonBathRoomHeating, buttonBathRoomHeatingState);
            ((Heating)automationElements[2]).setRunning(!buttonBathRoomHeatingState);
        });

        buttonKitchenOven.setOnAction(event -> {
            buttonKitchenOvenState = switchButton(buttonKitchenOven, buttonKitchenOvenState);
            ((Oven)automationElements[3]).setRunning(!buttonKitchenOvenState);
        });

        buttonBathRoomLight.setOnAction(event -> {
            buttonBathRoomLightState = switchButton(buttonBathRoomLight, buttonBathRoomLightState);
            ((Light)automationElements[4]).setRunning(!buttonBathRoomLightState);
        });

        buttonLivingRoomLight.setOnAction(event -> {
            buttonLivingRoomLightState = switchButton(buttonLivingRoomLight, buttonLivingRoomLightState);
            ((Light)automationElements[5]).setRunning(!buttonLivingRoomLightState);
        });
    }

    private void switchButton(Button button, String text, String color) {
        button.setText(text);
        button.setStyle("-fx-background-color: " + color);
    }

    private boolean switchButton(Button button, boolean isOn) {
        if ( isOn ) {
            switchButton(button, "ON", "green");
        } else {
            switchButton(button, "OFF", "red");
        }
        return !isOn;
    }

    private void setComboBoxValues(ComboBox<Integer> comboBox) {
        comboBox.getItems().addAll(comboBoxValues);
    }

    private void setAllComboBox() {
        setComboBoxValues(comboBoxGarageDoor);
        setComboBoxValues(comboBoxLivingRoomWindow);
        comboBoxGarageDoor.setValue(((GarageDoor)automationElements[0]).getPercent());
        comboBoxLivingRoomWindow.setValue(((Window)automationElements[1]).getBlind().getPercent());
    }

    private void setAllOnActionComboBox() {
        comboBoxGarageDoor.setOnAction(event ->
                ((GarageDoor)automationElements[0]).setPercent(comboBoxGarageDoor.getValue()));
        comboBoxLivingRoomWindow.setOnAction(event ->
                ((Window)automationElements[1]).getBlind().setPercent(comboBoxLivingRoomWindow.getValue()));
    }

    private void setAllTextFields() {
        textFieldBathroomHeating.setText("" + ((Heating)automationElements[2]).getTemperature());
        textFieldKitchenOven.setText("" + ((Oven)automationElements[3]).getTemperature());
    }

    private void setAllOnActionTextFields() {
        textFieldBathroomHeating.setOnAction(event ->
                ((Heating)automationElements[2]).setTemperature(Integer.parseInt(textFieldBathroomHeating.getText())));
        textFieldKitchenOven.setOnAction(event ->
                ((Oven)automationElements[3]).setTemperature(Integer.parseInt(textFieldKitchenOven.getText())));
    }

    @FXML
    public void saveState() {
        FileUtils.saveStatus(automationElements);
    }

}
