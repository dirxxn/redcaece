package Entities.Network;

import Entities.Packages.*;

public interface IMessaging {

	void sendPacket(Packet packet);
	void receivePacket(Packet packet);
}
