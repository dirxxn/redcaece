package Entities.Osystem;

public abstract class OperatingSystem{

	protected String name;
	protected String version;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getDataVersion(){
		String data = "Datos del sistema operativo \n";
		data = data + "Nombre: " + name + "\n";
		data = data + "Version: " + version + "\n";
		return data;
	}
	//public void senPacket(Packet packet, List<Equipment> equipments){
		// TODO 
	//}
	
}
