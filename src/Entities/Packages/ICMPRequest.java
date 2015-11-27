package Entities.Packages;

/**
 * Created by efridman on 14/11/15.
 */
public class ICMPRequest extends PacketType {

    public ICMPRequest(){
        this.setIsRequest(true);
    }

    public PacketType getResponse(){
        return new ICMPResponse();
    }

}
