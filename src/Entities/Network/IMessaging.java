package Entities.Network;

import Entities.Packages.*;

public interface IMessaging {

	void sendPacket(Packet packet);
	void sendPacket(IPAddressV4 destination, PacketType packetType);
	void receivePacket(Packet packet);
}
