package Entities.Equipment;

import Exceptions.AssociateEquipmentError;

public class Main {

	public static void main(String[] args) throws AssociateEquipmentError {
		// TODO Auto-generated method stub
		
		Hub h = new Hub(9);
		Hub h1 = new Hub(10);
		h.associateEquipment(h1);
		
		System.out.println("OK");

	}

}
