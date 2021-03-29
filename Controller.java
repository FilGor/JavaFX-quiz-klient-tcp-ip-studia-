package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {
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

        //sprawdzamy czy któreś z pól nie jest puste:
        if(answerField.getText().trim().isEmpty() || nickField.getText().trim().isEmpty()){
            Alert fail= new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("failure");
            fail.setContentText("Uzupelnij wszystkie pola");
            fail.show();}
        else{ //jesli nie to laczymy sie z serwerem
            try(Socket s = new Socket("localhost",8888);
            PrintWriter pw = new PrintWriter(s.getOutputStream());) {
                pw.println(answerField.getText());//wysylamy osobno odpowiedz i nick
                pw.flush();                     // poniewaz tez osobno bedziemy je odbierac
                pw.println(nickField.getText());
                pw.flush();

            }catch(IOException e ){
                e.printStackTrace();
            }
        }}

}
