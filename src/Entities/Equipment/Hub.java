package Entities.Equipment;

import java.util.ArrayList;

import Entities.Osystem.ISender;
import Entities.Packages.Packet;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment implements ISender{

	private int connectionsNumber;

	@Override
	public void senPacket(Packet packet, ArrayList<Equipment> equipments) {
		// TODO Auto-generated method stub
		
	}
	
	public void receivePaket(Packet packet){
		/*TODO 
		 * Cuando recibe un paquete lo reenvía a todos los equipos asociados.
		 * */
		this.senPacket(packet, this.equipments);
	}
	
	
	
}
