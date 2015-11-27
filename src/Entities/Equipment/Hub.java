package Entities.Equipment;

import Entities.Packages.Packet;
import Entities.Packages.PacketType;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment {

	private int connectionsNumber;	

		public Hub(int connectionsNumber) {
		super();
		this.connectionsNumber = connectionsNumber;
	}
	
	@Override
	public boolean associateEquipment(Equipment equipment) {
		boolean associated = false;
		if(this.equipments.size() < connectionsNumber)
		{
			if(equipment.associateEquipment(this)){
				this.equipments.add(equipment);				
				associated = true;
			}
		
		}
		return associated;
	}
	
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

	public int getConnectionsNumber() {
		return connectionsNumber;
	}

	public void setConnectionsNumber(int connectionsNumber) {
		this.connectionsNumber = connectionsNumber;
	}	
	
	private boolean isConnNumberExceeded(){
		return this.equipments.size() > this.connectionsNumber;

	}
}
