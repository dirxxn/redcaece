package Entities.Equipment;

import java.util.ArrayList;
import Entities.Network.IMessaging;
import Entities.Network.IPAddressV4;
import Exceptions.AssociateEquipmentError;

/**
 * Created by efridman on 14/11/15.
 */
public abstract class Equipment implements IMessaging {

	protected ArrayList<Equipment> equipments = new ArrayList<Equipment>();
	protected IPAddressV4 associatedIp;

	public IPAddressV4 getAssociatedIp() {
		return associatedIp;
	}

	public void setAssociatedIp(IPAddressV4 associatedIp) {
		this.associatedIp = associatedIp;
	}
	
	public void associateEquipment(Equipment equipment) throws AssociateEquipmentError{
		this.addEquipment(equipment);
		equipment.addEquipment(this);
	}
	
	protected void addEquipment(Equipment equipment){
		this.equipments.add(equipment);
	}
	
	protected ArrayList<IPAddressV4> getAllAssociatedIp(){
		ArrayList<IPAddressV4> iplst = new ArrayList<IPAddressV4>();
		for (Equipment e : this.equipments) {
			iplst.add(e.getAssociatedIp());
		}		
		return iplst;
	}

}
