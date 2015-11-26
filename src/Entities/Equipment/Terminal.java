package Entities.Equipment;

import java.util.ArrayList;
import Entities.Osystem.TerminalOs;
import Entities.Network.IPAddressV4;

/**
 * Created by efridman on 14/11/15.
 */
public class Terminal {

	private ArrayList<Equipment> equipments = new ArrayList<>();
	private TerminalOs operatingSystem;
	private IPAddressV4 associatedIp;
	private IPAddressV4 ed;

}
