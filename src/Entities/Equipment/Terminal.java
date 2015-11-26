package Entities.Equipment;

import Entities.Osystem.TerminalOs;
import Entities.Packages.ICMPRequest;
import Entities.Packages.ICMPResponse;
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

	public void receivePaket(ICMPRequest packet){
		/* TODO falta resto de la logica
		 * ICMPRequest entonces le envía a la dirección de red del remitente un tipo paquete
			ICMPResponse. 
		 */
		this.operatingSystem.senPacket(packet, this.equipments);
	}
	
	public void receivePaket(ICMPResponse packet){
		/* TODO 
		 * entonces imprime por pantalla los datos del paquete recibido.
		 * 
		 * */
	}
	
	public void receivePaket(Who packet){
		/*TODO 
		 * entonces le envía a la dirección de red remitente un paquete tipo Sendmsg con los datos
			de su sistema operativos. Por ejemplo, nombre versión
		 * */
		this.operatingSystem.senPacket(packet, this.equipments);
	}
	
	public void receivePaket(Sendmsg packet){
		/*TODO 
		 * entonces imprime por pantalla el mensaje de texto del paquete
		 * */
	}
	
	
}
