package Entities.Packages;

import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public class ServicePacket extends Packet {

    public ServicePacket(PacketType serviceType){
        this.setServiceType(serviceType);
    }

    public ServicePacket(IPAddressV4 source, IPAddressV4 destination, PacketType serviceType, int ttl, String text){
        this.setSource(source);
        this.setDestination(destination);
        this.setText(text);
        this.setTtl(ttl);
        this.setServiceType(serviceType);
    }

}
