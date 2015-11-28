package Entities.Equipment;

import Entities.Network.IPAddressV4;
import Entities.Packages.Packet;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends NetEquipment {

	public Hub(int connectionsNumber) {
		super();
		this.connectionsNumber = connectionsNumber;
	}
	
	public Hub(int connectionsNumber, IPAddressV4 associated) {
		super();
		this.connectionsNumber = connectionsNumber;
		this.associatedIp = associated;
	}
	
	@Override
	public void sendPacket(Packet packet) {
		for (Equipment equipment : equipments) {
			equipment.receivePacket(packet);
		}			
	}


	@Override
	public void receivePacket(Packet packet) {
		this.sendPacket(packet);
	}	
	
}
