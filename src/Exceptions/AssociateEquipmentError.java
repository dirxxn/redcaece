package Exceptions;

public class AssociateEquipmentError extends Exception {

	public AssociateEquipmentError(){
		super("Can not associate equipment, connections numbers exceeded");
	}
}
