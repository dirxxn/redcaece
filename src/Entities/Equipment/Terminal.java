package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.*;
import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public class Terminal extends Equipment {

	private TerminalOs operatingSystem;
	private IPAddressV4 associatedIp;
	private IPAddressV4 ed;

	public TerminalOs getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(TerminalOs operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public IPAddressV4 getAssociatedIp() {
		return associatedIp;
	}

	public void setAssociatedIp(IPAddressV4 associatedIp) {
		this.associatedIp = associatedIp;
	}

	public IPAddressV4 getEd() {
		return ed;
	}

	public void setEd(IPAddressV4 ed) {
		this.ed = ed;
	}


	@Override
	public void receivePacket(Packet<PacketType> packet) {
		String message = "";
		PacketType responseType = packet.getServiceType().getResponse();
		if(packet.getServiceType().isRequest()){
			if(responseType instanceof Who){
				message = operatingSystem.getDataVersion();
			}
			Packet<PacketType> response = new ServicePacket<PacketType>(packet.getDestination(),packet.getSource(),responseType,packet.getTtl(),message);
		}else{
			message = packet.getText();
			if(responseType instanceof ICMPResponse){
				message = packet.toString();
			}
			System.out.println(message);
		}
	}

	@Override
	public void sendPacket(Packet<PacketType> packet) {
		// TODO Auto-generated method stub
		for (Equipment equipment : equipments) {
			equipment.receivePacket(packet);
		}		
	}


}
