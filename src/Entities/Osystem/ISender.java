package Entities.Osystem;

import java.util.ArrayList;
import Entities.Equipment.Equipment;
import Entities.Packages.Packet;

public interface ISender {

	public void senPacket(Packet packet, ArrayList<Equipment> equipments);
	
	
}
