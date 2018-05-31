/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.util.ArrayList;

/**
 *
 * @author saurabh
 */
public class IPtoNode {
    ArrayList<IPAddress> ip;
    ArrayList<Node> node;
    
    public IPtoNode(){
        ip=new ArrayList<>();
        node=new ArrayList<>();
    }
    
    public Node iptonode(IPAddress ip){
        for(int i=0;i<this.ip.size();i++){
            if(this.ip.get(i).isEqual(ip)){
                return node.get(i);
            }
        }
        return null;
    }
}
