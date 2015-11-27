package Entities.Osystem;


import Entities.Equipment.Equipment;
import Entities.Packages.Packet;

public abstract class TerminalOs extends OperatingSystem {

	protected int ttl;

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
	
	/*public void sendPacket(Packet packet, ArrayList<Equipment> equipments){
		for (Equipment equipment : equipments) {

		}
	}*/
	
	@Override
	public String getDataVersion(){
		String data = super.getDataVersion();
		data = "TTL: " + ttl + "\n";
		return data;
	}
	
}
