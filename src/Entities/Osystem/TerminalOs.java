package Entities.Osystem;

public abstract class TerminalOs extends OperatingSystem {

	protected int ttl;

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
}
