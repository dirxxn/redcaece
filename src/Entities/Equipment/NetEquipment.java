package Entities.Equipment;

import Entities.Network.IPAddressV4;
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
	
	public abstract void sendPacket(Packet packet);
	public abstract void sendPacket(IPAddressV4 destination,PacketType packetType);

	public abstract void receivePacket(Packet packet);
	
	@Override
	public void associateEquipment(Equipment equipment) throws AssociateEquipmentError{
		
		if(this.isConnNumberExceeded())
		{
			throw new AssociateEquipmentError();
		}else{
			
			if(equipment instanceof NetEquipment){
						if(!((NetEquipment)equipment).isConnNumberExceeded()){
									this.addEquipment(equipment);
									equipment.addEquipment(this);
						}else{
							throw new AssociateEquipmentError();
						}
			}else{
				this.addEquipment(equipment);
				equipment.addEquipment(this);				
			}
		}
		
	}
	
	protected boolean isConnNumberExceeded(){
		return this.equipments.size() > this.connectionsNumber;
	}
	
}
