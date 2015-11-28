package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.*;
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
	public void receivePacket(Packet packet) {
		if(packet.getDestination().equals(associatedIp)){
			String message = packet.getText();
			PacketType responseType = packet.getServiceType().getResponse();
			if(packet.getServiceType().isRequest()){
				if(responseType instanceof Who){
					message = operatingSystem.getDataVersion();
				}
				Packet response = new ServicePacket(packet.getDestination(),packet.getSource(),responseType,packet.getTtl(),message);
				sendPacket(response);
			}else{
				if(packet.getServiceType() instanceof ICMPResponse){
					message = packet.toString();
				}
				System.out.println(String.format("La ip: %s recibio el mensaje '%s' de la ip: %s",this.associatedIp.toString(),message, packet.getSource().toString()));

			}
		}
	}

	@Override
	public void sendPacket(Packet packet) {
		if (equipments != null && !equipments.isEmpty()) {
			for (Equipment equipment : equipments) {
				equipment.receivePacket(packet);
			}
		}
	}

	public Terminal(IPAddressV4 ip,TerminalOs operatingSystem){
		super(ip);
		this.operatingSystem = operatingSystem;
	}
	
	public Terminal(IPAddressV4 ip,TerminalOs operatingSystem, IPAddressV4 ed) {
		super(ip);
		this.operatingSystem = operatingSystem;
		this.ed = ed;
	}

	public void sendPacket(IPAddressV4 destination, PacketType packetType,String message) {
		boolean exists = false;
		Packet packet;
		for (Equipment equipment : equipments) {
			if(equipment.associatedIp.sameNetwork(destination)){
				packet = new ServicePacket(this.associatedIp,destination,packetType,operatingSystem.getTtl(),message);
				equipment.receivePacket(packet);
				exists = true;
			}
		}

		if(!exists){
			packet = new ServicePacket(this.associatedIp,this.ed,packetType,operatingSystem.getTtl(),message);
			RoutePacket routePacket = new RoutePacket(this.associatedIp, this.ed, packetType,
					this.operatingSystem.getTtl(),"",packet);

			this.sendPacket(routePacket);

		}

		System.out.println(String.format("La ip: %s envio el mensaje '%s'", this.associatedIp.toString(), message));
	}


}
