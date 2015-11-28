package Entities.Equipment;

import java.util.ArrayList;
import java.util.Map;
import Entities.Network.IPAddressV4;
import Entities.Network.Network;
import Entities.Osystem.NetworkOs;
import Entities.Osystem.OperatingSystem;
import Entities.Packages.*;

/**
 * Created by efridman on 14/11/15.
 */
public class Router extends NetEquipment {

	private Map<Integer, IPAddressV4> routingTable;
	private Equipment defaultEquipment; // boca por defecto?
	private NetworkOs operatingSystem;
	private int maxConnections;
	private ArrayList<Equipment> connectedEquipments;

	public Router(){

	}

	public Router(Equipment defaultEquipment, NetworkOs os){
		this.defaultEquipment = defaultEquipment;
		this.operatingSystem = os;
	}

	public void updateRoutingTable(Integer port, IPAddressV4 newIp) {

	}
	
	public void receivePaket(RoutePacket packet){
		/*TODO 
		 * Cuando recibe un paquete de tipo Ruteo:
			1. Toma la dirección de red de destino del paquete que tiene dentro.
			2. Luego verifica si la dirección de red destino está en la misma red de algunas de las direcciones
			de red asociadas. En tal caso envía el paquete al equipo asociado.
			3. En caso que no encuentre la dirección de red destino del paquete en la lista entonces envía un
			paquete Ruteo al equipo asociado a la boca por defecto.
			4. Envía un paquete Sendmsg al remitente informando que no se puede entregar el paquete.
		 * 
		 * */
	}
	
	public void receivePaket(Who packet){
		/*TODO 
		 * Cuando recibe un paquete tipo WHO:
			1. Verifica que la dirección de destino se alguna de las propias en tal caso
			2. Envía un paquete Sendmsg al remitente con toda la información de su sistema operativo y las
				rutas que tiene.
			3. En caso contrario no hace nada.
		 * 
		 * */
	}

	@Override
	public void sendPacket(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receivePacket(Packet packet) {
		if(packet instanceof RoutePacket){
			if(connectedEquipments != null && connectedEquipments.size() > 0){
				for(Equipment equipment : connectedEquipments){
					if(equipment.associatedIp.sameNetwork(packet.getDestination())){
						equipment.receivePacket(packet);
						return;
					}
				}
			}
			defaultEquipment.receivePacket(packet);
		}else if(packet.getServiceType() instanceof Who){
			ServicePacket<Sendmsg> responsePacket = new ServicePacket<Sendmsg>(packet.getDestination(),packet.getSource(),new Sendmsg(),packet.getTtl() -1,"");
			String message = operatingSystem.getDataVersion();
			message += " Route table: " + routingTable.toString();
			responsePacket.setText(message);
			if(connectedEquipments != null && connectedEquipments.size() > 0){
				for(Equipment equipment : connectedEquipments){
					if(equipment.associatedIp.sameNetwork(packet.getDestination())){
						equipment.receivePacket(responsePacket);
						return;
					}
				}
			}
			defaultEquipment.receivePacket(responsePacket);
		}
		
		
	}

}
