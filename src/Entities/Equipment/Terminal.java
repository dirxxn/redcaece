package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.*;

import java.util.Iterator;

import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public class Terminal extends Equipment {

	private TerminalOs operatingSystem;	
	private IPAddressV4 ed;

	public TerminalOs getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(TerminalOs operatingSystem) {
		this.operatingSystem = operatingSystem;
	}	

	public IPAddressV4 getEd() {
		return ed;
	}

	public void setEd(IPAddressV4 ed) {
		this.ed = ed;
	}


	@Override
	public void receivePacket(Packet<PacketType> packet) {
		if(packet.getDestination().equals(associatedIp)){
			String message = "";
			PacketType responseType = packet.getServiceType().getResponse();
			if(packet.getServiceType().isRequest()){
				if(responseType instanceof Who){
					message = operatingSystem.getDataVersion();
				}
				Packet<PacketType> response = new ServicePacket<PacketType>(packet.getDestination(),packet.getSource(),responseType,packet.getTtl(),message);
				sendPacket(response);
			}else{
				message = packet.getText();
				if(responseType instanceof ICMPResponse){
					message = packet.toString();
				}
				System.out.println(message);
			}
		}
	}

	@Override
	public void sendPacket(Packet<PacketType> packet) {
		// TODO Auto-generated method stub
		boolean exists = false;
		Packet<PacketType> pktRequest = packet;
		for (Equipment equipment : equipments) {
			if(equipment.associatedIp.sameNetwork(packet.getDestination())){
				exists = true;
				break;
			}
		}
		
		if(!exists){
			pktRequest = new RoutePacket<PacketType>(this.associatedIp, this.ed, packet.getServiceType(), 
					this.operatingSystem.getTtl(),"", packet);	
			
		}
		
		for (Equipment equipment : equipments) {
			equipment.receivePacket(pktRequest);
		}		
	}


}
