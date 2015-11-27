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

	/**
	 * Devuelve la informacion relativa al sistema operativo
	 * @return
	 */
	public abstract String getDataVersion();
	
}
