package Entities.Equipment;

import java.util.ArrayList;

import Entities.Network.IMessaging;


/**
 * Created by efridman on 14/11/15.
 */
public abstract class Equipment implements IMessaging {
	
	protected ArrayList<Equipment> equipments = new ArrayList<Equipment>();
	
}
