package Entities.Packages;

/**
 * Created by efridman on 14/11/15.
 */
public class Who extends PacketType {

    public Who(){
        this.setIsRequest(true);
    }

    public PacketType getResponse(){
        return new Sendmsg();
    }

}
