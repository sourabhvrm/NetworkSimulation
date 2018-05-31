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
public class BackupNet {
    private ArrayList<Node> backupNode;
    public BackupNet(ArrayList<Node> x){
        backupNode=new ArrayList<>();
        backupNode=x;
    }
    
    public ArrayList<Node> getNodes(){
        return backupNode;
    }
}
