/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saurabh
 */
public class NodeDisplayPageController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="variable declarations">
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private Label L3;
    @FXML
    private Label L4;
    @FXML
    private Label L5;
    @FXML
    private Label L6;
    @FXML
    private Label L7;
    @FXML
    private Label L8;
    @FXML
    private Label L9;
    @FXML
    private Label L10;
    @FXML
    private Label L11;
    @FXML
    private Label L12;
    @FXML
    private Label L13;
    @FXML
    private Label L14;
    @FXML
    private Label L15;
    @FXML
    private Label L16;
    @FXML
    private Label L17;
    @FXML
    private Label L18;
    @FXML
    private Label L19;
    @FXML
    private Label L20;
    @FXML
    private TextArea TA1;
    @FXML
    private TextArea TA2;
    @FXML
    private TextArea TA3;
    @FXML
    private TextArea TA4;
    @FXML
    private TextArea TA5;
    @FXML
    private TextArea TA6;
    @FXML
    private TextArea TA7;
    @FXML
    private TextArea TA8;
    @FXML
    private TextArea TA9;
    @FXML
    private TextArea TA10;
    @FXML
    private TextArea TA11;
    @FXML
    private TextArea TA12;
    @FXML
    private TextArea TA13;
    @FXML
    private TextArea TA14;
    @FXML
    private TextArea TA15;
    @FXML
    private TextArea TA16;
    @FXML
    private TextArea TA17;
    @FXML
    private TextArea TA18;
    @FXML
    private TextArea TA19;
    @FXML
    private TextArea TA20;
    @FXML
    private Label IPLabel[];
    @FXML
    private TextArea IPTA[];
    @FXML
    private Button exitButton;
//</editor-fold>
    ArrayList<Node> nodes;            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nodes=HomePageController.fxnode.getAllNodes();
        int nodesno=HomePageController.nodesno;
        IPLabel=new Label[]{L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18,L19,L20};
        IPTA=new TextArea[]{TA1,TA2,TA3,TA4,TA5,TA6,TA7,TA8,TA9,TA10,TA11,TA12,TA13,TA14,TA15,TA16,TA17,TA18,TA19,TA20};
        for(int i=0;i<nodesno;i++){
            IPLabel[i].setDisable(false);
            IPTA[i].setDisable(false);
            IPLabel[i].setText("Node IP : "+nodes.get(i).getIP().toString());
            for(int j=0;j<nodes.get(i).connectedNodes.size();j++){
                IPTA[i].appendText(nodes.get(i).connectedNodes.get(j).n.getIP().toString()+"@"+nodes.get(i).connectedNodes.get(j).avgdelay+"us\n");
            }
        }
    } 
    
    public void exitButtonActionPerformed(ActionEvent evt){
        Stage curStage=(Stage)exitButton.getScene().getWindow();
        curStage.close();
    }
    
}
