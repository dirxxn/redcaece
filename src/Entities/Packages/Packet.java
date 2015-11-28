package Entities.Packages;

import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public abstract class Packet{
	private IPAddressV4 destination;
	private IPAddressV4 source;
	private PacketType serviceType;
	private int ttl;
	private String text;

	public IPAddressV4 getDestination() {
		return destination;
	}

	public void setDestination(IPAddressV4 destination) {
		this.destination = destination;
	}

	public IPAddressV4 getSource() {
		return source;
	}

	public void setSource(IPAddressV4 source) {
		this.source = source;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PacketType getServiceType() {
		return serviceType;
	}

	public void setServiceType(PacketType serviceType) {
		this.serviceType = serviceType;
	}

	public String toString(){
		String message = String.format("Ip destino: %s, Ip origen: %s, tipo de servicio: %s, ttl: %d, mensaje: %s",destination.toString(),
				source.toString(),serviceType.toString(),ttl,text);
		return message;
	}
}
