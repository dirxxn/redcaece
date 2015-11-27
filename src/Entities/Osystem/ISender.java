package Entities.Osystem;

import Entities.Packages.*;

public interface ISender {

	public void senPacket(Packet packet);
	public void receivePacket(Packet packet);	
}
