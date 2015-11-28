package Entities.Packages;

/**
 * Created by efridman on 14/11/15.
 */
public class Sendmsg extends PacketType {

    public Sendmsg(){
        this.setIsRequest(false);
    }

	@Override
	public PacketType getResponse() {
		return null;
	}
}
