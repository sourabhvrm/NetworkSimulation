/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

/**
 *
 * @author saurabh
 */
public class LinkNode {
    public Node n;
    public int avgdelay;
    public LinkNode(Node newNode,int avgdelay){
        n=newNode;
        this.avgdelay=avgdelay;
    }
}
