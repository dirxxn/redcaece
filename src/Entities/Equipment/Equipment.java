package Entities.Equipment;

import java.util.ArrayList;

import Entities.Osystem.ISender;
import Entities.Packages.Packet;


/**
 * Created by efridman on 14/11/15.
 */
public abstract class Equipment implements  ISender {
	
	protected ArrayList<Equipment> equipments = new ArrayList<Equipment>();
	
}
