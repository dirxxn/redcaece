package Entities.Network;

import Entities.Packages.*;

public interface IMessaging {

	void sendPacket(Packet<PacketType> packet);
	void receivePacket(Packet<PacketType> packet);
}
