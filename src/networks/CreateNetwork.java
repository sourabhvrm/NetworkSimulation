/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author saurabh
 */
public class CreateNetwork {

    private ArrayList<Node> node;
    public IPtoNode ipton;
    int nodesno;

    public CreateNetwork(int nodesno) {
        node = new ArrayList<>();
        ipton = new IPtoNode();
        this.nodesno = nodesno;
    }

    public void createNode() {
        Random rand = new Random();
        for (int i = 0; i < nodesno; i++) {
            node.add(new Node(new IPAddress(127, 0, 0, i), ipton));
        }
        for (int i = 0; i < nodesno; i++) {
            int ls, n2;
            while (node.get(i).connectedNodes.size() < (nodesno / 2)) {
                ls = rand.nextInt(1000);
                n2 = rand.nextInt(nodesno - 1);
                if (n2 != i) {
                    connectNodes(node.get(i), node.get(n2), ls * 100);
                }
            }
        }
    }

    public ArrayList<Node> getAllNodes() {
        return node;
    }

    private void connectNodes(Node n1, Node n2, int speed) {
        n1.connectNode(n2, speed);
        n2.connectNode(n1, speed);
    }
}
