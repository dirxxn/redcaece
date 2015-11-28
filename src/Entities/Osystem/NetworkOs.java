package Entities.Osystem;

public class NetworkOs extends OperatingSystem{

    @Override
    public String getDataVersion(){
        String data = "Datos del sistema operativo \n";
        data = data + "Nombre: " + getName() + "\n";
        data = data + "Version: " + getVersion() + "\n";
        data = data + "Tipo: Network \n";
        return data;
    }
    
    public NetworkOs(){}
    
    public NetworkOs(String name, String version){
    	this.name = name;
    	this.version = version; 			
    }

	
}
