package Entities.Packages;

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
}
