package Entities.Equipment;

import Entities.Packages.Packet;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment{

	private int connectionsNumber;	
	
	public void receivePaket(Packet packet){
		/*TODO 
		 * Cuando recibe un paquete lo reenvía a todos los equipos asociados.
		 * */
		this.sendPacket(packet);
	}

	@Override
	public void sendPacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivePacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}	
}
