package Entities.Osystem;

import java.util.List;

import Entities.Equipment.Equipment;
import Entities.Packages.Packet;

public abstract class OperatingSystem implements ISender{

	protected String name;
	protected String version;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void senPacket(Packet packet, List<Equipment> equipments){
		// TODO 
	}
	
}
