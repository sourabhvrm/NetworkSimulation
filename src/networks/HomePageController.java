/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author saurabh
 */
public class HomePageController implements Initializable {

//<editor-fold defaultstate="collapsed" desc="Declared Variables">
    @FXML
    private Button RT1;
    @FXML
    private Button RT2;
    @FXML
    private Button RT3;
    @FXML
    private Button RT4;
    @FXML
    private Button RT5;
    @FXML
    private Button RT6;
    @FXML
    private Button RT7;
    @FXML
    private Button RT8;
    @FXML
    private Button RT9;
    @FXML
    private Button RT10;
    @FXML
    private Button RT11;
    @FXML
    private Button RT12;
    @FXML
    private Button RT13;
    @FXML
    private Button RT14;
    @FXML
    private Button RT15;
    @FXML
    private Button RT16;
    @FXML
    private Button RT17;
    @FXML
    private Button RT18;
    @FXML
    private Button RT19;
    @FXML
    private Button RT20;
    @FXML
    private Button[] RTButton;
    @FXML
    private RadioButton SourceRB;
    @FXML
    private RadioButton DestRB;
    @FXML
    private RadioButton RouterRB;
    @FXML
    private Button currentButton;
    @FXML
    private Button ReadyButton;
    @FXML
    private Button SendButton;
    @FXML
    private TextField nodesnoTF;
    @FXML
    private TextField dataTF;
    @FXML
    private Label actasLabel;
    @FXML
    private Label NodedisplayLabel;
    @FXML
    private Label EnterTextLabel;
    @FXML
    private Label inputListLabel;
    @FXML
    private Label outputListLabel;
    @FXML
    private TextArea inputList;
    @FXML
    private TextArea outputList;
    @FXML
    private TextArea statusTA;
    @FXML
    private CheckBox killCheckBox;
    @FXML
    private Button showConnNodesBT;
    static NodetoFX fxnode;
    private Node sourceNode, destNode;
    public BackupNet backup;
    static int nodesno;
//</editor-fold>

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxnode = new NodetoFX();
        RTButton = new Button[]{RT1, RT2, RT3, RT4, RT5, RT6, RT7, RT8, RT9, RT10, RT11, RT12, RT13, RT14, RT15, RT16, RT17, RT18, RT19, RT20};
        Platform.runLater(() -> {
            nodesnoTF.requestFocus();
        });
        //backupNode=new ArrayList<>();
    }

    public void setCurrentButton(ActionEvent evt) {
        currentButton = (Button) evt.getSource();
        NodedisplayLabel.setText("    " + fxnode.getNode(currentButton).getIP().toString());
        int nodetype = fxnode.getNode(currentButton).getNodetype();
        switch (nodetype) {
            case 1:
                SourceRB.setSelected(true);
                break;
            case 2:
                DestRB.setSelected(true);
                break;
            default:
                RouterRB.setSelected(true);
                break;
        }
        outputList.setText("");
        inputList.setText("");
        killCheckBox.setDisable(false);
        killCheckBox.setSelected(fxnode.getNode(currentButton).isKill());
        for (int i = 0; i < fxnode.getNode(currentButton).outputBuffer.size(); i++) {
            outputList.appendText(fxnode.getNode(currentButton).outputBuffer.peek() + "\n");
        }
        for (int i = 0; i < fxnode.getNode(currentButton).inputBuffer.size(); i++) {
            inputList.appendText(fxnode.getNode(currentButton).inputBuffer.peek() + "\n");
        }
    }

    public void setSourceRadioButton(ActionEvent evt) {
        if (currentButton != null) {
            if (sourceNode != null) {
                Button x = fxnode.getButton(sourceNode);
                Node curNode = fxnode.getNode(sourceNode);
                x.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Router.png"))));
                curNode.setNodetype(3);
            }
            currentButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Client.png"))));
            sourceNode = fxnode.getNode(currentButton);
            sourceNode.setNodetype(1);
        }
    }

    public void setDestRadioButton(ActionEvent evt) {
        if (currentButton != null) {
            if (destNode != null) {
                Button x = fxnode.getButton(destNode);
                Node curNode = fxnode.getNode(destNode);
                x.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Router.png"))));
                curNode.setNodetype(3);
            }
            currentButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Server.png"))));
            destNode = fxnode.getNode(currentButton);
            destNode.setNodetype(2);
        }

    }

    public void setRouterRadioButton(ActionEvent evt) {
        if (currentButton != null) {
            currentButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Router.png"))));
            fxnode.getNode(currentButton).setNodetype(3);
        }
    }

    public void nodesnoTFActionPerformed(ActionEvent evt) {
        nodesno = Integer.parseInt(nodesnoTF.getText());
        if (nodesno > 20) {
            statusTA.appendText("Max 20 Nodes Allowed" + "\n");
        } else {
            nodesnoTF.setDisable(true);
            createNetwork();
        }
    }

    public void createNetwork() {
        CreateNetwork network = new CreateNetwork(nodesno);
        network.createNode();
        Platform.runLater(() -> {
            Image Routerimg = new Image(getClass().getResourceAsStream("Router.png"));
            for (int i = 0; i < nodesno; i++) {
                RTButton[i].setGraphic(new ImageView(Routerimg));
            }
        });
        actasLabel.setDisable(false);
        SourceRB.setDisable(false);
        DestRB.setDisable(false);
        RouterRB.setDisable(false);
        EnterTextLabel.setDisable(false);
        inputListLabel.setDisable(false);
        outputListLabel.setDisable(false);
        inputList.setDisable(false);
        outputList.setDisable(false);
        ReadyButton.setDisable(false);
        SendButton.setDisable(false);
        dataTF.setDisable(false);
        for (int i = 0; i < nodesno; i++) {
            fxnode.add(RTButton[i], network.getAllNodes().get(i));
        }
    }

    public void ReadyButtonActionPerformed(ActionEvent evt) {
        String data = dataTF.getText();
        if (sourceNode != null) {
            dataTF.setText("");
            sourceNode.outputBuffer.clear();
            sourceNode.outputBuffer.add(data);
            outputList.appendText(data + "\n");
        } else {
            statusTA.appendText("Select a Source Node" + "\n");
        }
    }

    public void SendButtonActionPerformed(ActionEvent evt) {
        Dijkstra dk = new Dijkstra(nodesno);
        dk.makeadjacencyMatrix(fxnode.getAllNodes());
        Stack<Integer> path = dk.findShortestPath(sourceNode.getIP().getLastoct(), destNode.getIP().getLastoct());
        Queue<Node> nodequeue = new LinkedList<>();
        while (!path.isEmpty()) {
//            System.out.print(path.peek() + "\t");
            nodequeue.add(fxnode.getNode(path.pop()));
        }
//        System.out.println("Cost : " + dk.getCost(destNode.getIP().getLastoct()));
        statusTA.appendText("Source IP : " + sourceNode.getIP().toString() + "\n");
        statusTA.appendText("Dest IP : " + destNode.getIP().toString() + "\n");
        while (!sourceNode.outputBuffer.isEmpty()) {
            statusTA.appendText(sourceNode.receivePkt(new Packet(sourceNode.getIP(), destNode.getIP(), sourceNode.outputBuffer.poll()), nodequeue) + "\n");
        }
        outputList.setText("");
    }

    public void killCheckBoxActionPerformed(ActionEvent evt) {
        if (killCheckBox.isSelected()) {
            if (fxnode.getNode(currentButton).getNodetype() != 3) {
                statusTA.appendText("Only Routers can be Killed\n");
                killCheckBox.setSelected(false);
            } else {
                statusTA.appendText("Node Killed\n");
                currentButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Router_fade.png"))));
                backup = new BackupNet(fxnode.getAllNodes());
                fxnode.getNode(currentButton).kill(true);
                for (int i = 0; i < fxnode.getNode(currentButton).connectedNodes.size(); i++) {
                    fxnode.getNode(currentButton).connectedNodes.get(i).avgdelay = Integer.MAX_VALUE;
                }
                //fxnode.showAllConnectedNodes();
            }
        } else {
            currentButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("Router.png"))));
            fxnode.setAllNodes(backup.getNodes());
        }
    }

    public void showConnNodesButtonActionPerformed(ActionEvent evt) {
        try {
            Parent newWin = FXMLLoader.load(getClass().getResource("NodeDisplayPage.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newWin));
            newStage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
