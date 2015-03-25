class CuentaCorriente extends Cuentas{

	public CuentaCorriente(String numCuenta){
		this.numeroCuenta(numCuenta);
	}

    public double retirar (double cantidad){
    	double saldo_real;
		if (saldo>cantidad) {
			saldo=saldo-cantidad;
			return (cantidad);
		}else{
			saldo_real=saldo;
			saldo=0;
			return (saldo_real);
		}
	}
}