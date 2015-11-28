package Main;
import Entities.Equipment.*;
import Entities.Osystem.*;
import Exceptions.*;;
import Entities.Network.*;

public class Main {

	public static void main(String[] args) {
		
		Hub hub1 = new Hub(15);
		
		TerminalOs osServerHub1 = new TerminalOs("Windows Server", "2012", 10);
		IPAddressV4 ipServerHub1 = new IPAddressV4(190,210,2,1);
		Terminal serverHub1 = new Terminal(osServerHub1, ipServerHub1);
		
		TerminalOs osLaptopHub1 = new TerminalOs("Windows", "7", 10);
		IPAddressV4 ipLaptopHub1 = new IPAddressV4(190,210, 2, 2);
		Terminal LaptopHub1 = new Terminal(osLaptopHub1, ipLaptopHub1);
		
		TerminalOs osDesktopHub1 = new TerminalOs("Windows", "10", 10);
		IPAddressV4 ipDesktopHub1 = new IPAddressV4(190,210, 2, 3);
		Terminal DesktopHub1 = new Terminal(osDesktopHub1, ipDesktopHub1);
		
		
		hub1.associateEquipment(serverHub1);		
		hub1.associateEquipment(LaptopHub1);
		hub1.associateEquipment(DesktopHub1);

	}

}
