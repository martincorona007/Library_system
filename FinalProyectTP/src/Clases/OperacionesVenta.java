
package Clases;

public class OperacionesVenta {
	
	 private String NumFactura="";
	
	
	
	
	public String GenerarNumFactura(){
        String cod="FACT-";
        for(int i=1; i<=5;i++){
           int num = (int)((Math.random()*(90-65))+65);
           cod = cod  + (char) num;
        }
        NumFactura = cod;
        return cod;
    }
	public String getNumFactura(){
        return this.NumFactura;
    }

}
