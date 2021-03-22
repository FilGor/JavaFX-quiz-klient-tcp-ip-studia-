package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {
    Socket s;
    @FXML
    private TextField answerField;

    @FXML
    private TextField nickField;

    @FXML
    private Button sendAnswerButton;
    public void initialize(){

    }
    @FXML
    void sendAnswerMethod(ActionEvent event) throws IOException {


        if(answerField.getText().trim().isEmpty() || nickField.getText().trim().isEmpty()){
            Alert fail= new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("failure");
            fail.setContentText("Uzupelnij wszystkie pola");
            fail.show();}
        else{
            s = new Socket("localhost",8888);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.println(answerField.getText());
            pw.flush();
            pw.println(nickField.getText());
            pw.flush();
            pw.close();
            s.close();
        }}

}
