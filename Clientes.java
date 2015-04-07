import java.util.Random;
//import java.util.StringTokenizer;

public class Clientes {
	String nombre;
	String apellidos;
	String contrasena;
	String id_cliente;
	int edad;
	Contenedor cuentas;
	
	public Clientes(){
	}
	
	public Clientes(String nombre,String apellidos,int edad){
    	this.nombre=nombre;
    	this.apellidos=apellidos;
    	this.edad=edad;
    	//Generar id_cliente contador incremental pero algo aleatorio y asociar a this.id_cliente
    	this.id_cliente="cliente";
    	//Generar contraseña aleatoria y asociar a this.contrasena
    	this.contrasena="patata";
	}
	
	public Clientes(String nombre,String apellidos,int edad,int num_cliente,int num_cuentas){
    	this.nombre=nombre;
    	this.apellidos=apellidos;
    	this.edad=edad;
    	//Generar id_cliente contador incremental pero algo aleatorio y asociar a this.id_cliente
    	this.id_cliente="cliente"+num_cliente;
    	//Generar contraseña aleatoria y asociar a this.contrasena
    	this.contrasena="patata";
    	cuentas=new Contenedor(num_cuentas);
	}

	public void abrirCuenta(int posicion){
		//cuentas.elementos[posicion]=new CuentaCorriente(numCuentaToken);
        String Cuenta=new String();
        Cuenta="ES34.5009.0001.10.2";
        Random rm=new Random();
        long x=rm.nextInt(1000000000);
        Cuenta=Cuenta+x;
        /*StringTokenizer iban =new StringTokenizer(Cuenta,".");
        for(int i=0;i<5;i++){
        	numCuentaToken=iban.nextToken();
        }*/
        cuentas.elementos[posicion]=new CuentaCorriente(Cuenta);
	}
	
	public void listarCuentas(boolean menu){
		Object cuenta;
		int contador;
		contador=1;
		this.cuentas.iniciarRecorrido();
		while(this.cuentas.haySiguiente()){
			cuenta=((Cuentas)this.cuentas.siguiente());
			//Control del tipo de cuenta
			//System.out.println(cuenta.getClass().getName());
			if (menu){
				System.out.print(contador+".- ");
				if (cuenta.getClass().getName()=="CuentaCorriente"){
					System.out.println("Cuenta Corriente-> "+((CuentaCorriente)cuenta).toStringMenu());	
				}else{
					System.out.println("Cuenta Ahorro-> "+((CuentaAhorroMaximo)cuenta).toStringMenu());
				}
				contador++;
			}else{
				if (cuenta.getClass().getName()==("CuentaCorriente")){
					System.out.println("Cuenta Corriente-> "+((CuentaCorriente)cuenta).toString());
				}else{
					System.out.println("Cuenta Ahorro-> "+((CuentaAhorroMaximo)cuenta).toString());
				}
			}
		}
	}
	
	public String tipoCuenta(int cuenta_actual){
		Object cuenta;
		cuenta=this.cuentas.elementos[cuenta_actual];
		return(cuenta.getClass().getName());
	}
	
	public Object getCuentaEntera(int cuenta_actual){
		Object cuenta;
		cuenta=this.cuentas.elementos[cuenta_actual];
		return(cuenta);
	}
	
	public String getNombre(){
    	return (this.nombre);
	}
	public String getApellidos(){
    	return (this.apellidos);
	}
	public int getEdad(){
    	return (this.edad);
	}
	
	public String getCliente(){
		return (this.id_cliente);
	}
	
	public String getContrasena(){
		return (this.contrasena);
	}
	
	public String toString(){
    	return ("Nombre: "+this.nombre+"\nApellidos: "+this.apellidos+"\nEdad: "+this.edad);
	}
	
	public String getCuenta(int posicion){
		return (this.cuentas.elementos[posicion].toString());
	}
	public void cerrarCuenta(){}
	public void depositar(){}
	public void retirar(){}
	public void devolverSaldo(){}
	public void actualizar(){}
}