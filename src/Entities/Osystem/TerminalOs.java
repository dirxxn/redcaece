package Entities.Osystem;

import java.util.ArrayList;

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
	
	public void senPacket(Packet packet, ArrayList<Equipment> equipments){
		// TODO
	}
	
}
