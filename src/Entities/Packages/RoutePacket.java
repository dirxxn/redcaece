package Entities.Packages;

import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public class RoutePacket extends Packet {
	private Packet packet;

	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public RoutePacket(PacketType serviceType){
		this.setServiceType(serviceType);
	}

	public RoutePacket(IPAddressV4 source, IPAddressV4 destination, PacketType serviceType, int ttl, String text, Packet packet){
		this.setSource(source);
		this.setDestination(destination);
		this.setText(text);
		this.setTtl(ttl);
		this.setServiceType(serviceType);
		this.setPacket(packet);
	}
}
