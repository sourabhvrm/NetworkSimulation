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
class Packet {
    IPAddress sourceIP;
    IPAddress destIP;
    private String data;
    
    public Packet(IPAddress sip,IPAddress dip,String data){
        sourceIP=sip;
        destIP=dip;
        this.data=data;
    }
    
    public Packet(String data){
        this.data=data;
    }
    
    public void setsourceIP(IPAddress ip){
        sourceIP=ip;
    }
    public void setdestIP(IPAddress ip){
        destIP=ip;
    }
    public IPAddress sourceIP(){
        return this.sourceIP;
    }
    public IPAddress destIP(){
        return this.destIP;
    }
    public String getdata(){
        return this.data;
    }
}
