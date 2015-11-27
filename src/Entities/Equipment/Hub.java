package Entities.Equipment;

import Entities.Packages.Packet;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment {

	private int connectionsNumber;	

		public Hub(int connectionsNumber) {
		super();
		this.connectionsNumber = connectionsNumber;
	}
	
	public int getconnectionsNumber() {
		return connectionsNumber;
	}

	public void setconnectionsNumber(int connectionsNumber) {
		this.connectionsNumber = connectionsNumber;
	}

	@Override
	public void sendPacket(Packet packet) {
	}

	@Override
	public void receivePacket(Packet packet) {
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
}
