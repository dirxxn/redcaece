package Entities.Network;

/**
 * Created by efridman on 14/11/15.
 */
public class IPAddressV4 {
    private int firstOctet;
    private int secondOctet;
    private int thirdOctet;
    private int fourthOctet;


    /**
     * Se reciben los valores que se quiere poner para cada octeto de la IPV4.
     *
     * Si la ip que se quiere crear es valida, joya, se la crea. Sino explota
     * @param first
     * @param second
     * @param third
     * @param fourth
     * @throws Exception
     */
    public IPAddressV4(int first,int second, int third, int fourth) throws Exception {
        validateIP(first,second,third,fourth);

        this.firstOctet = first;
        this.secondOctet = second;
        this.thirdOctet = third;
        this.fourthOctet = fourth;
    }

    /**
     * Valida que la ip que se quiere crear es valida: para esto:
     * El primer octeto es valido si es un valor entre 1 y 255
     * El segundo y tercer octeto si es un valor entre 0 y 255
     * El cuarto octeto si es un valor entre 0 y 254.
     * @param first
     * @param second
     * @param third
     * @param fourth
     * @throws Exception
     */
    private void validateIP(int first,int second, int third, int fourth) throws Exception {
        if(first <= 0 && first > 255){
            throw new Exception(String.format("No se puede crear IP, el primer octeto tiene un valor invalido: {0}",first));
        }

        if(second < 0 && second > 255){
            throw new Exception(String.format("No se puede crear IP, el segundo octeto tiene un valor invalido: {0}",second));
        }

        if(third < 0 && third > 255){
            throw new Exception(String.format("No se puede crear IP, el tercer octeto tiene un valor invalido: {0}",third));
        }

        if(fourth < 0 && fourth > 254){
            throw new Exception(String.format("No se puede crear IP, el fourth octeto tiene un valor invalido: {0}",third));
        }
    }
    
    @Override
    public boolean equals(Object obj){
    	boolean equal = false;
    	if(obj != null && obj.getClass().equals(getClass())){
    		IPAddressV4 ip = (IPAddressV4)obj;
    		equal = this.firstOctet == ip.firstOctet;
    		equal = equal && this.secondOctet == ip.secondOctet;
    		equal = equal && this.thirdOctet == ip.thirdOctet;
    		equal = equal && this.fourthOctet == ip.fourthOctet;    		
    	}
    	return equal;
    }
    
    public boolean sameNetwork(IPAddressV4 ip){
    	boolean isSame = this.firstOctet == ip.firstOctet;
		isSame = isSame && this.secondOctet == ip.secondOctet;
		isSame = isSame && this.thirdOctet == ip.thirdOctet;
    	return isSame;
    }


}
