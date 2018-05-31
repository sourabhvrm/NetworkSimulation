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
public class IPAddress {
    private byte ip[];
    
    public IPAddress (int o1,int o2,int o3,int o4){
        if((o1>=0&&o1<256)&&(o2>=0&&o2<256)&&(o3>=0&&o3<256)&&(o4>=0&&o4<256))
        ip=new byte[]{(byte)o1,(byte)o2,(byte)o3,(byte)o4};
        else{
            System.err.println("Invalid IP Address");
            System.exit(10);
        }
    }
    public boolean isEqual(IPAddress ip2){
       for(int i=0;i<4;i++)if(ip[i]!=ip2.ip[i])return false;
       return true;
    }
    
    @Override
    public String toString(){
        return ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3];
    }
    public int getLastoct(){
        return ip[3];
    }
}