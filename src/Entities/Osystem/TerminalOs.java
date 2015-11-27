package Entities.Osystem;


import Entities.Equipment.Equipment;
import Entities.Packages.Packet;

public class TerminalOs extends OperatingSystem {

	protected int ttl;

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	@Override
	public String getDataVersion(){
		String data = "Datos del sistema operativo \n";
		data = data + "Nombre: " + getName() + "\n";
		data = data + "Version: " + getVersion() + "\n";
		data = data + "TTL: " + getTtl() + "\n";
		data = data + "Tipo: Terminal \n";
		return data;
	}
	
}
