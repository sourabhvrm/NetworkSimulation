/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author saurabh
 */
public class NodetoFX {

    @FXML
    private ArrayList<Button> button;
    private ArrayList<Node> node;

    public NodetoFX() {
        button = new ArrayList<>();
        node = new ArrayList<>();
    }

    public void add(Button button, Node node) {
        this.button.add(button);
        this.node.add(node);
    }

    public ArrayList<Node> getAllNodes() {
        return node;
    }

    public Node getNode(Button button) {
        for (int i = 0; i < this.button.size(); i++) {
            if (this.button.get(i) == button) {
                return node.get(i);
            }
        }
        return null;
    }

    public Node getNode(IPAddress ip) {
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).getIP().isEqual(ip)) {
                return node.get(i);
            }
        }
        return null;
    }

    public Node getNode(int ip) {
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).getIP().getLastoct() == ip) {
                return node.get(i);
            }
        }
        return null;
    }

    public Button getButton(Node n) {
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).getIP().isEqual(n.getIP())) {
                return button.get(i);
            }
        }
        return null;
    }

    public Node getNode(Node x) {
        for (int i = 0; i < node.size(); i++) {
            if (node.get(i).getIP().isEqual(x.getIP())) {
                return node.get(i);
            }
        }
        return null;
    }

    public void showAllConnectedNodes() {
        for (int i = 0; i < node.size(); i++) {
            System.out.println("Node : " + i);
            node.get(i).showConnectedNodes();
        }
    }

    public void setAllNodes(ArrayList<Node> backup) {
        ArrayList<Node> newNodes = new ArrayList<>();
        for (int i = 0; i < backup.size(); i++) {
            newNodes.add(backup.get(i));
        }
        node = newNodes;
        showAllConnectedNodes();
    }

}
