package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.*;

import java.util.ArrayList;
import java.util.Iterator;

import Entities.Network.IPAddressV4;

import javax.xml.ws.Service;

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
			String message = "";
			PacketType responseType = packet.getServiceType().getResponse();
			if(packet.getServiceType().isRequest()){
				if(responseType instanceof Who){
					message = operatingSystem.getDataVersion();
				}
				Packet response = new ServicePacket(packet.getDestination(),packet.getSource(),responseType,packet.getTtl(),message);
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
	public void sendPacket(Packet packet) {
		if (equipments != null && !equipments.isEmpty()) {
			for (Equipment equipment : equipments) {
				equipment.receivePacket(packet);
			}
		}
	}

	public Terminal(){}
	
	public Terminal(TerminalOs operatingSystem, IPAddressV4 ed) {
		super();
		this.operatingSystem = operatingSystem;
		this.ed = ed;
	}

	public void sendPacket(IPAddressV4 destination, PacketType packetType) {
		boolean exists = false;
		Packet packet;
		for (Equipment equipment : equipments) {
			if(equipment.associatedIp.sameNetwork(destination)){
				packet = new ServicePacket(this.associatedIp,destination,packetType,operatingSystem.getTtl(),"");
				equipment.receivePacket(packet);
				exists = true;
			}
		}

		if(!exists){
			packet = new ServicePacket(this.associatedIp,this.ed,packetType,operatingSystem.getTtl(),"");
			RoutePacket routePacket = new RoutePacket(this.associatedIp, this.ed, packetType,
					this.operatingSystem.getTtl(),"",packet);

			this.sendPacket(routePacket);

		}
	}


}
