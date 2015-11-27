package Entities.Equipment;

import Entities.Packages.Packet;
import Entities.Packages.PacketType;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment{

	private int connectionsNumber;	
	
	@Override
	public void sendPacket(Packet<PacketType> packet) {
		for (Equipment equipment : equipments) {
			equipment.receivePacket(packet);
		}	
		
	}

	@Override
	public void receivePacket(Packet<PacketType> packet) {
		this.sendPacket(packet);
	}	
}
