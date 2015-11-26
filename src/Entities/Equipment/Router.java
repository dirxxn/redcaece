package Entities.Equipment;

import java.util.Map;
import Entities.Network.IPAddressV4;
import Entities.Osystem.NetworkOs;

/**
 * Created by efridman on 14/11/15.
 */
public class Router extends Equipment {

	private Map<Integer, IPAddressV4> routingTable;
	private Integer defaultPort; // boca por defecto?
	private int connectionsNumber;
	private NetworkOs operatingSystem;

	public void updateRoutingTable(Integer port, IPAddressV4 newIp) {

	}

}
