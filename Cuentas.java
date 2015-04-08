abstract class Cuentas{
	String numeroCuenta;
	double saldo;
	
	public void numeroCuenta(String numeCuenta){
		saldo=0;
		this.numeroCuenta=numeCuenta;
	}
	
	public void depositar(double cantidad){
		saldo=saldo+cantidad;
	}
	
	public abstract double retirar(double cantidad);
	
	public double devuelveSaldo(){
		return (saldo);
	}
	
	public String devuelveCadena(){
		return (numeroCuenta);
	}
	
	public String toString(){
 		return ("Numero de Cuenta: "+this.numeroCuenta+"\tSaldo: "+this.saldo);
 	}
	
	public String toStringMenu(){
 		return ("Cuenta: "+this.numeroCuenta);
 	}
}