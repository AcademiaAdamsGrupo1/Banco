import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class CuentaAhorroMaximo extends Cuentas{

	//Proceso de carga de un fichero con los tramos monetarios y el interés que procede a cada uno
	//Por lo tanto comprobación de saldo en cada actualización y adecuación de intereses según el tramo
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
	public void actualizar_saldo(){
		System.out.println("Saldo al entrar:"+saldo);
		final String nomFich="cuenta_ahorro_max.txt";
		Scanner var_scanner2;
		var_scanner2=null;
		try{
			var_scanner2=new Scanner(new FileReader(nomFich));
			while (var_scanner2.hasNext()){
				int limite;
				int limite_anterior;
				limite_anterior=0;
				limite=0;
				double interes;
				interes=0;
				while (var_scanner2.hasNextInt()){
					limite_anterior=limite;
					limite=var_scanner2.nextInt();
				}
				while (var_scanner2.hasNextDouble()){
					 
					interes=var_scanner2.nextDouble();
				}
				if ((limite>saldo)&&(limite_anterior<=saldo)){
					actualizar(saldo*interes);
					break;
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("Error abriendo el fichero "+nomFich);
		}finally{
			if (var_scanner2!=null){
				var_scanner2.close();
			}
		}
		double intereses;
		intereses=0;
		actualizar(intereses);
		System.out.println("Intereses:"+intereses);
		System.out.println("Saldo al salir:"+saldo);
	}
}