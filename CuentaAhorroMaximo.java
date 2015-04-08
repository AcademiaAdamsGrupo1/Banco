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
		String nomFich="cuenta_ahorro_max.txt";
		Scanner var_scanner2;
		Scanner var_scanner3;
		var_scanner2=null;
		var_scanner3=null;
		String linea;
		linea="";
		try{
			var_scanner2=new Scanner(new FileReader(nomFich));
			int limite;
			int limite_anterior;
			double interes;
			double interes_nuevo;
			limite_anterior=0;
			limite=0;
			interes_nuevo=0;
			interes=0;
			while (var_scanner2.hasNext()){
				linea=var_scanner2.nextLine();
				var_scanner3=new Scanner(linea);
				limite_anterior=limite;
				limite=var_scanner3.nextInt();
				System.out.println("Limite= "+limite);
				interes=interes_nuevo;
				interes_nuevo=var_scanner3.nextDouble();
				System.out.println("Interes= "+interes);
				if ((limite>saldo)&&(limite_anterior<=saldo)){
					actualizar(saldo*interes/100);
					break;
				}
				var_scanner3.close();
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