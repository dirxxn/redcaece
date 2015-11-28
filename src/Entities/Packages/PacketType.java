package Entities.Packages;

/**
 * Created by efridman on 27/11/15.
 */
public abstract class PacketType {

    private boolean isRequest;

    public boolean isRequest() {
        return isRequest;
    }

    public void setIsRequest(boolean isRequest) {
        this.isRequest = isRequest;
    }

    public abstract PacketType getResponse();

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
