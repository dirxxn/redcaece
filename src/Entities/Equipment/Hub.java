package Entities.Equipment;

import java.util.ArrayList;

import Entities.Osystem.ISender;
import Entities.Packages.ICMPRequest;
import Entities.Packages.ICMPResponse;
import Entities.Packages.Packet;
import Entities.Packages.RoutePacket;
import Entities.Packages.Sendmsg;
import Entities.Packages.Who;

/**
 * Created by efridman on 14/11/15.
 */
public class Hub extends Equipment{

	private int connectionsNumber;	
	
	public void receivePaket(Packet packet){
		/*TODO 
		 * Cuando recibe un paquete lo reenvía a todos los equipos asociados.
		 * */
		this.senPacket(packet);
	}

	@Override
	public void senPacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivePacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}	
}
