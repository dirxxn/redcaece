package Entities.Equipment;

import Entities.Packages.Packet;
import Entities.Packages.PacketType;
import Exceptions.AssociateEquipmentError;

public abstract class NetEquipment extends Equipment{

	protected int connectionsNumber;

	public int getConnectionsNumber() {
		return connectionsNumber;
	}

	public void setConnectionsNumber(int connectionsNumber) {
		this.connectionsNumber = connectionsNumber;
	}
	
	public abstract void sendPacket(Packet<PacketType> packet);

	public abstract void receivePacket(Packet<PacketType> packet);
	
	@Override
	public void associateEquipment(Equipment equipment) throws AssociateEquipmentError{
		
		if(this.isConnNumberExceeded())
		{
			throw new AssociateEquipmentError();
		}else{
			
			if(equipment instanceof NetEquipment){
						if(!((NetEquipment)equipment).isConnNumberExceeded()){
									this.equipments.add(equipment);
									equipment.equipments.add(this);
						}else{
							throw new AssociateEquipmentError();
						}
			}else{
				this.equipments.add(equipment);
				equipment.equipments.add(this);				
			}
		}
		
	}
	
	private boolean isConnNumberExceeded(){
		return this.equipments.size() > this.connectionsNumber;
	}
	
}
