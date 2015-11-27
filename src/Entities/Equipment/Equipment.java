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
		this.equipments.add(equipment);
		equipment.associateEquipment(this);
	}

}
