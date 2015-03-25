class CuentaAhorroMaximo extends Cuentas{

	//Proceso de carga de un fichero con los tramos monetarios y el inter�s que procede a cada uno
	//Por lo tanto comprobaci�n de saldo en cada actualizaci�n y adecuaci�n de intereses seg�n el tramo
	public CuentaAhorroMaximo(String numCuenta){
		this.numeroCuenta(numCuenta);
	}
	
	public double retirar(double cantidad){
		double saldo_real;
		if (saldo>cantidad){
			saldo=saldo-cantidad;
			return (cantidad);
		}else{
			saldo_real=saldo;
			saldo=0;
			return (saldo_real);
		}
	}
}