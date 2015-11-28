package Main;

import Entities.Equipment.*;
import Entities.Osystem.*;
import Entities.Packages.Sendmsg;
import Entities.Network.*;

public class Main {

	public static void main(String[] args) throws Exception {

		try{
			IPAddressV4 ipHub1 = new IPAddressV4(190, 210, 2, 4);
			Hub hub1 = new Hub(15, ipHub1);
	
			TerminalOs osServerHub1 = new TerminalOs("Windows Server", "2012", 10);
			IPAddressV4 ipServerHub1 = new IPAddressV4(190, 210, 2, 1);
			Terminal serverHub1 = new Terminal(ipServerHub1,osServerHub1);
	
			TerminalOs osLaptopHub1 = new TerminalOs("Windows", "7", 10);
			IPAddressV4 ipLaptopHub1 = new IPAddressV4(190, 210, 2, 2);
			Terminal LaptopHub1 = new Terminal(ipLaptopHub1,osLaptopHub1);
	
			TerminalOs osDesktopHub1 = new TerminalOs("Windows", "10", 10);
			IPAddressV4 ipDesktopHub1 = new IPAddressV4(190, 210, 2, 3);
			Terminal DesktopHub1 = new Terminal(ipDesktopHub1,osDesktopHub1);
	
			hub1.associateEquipment(serverHub1);
			hub1.associateEquipment(LaptopHub1);
			hub1.associateEquipment(DesktopHub1);
	
			IPAddressV4 ipHub2 = new IPAddressV4(10, 10, 5, 4);
			Hub hub2 = new Hub(15, ipHub2);
	
			TerminalOs osServerHub2 = new TerminalOs("Linux", "Ubuntu 14.05", 10);
			IPAddressV4 ipServerHub2 = new IPAddressV4(10, 10, 5, 1);
			Terminal serverHub2 = new Terminal(ipServerHub2,osServerHub2);
	
			TerminalOs osLaptopHub2 = new TerminalOs("Linux", "Mint", 10);
			IPAddressV4 ipLaptopHub2 = new IPAddressV4(10, 10, 5, 2);
			Terminal LaptopHub2 = new Terminal(ipLaptopHub2,osLaptopHub2);
	
			TerminalOs osDesktopHub2 = new TerminalOs("Linux", "Debian", 10);
			IPAddressV4 ipDesktopHub2 = new IPAddressV4(10, 10, 5, 3);
			Terminal DesktopHub2 = new Terminal(ipDesktopHub2,osDesktopHub2);
	
			hub2.associateEquipment(serverHub2);
			hub2.associateEquipment(LaptopHub2);
			hub2.associateEquipment(DesktopHub2);
	
			IPAddressV4 ipHub3 = new IPAddressV4(192, 168, 100, 4);
			Hub hub3 = new Hub(15, ipHub3);
	
			TerminalOs osServerHub3 = new TerminalOs("OS X", "Server 5", 10);
			IPAddressV4 ipServerHub3 = new IPAddressV4(192, 168, 100, 1);
			Terminal serverHub3 = new Terminal(ipServerHub3,osServerHub3);
	
			TerminalOs osLaptopHub3 = new TerminalOs("OS X", "10.9", 10);
			IPAddressV4 ipLaptopHub3 = new IPAddressV4(192, 168, 100, 2);
			Terminal LaptopHub3 = new Terminal(ipLaptopHub3,osLaptopHub3);
	
			TerminalOs osDesktopHub3 = new TerminalOs("OS X", "10.8", 10);
			IPAddressV4 ipDesktopHub3 = new IPAddressV4(192, 168, 100, 3);
			Terminal DesktopHub3 = new Terminal(ipDesktopHub3,osDesktopHub3);
	
			hub3.associateEquipment(serverHub3);
			hub3.associateEquipment(LaptopHub3);
			hub3.associateEquipment(DesktopHub3);
			
			
			NetworkOs osRouter = new NetworkOs("Router SO", "1.0");
			Hub defaultHub = new Hub(50, new IPAddressV4(192, 168, 100, 50));
			IPAddressV4 ipRouter = new IPAddressV4(192, 168, 100, 254);
			Router router = new Router(ipRouter,defaultHub, osRouter);
			router.setConnectionsNumber(15);
			router.associateEquipment(hub1);
			router.associateEquipment(hub2);
			router.associateEquipment(hub3);
			
			
			serverHub1.sendPacket(ipDesktopHub1, new Sendmsg());
		}
		catch(Exception ex){
			
			System.out.println("Error " + ex.getMessage());			
		}

	}

}
