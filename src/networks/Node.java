/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author saurabh
 */
public class Node {

    private final IPAddress ip;
    ArrayList<LinkNode> connectedNodes;
    Queue<String> inputBuffer;
    Queue<String> outputBuffer;
    int nodetype;
    boolean kill;

    public Node(IPAddress ip, IPtoNode n) {
        this.ip = ip;
        inputBuffer = new LinkedList<>();
        outputBuffer = new LinkedList<>();
        connectedNodes = new ArrayList<>();
        n.ip.add(ip);
        n.node.add(this);
        nodetype = 3;
        kill=false;
    }

    public boolean connectNode(Node n1, int speed) {
        boolean ipconflict = false;
        for (int i = 0; i < connectedNodes.size(); i++) {
            if (connectedNodes.get(i).n.getIP().isEqual(n1.getIP())) {
                ipconflict = true;
            }
        }
        if (!ipconflict) {
            connectedNodes.add(new LinkNode(n1, speed));
            return true;
        }
        return false;
    }

    public void showConnectedNodes() {
        for (int i = 0; i < connectedNodes.size(); i++) {
            System.out.println(connectedNodes.get(i).n.iptoString() + " " + connectedNodes.get(i).avgdelay);
        }
    }
    
    public void kill(boolean kill){
        this.kill=kill;
    }
    public boolean isKill(){
        return kill;
    }

    public void sendPkt(Packet pkt, Node dest) {
        pkt.setsourceIP(ip);
        if (dest != null) {
//            dest.receivePkt(pkt);
        } else {
            System.err.println("Invalid Destination");
            System.exit(8);
        }
    }

    public String iptoString() {
        return ip.toString();
    }

    public IPAddress getIP() {
        return ip;
    }

    public void setNodetype(int n) {
        nodetype = n;
    }

    public int getNodetype() {
        return nodetype;
    }

    public String receivePkt(Packet pkt, Queue<Node> nodequeue) {
        Queue<Node> nextNode=nodequeue;
        inputBuffer.add(pkt.getdata());
        if (!pkt.destIP.isEqual(ip)) {
            inputBuffer.poll();
            return "Data Received@IP:"+ip.toString()+"\n"+nextNode.poll().receivePkt(pkt, nextNode);
        } else {
            return "Data Received@IP:"+ip.toString();
        }
    }
}
