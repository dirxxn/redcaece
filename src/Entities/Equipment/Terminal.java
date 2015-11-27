package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.ICMPRequest;
import Entities.Packages.ICMPResponse;
import Entities.Packages.Packet;
import Entities.Packages.Sendmsg;
import Entities.Packages.Who;
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

	
	public void receivePacket(ICMPRequest packet){
		/* TODO falta resto de la logica
		 * ICMPRequest entonces le envía a la dirección de red del remitente un tipo paquete
			ICMPResponse. 
		 */
		if(packet.getDestination().equals(this.associatedIp)){
			
			ICMPResponse pktResponse = new ICMPResponse();
			pktResponse.setDestination(packet.getSource());
			pktResponse.setSource(associatedIp);
			pktResponse.setText(packet.getText()); // no se si esto esta bien?
			this.sendPacket(pktResponse);
			
		}
		
	}
	
	public void receivePacket(ICMPResponse packet){
		/* TODO 
		 * entonces imprime por pantalla los datos del paquete recibido.
		 * 
		 * */
		if(packet.getDestination().equals(this.associatedIp)){
			
			System.out.println("------------ Paquete ICMPResponse Recibido ------------");
			System.out.println("Origen: " +  packet.getSource() + " - Destino: " + packet.getDestination());
			System.out.println("Datos: " + packet.getText());			
		}
	}
	
	public void receivePacket(Who packet){
		/*TODO 
		 * entonces le envía a la dirección de red remitente un paquete tipo Sendmsg con los datos
			de su sistema operativos. Por ejemplo, nombre versión
		 * */
		if(packet.getDestination().equals(this.associatedIp)){			
			
			Sendmsg pktSendmsg = new Sendmsg();
			pktSendmsg.setSource(associatedIp);
			pktSendmsg.setDestination(packet.getSource());
			pktSendmsg.setText(this.operatingSystem.getDataVersion());
			this.sendPacket(pktSendmsg);
		}
		
	}
	
	public void receivePacket(Sendmsg packet){
		/*TODO 
		 * entonces imprime por pantalla el mensaje de texto del paquete
		 * */
		if(packet.getDestination().equals(this.associatedIp)){
			System.out.println("------------ Paquete Sendmsg Recibido ------------");
			System.out.println("Datos: " + packet.getText());
		}
	}

	@Override
	public void receivePacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPacket(Packet packet) {
		// TODO Auto-generated method stub
		for (Equipment equipment : equipments) {
			equipment.receivePacket(packet);
		}		
	}
	
	
	
}
