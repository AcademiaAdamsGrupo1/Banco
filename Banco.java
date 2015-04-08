import java.util.Scanner;

public class Banco {
	static Scanner var_scanner;
	static Contenedor clientes;
	static int num_max_clientes;
	static int num_max_cuentas;
	static int num_lineas_pantalla;
    
	public static void main(String[] args) {
        num_max_clientes=5;		//NÚMERO MÁXIMO DE CLIENTES
        num_max_cuentas=5; 		//NÚMERO MÁXIMOS DE CUENTAS POR CLIENTE
        num_lineas_pantalla=2;	//NÚMERO DE LÍNEAS EN LA PANTALLA PARA HACER EL CLEAR SCREEN
		clientes= new Contenedor(num_max_clientes);
		var_scanner=new Scanner(System.in);
		//------------------------------------------
		//------------------------------------------
		//QUITAR LA FUNCIÓN ESTA Y SU IMPLEMENTACIÓN CUANDO ESTE LISTO
		inicializarDatosPrueba();
		//------------------------------------------
		//------------------------------------------
		menu_login();
		var_scanner.close();
	}
	
	public static void inicializarDatosPrueba(){
		for (int cliente_actual=0;cliente_actual<num_max_clientes-1;cliente_actual++){
			clientes.elementos[cliente_actual]=new Clientes("Pedro"+cliente_actual,"Picapiedra",cliente_actual+1,cliente_actual,num_max_cuentas);
			((Clientes)clientes.elementos[cliente_actual]).abrirCuenta(0,1);
			((Clientes)clientes.elementos[cliente_actual]).abrirCuenta(1,1);
			((Clientes)clientes.elementos[cliente_actual]).abrirCuenta(2,2);
			clientes.numElementos=num_max_clientes-2;
		}
	}

	
	public static void menu_login(){
		char opc_menu_login;
		do{
			cabecera(false);
			System.out.println("\t\tSeleccione la opción que desea realizar:");
			System.out.println("\t\t1.- Identificarse como (C)liente");
			System.out.println("\t\t2.- Identificarse como (P)ersonal del banco");
			System.out.println("\n\n\t\t0.- (S)alir del Banco del Grupo 1");
			opc_menu_login=var_scanner.next().charAt(0);
			var_scanner.nextLine();
			switch (opc_menu_login){
				case '1':
				case 'c':
				case 'C':
				{
					//MEJORAR LA IMPLEMENTACION DE ESTO CUANDO ESTE HECHO EL RESTO
					String id_cliente;
					String pass_cliente;
					login_cliente();
					id_cliente=var_scanner.nextLine();
					login_cliente_pass();
					pass_cliente=var_scanner.nextLine();
					for (int i=0;i<num_max_clientes;i++){
						if (clientes.elementos[i]!=null){
							if ((id_cliente.equals(((Clientes)clientes.elementos[i]).getCliente()))&&(pass_cliente.equals(((Clientes)clientes.elementos[i]).getContrasena()))){
								//System.out.println("Sí"+id_cliente);
								menu_cliente(clientes.elementos[i]);
								i=num_max_clientes;
							}else{
								//System.out.println("NO ->"+i);
							}
						}
					}
					break;
				}
				case '2':
				case 'p':
				case 'P':{
					//MEJORAR LA IMPLEMENTACION DE ESTO CUANDO ESTE HECHO EN CONDICIONES EL RESTO
					login_personal();
					String codigo_personal;
					codigo_personal=var_scanner.nextLine();
					if (codigo_personal.equals("admin")){
						System.out.println("\n\n\t\tAcceso administrativo concedido.");
						menu_personal();
					}else{
						System.out.println("\n\n\t\tAcceso administrativo no permitido.");
					}
					break;
				}
				case '0':
				case 's':
				case 'S':{
					opc_menu_login='0';
					break;
				}
				default:{
					System.out.println("\n\nLa opción elegida no es correcta");
					break;
				}
			}
		}while(opc_menu_login!='0');
	}
	
	public static void menu_cliente(Object cliente_actual){
		char opc_menu_cliente;
		do{
			cabecera(false);
			System.out.println("\t\tSeleccione la opción que desea realizar:");
			System.out.println("\t\t1.- (L)istado de sus cuentas");
			System.out.println("\t\t2.- (O)perar con una de sus cuentas");
			System.out.println("\n\t\t3.- (A)brir una nueva cuenta");
			System.out.println("\n\n\t\t0.- (V)olver al menú principal");
			opc_menu_cliente=var_scanner.next().charAt(0);
			switch (opc_menu_cliente){
				case '1':
				case 'l':
				case 'L':{
					//LISTADO DE CUENTAS VERSION CLIENTE
					((Clientes)cliente_actual).listarCuentas(false);
					break;
				}
				case '2':
				case 'o':
				case 'O':{
					int cuenta_seleccionada;
					//OPERAR CON UNA CUENTA
					//SELECCIONA SU CUENTA, LISTADO, SELECCIONA NUM_CUENTA
					((Clientes)cliente_actual).listarCuentas(true);
					System.out.println("Seleccione la cuenta por su identificador numérico: ");
					cuenta_seleccionada=var_scanner.nextInt();
					cuenta_seleccionada=cuenta_seleccionada-1; //Posición en el array de cuentas del cliente
					//Le pasamos el cliente y la posición de la cuenta seleccionada
					menu_cliente_cuentas(cliente_actual,cuenta_seleccionada);
					break;
				}
				case '3':
				case 'a':
				case 'A':{
					//CREAR CUENTA
					int tipo_cuenta;
			        System.out.println("Dispone de los siguientes tipos de cuenta");
			        System.out.println("1.- Cuenta Corriente");
			        System.out.println("2.- Cuenta Ahorro Máxima");
			        System.out.println("Seleccione el tipo de cuenta que desea abrir: ");
			        tipo_cuenta=var_scanner.nextInt();
					crearCuenta(cliente_actual,tipo_cuenta); 
					break;
				}
				case '0':
				case 's':
				case 'S':{
					opc_menu_cliente='0';
					break;
				}
			}
		}while(opc_menu_cliente!='0');
	}
	
	public static void crearCuenta(Object cliente_actual,int tipo_cuenta){
		//String identificador_cliente;
		int posicion_vacia;
		//Comprobamos que no tenga el máximo número de cuentas, ya abiertas
		if ((((Clientes)cliente_actual)).cuentas.numElementos<num_max_cuentas){
			//Con esto sacamos la primera posición vacía para poder abrir una cuenta
			(((Clientes)cliente_actual)).cuentas.iniciarRecorrido();
			posicion_vacia=((Clientes)cliente_actual).cuentas.libreSiguiente();
			//Con esto creamos la cuenta nueva en la primera posición vacía que tenga
			((Clientes)cliente_actual).abrirCuenta(posicion_vacia,tipo_cuenta);
			System.out.println("Se ha creado correctamente la cuenta");
		}else{
			System.out.println("Ya tiene abiertas el número máximo de cuentas permitidas");
		}
	}
	
	public static void menu_cliente_cuentas(Object cliente_actual, int cuenta_actual){
		char opc_menu_cliente_cuentas;
		String tipo_cuenta;
		double cantidad;
		cantidad=0;
		tipo_cuenta=((Clientes)cliente_actual).tipoCuenta(cuenta_actual);
		Object cuenta_auxiliar;
		cuenta_auxiliar=((Clientes)cliente_actual).getCuentaEntera(cuenta_actual);
		do{
			cabecera(false);
			System.out.println("\t\tSeleccione la operación que desea realizar con su cuenta: "+cuenta_actual);
			System.out.println("\t\t1.- (R)etirar dinero de su cuenta");
			System.out.println("\t\t2.- (I)ngresar dinero en su cuenta");
			System.out.println("\n\t\t3.- (M)ostrar saldo de su cuenta");
			System.out.println("\n\n\t\t0.- (V)olver al menú principal");
			opc_menu_cliente_cuentas=var_scanner.next().charAt(0);
			switch (opc_menu_cliente_cuentas){
				case '1':
				case 'r':
				case 'R':{
					//RETIRAR DINERO DE LA CUENTA
					//ACTUALIZAR VARIABLE AUXILIAR Y REAL
					double cantidad_retirada;
					System.out.println("Introduzca la cantida a retirar: ");
					cantidad=var_scanner.nextDouble();
					if (tipo_cuenta=="CuentaCorriente"){
						cantidad_retirada=((CuentaCorriente)cuenta_auxiliar).retirar(cantidad);
					}else{
						cantidad_retirada=((CuentaAhorroMaximo)cuenta_auxiliar).retirar(cantidad);
					}
					System.out.println("Se han podido retirar: "+cantidad_retirada);
					break;
				}
				case '2':
				case 'i':
				case 'I':{
					//INGRESAS DINERO EN LA CUENTA
					//ACTUALIZAR VARIABLE AUXILIAR Y REAL
					System.out.println("Introduzca la cantida a ingresar: ");
					cantidad=var_scanner.nextDouble();
					if (tipo_cuenta=="CuentaCorriente"){
						((CuentaCorriente)cuenta_auxiliar).depositar(cantidad);
					}else{
						((CuentaAhorroMaximo)cuenta_auxiliar).depositar(cantidad);
						((CuentaAhorroMaximo)cuenta_auxiliar).actualizar_saldo();
					}
					break;
				}
				case '3':
				case 'm':
				case 'M':{
					//MOSTRAR SALDO DE LA CUENTA
					if (tipo_cuenta=="CuentaCorriente"){
						System.out.println(((CuentaCorriente)cuenta_auxiliar).toString());
					}else{
						System.out.println(((CuentaAhorroMaximo)cuenta_auxiliar).toString());
					}
					break;
				}
				case '0':
				case 'v':
				case 'V':{
					opc_menu_cliente_cuentas='0';
					break;
				}
			}
		}while (opc_menu_cliente_cuentas!='0');
	}
	
	public static void menu_personal(){
		char opc_menu_personal;
		do{
			cabecera(true);
			System.out.println("\t\tSeleccione la opción que desea realizar:");
			System.out.println("\t\t1.- (L)istado de clientes del banco");
			System.out.println("\t\t2.- (A)lta de nuevo cliente");
			System.out.println("\t\t3.- (B)aja de un cliente");
			System.out.println("\n\t\t4.- (O)perar con las cuentas de un cliente");
			System.out.println("\n\n\t\t0.- (V)olver al menú principal");
			opc_menu_personal=var_scanner.next().charAt(0);
			switch (opc_menu_personal){
				case '1':
				case 'l':
				case 'L':{
					//LISTAR TODOS LOS CLIENTES DEL BANCO
					listarClientes();
					break;
				}
				case '2':
				case 'a':
				case 'A':{
					//DAR DE ALTA UN NUEVO CLIENTE
					altaCliente();
					break;
				}
				case '3':
				case 'b':
				case 'B':{
					//DAR DE BAJA UN CLIENTE EXISTENTE
					Object cliente_actual;
					cliente_actual=new Clientes();
					String cliente_seleccionado;
					listarClientes();
					System.out.println("Introduzca el ID del cliente que desea dar de baja: ");
					cliente_seleccionado=var_scanner.next();
					var_scanner.nextLine();
					//Con esto sacamos el cliente con el que estamos trabajando en vez de su posición
					for (int contador=0;contador<num_max_clientes;contador++){
						if (clientes.elementos[contador]!=null){
							if (cliente_seleccionado.equals(((Clientes)clientes.elementos[contador]).getCliente())){
							cliente_actual=clientes.elementos[contador];
							contador=num_max_clientes;
							}
						}
					}
					borrarCliente(cliente_actual);
					break;
				}
				case '4':
				case 'o':
				case 'O':{
					//OPERAR CON LAS CUENTAS DEL CLIENTE
					Object cliente_actual;
					cliente_actual=new Clientes();
					String cliente_seleccionado;
					listarClientes();
					System.out.println("Introduzca el ID del cliente con el que desea operar: ");
					cliente_seleccionado=var_scanner.next();
					var_scanner.nextLine();
					//Con esto sacamos el cliente con el que estamos trabajando en vez de su posición
					for (int contador=0;contador<num_max_clientes;contador++){
						if (clientes.elementos[contador]!=null){
							if (cliente_seleccionado.equals(((Clientes)clientes.elementos[contador]).getCliente())){
							cliente_actual=clientes.elementos[contador];
							contador=num_max_clientes;
							}
						}
					}
					//OPERACIONES CON LAS CUENTAS DE UN CLIENTE
					menu_personal_cliente(cliente_actual);
				}
				case '0':
				case 'v':
				case 'V':{
					opc_menu_personal='0';
					break;
				}
			}
		}while (opc_menu_personal!='0');	//PIRULA TEMPORAL PARA PROBAR FUNCIONAMIENTO PERSONAL/CLIENTE
	}
	
	public static void listarClientes(){
		clientes.iniciarRecorrido();
		while(clientes.haySiguiente()){
			Clientes cliente=(Clientes)clientes.siguiente();
			System.out.println("ID: "+cliente.getCliente()+" -> "+cliente.getNombre()+" "+cliente.getApellidos());
		}
	}
	
	public static void borrarCliente(Object cliente_actual){
		char opc_borrar;
		System.out.println("El cliente seleccionado tiene las siguientes cuentas:");
		((Clientes)cliente_actual).listarCuentas(true);
		System.out.println("¿Está seguro de que quiere eliminarlo? (s/n)");
		opc_borrar=var_scanner.next().charAt(0);
		if ((opc_borrar=='s')||(opc_borrar=='S')){
			String identificador_cliente;
			int posicion_cliente;
			posicion_cliente=0;
			//Con esto sacamos el cliente con el que estamos trabajando en vez de una variable auxiliar
			//Lo necesitamos para eliminar el cliente
			identificador_cliente=((Clientes)cliente_actual).getCliente();
			for (int contador=0;contador<num_max_clientes;contador++){
				if (clientes.elementos[contador]!=null){
					if (identificador_cliente.equals(((Clientes)clientes.elementos[contador]).getCliente())){
					posicion_cliente=contador;
					contador=num_max_clientes;
					}
				}
			}
			//ELIMINAMOS CUENTAS
			((Clientes)cliente_actual).cuentas.iniciarRecorrido();
			for (int contador=0;contador<num_max_cuentas;contador++){
				((Clientes)cliente_actual).cuentas.eliminar(contador);
			}
			((Clientes)cliente_actual).cuentas.numElementos=0;
			System.out.println("Se han borrado todas las cuentas del cliente");
			//ELIMINAR CLIENTE
			clientes.eliminar(posicion_cliente);
			System.out.println("Se ha dado de baja al cliente correctamente");
		}else{
			System.out.println("No se ha dado de baja el cliente.");
		}
		
	}
	
	public static void altaCliente(){
		String nombre;
		String apellidos;
		int edad;
		Object cliente_creado;
		var_scanner.nextLine();
		System.out.print("Introduce Nombre Cliente: ");
		nombre=var_scanner.nextLine();
		System.out.print("Introduce Apellidos Cliente: ");
		apellidos=var_scanner.nextLine();
		System.out.print("Introduce edad del cliente: ");
		edad=var_scanner.nextInt();
		var_scanner.nextLine();
		cliente_creado=new Clientes(nombre,apellidos,edad);
		if ((clientes.introducir(cliente_creado))){
			System.out.println("Cliente: "+nombre+" "+apellidos+", añadido con exito");
		}else{
			System.out.println("No se ha podido añadir al cliente");
		}

	}
	
	public static void menu_personal_cliente(Object cliente_actual){
		char opc_menu_personal_cliente;
		do{
			cabecera(true);
			System.out.println("\t\tSeleccione la opción que desea realizar con el cliente: "+cliente_actual);
			System.out.println("\t\t1.- (L)istado de las cuentas del cliente");
			System.out.println("\t\t2.- (A)brir una cuenta nueva al cliente");
			System.out.println("\t\t3.- (C)errar una cuenta del cliente");
			System.out.println("\n\n\t\t0.- (V)olver al menú principal");
			opc_menu_personal_cliente=var_scanner.next().charAt(0);
			switch (opc_menu_personal_cliente){
				case '1':
				case 'l':
				case 'L':{
					//LISTADO DE LAS CUENTAS
					((Clientes)cliente_actual).listarCuentas(false);
					break;
				}
				case '2':
				case 'a':
				case 'A':{
					//DAR DE ALTA UNA NUEVA CUENTA AL CLIENTE
					int tipo_cuenta;
			        System.out.println("Dispone de los siguientes tipos de cuenta");
			        System.out.println("1.- Cuenta Corriente");
			        System.out.println("2.- Cuenta Ahorro Máxima");
			        System.out.println("Seleccione el tipo de cuenta que desea abrir: ");
			        tipo_cuenta=var_scanner.nextInt();
					crearCuenta(cliente_actual,tipo_cuenta); 
					break;
				}
				case '3':
				case 'c':
				case 'C':{
					//DAR DE BAJA UNA CUENTA AL CLIENTE
					borrarCuenta(cliente_actual);
					break;
				}
				case '0':
				case 'v':
				case 'V':{
					opc_menu_personal_cliente='0';
					break;
				}
			}
		}while (opc_menu_personal_cliente!='0');
	}
	
	public static void borrarCuenta(Object cliente_actual){
			int cuenta_seleccionada;
			((Clientes)cliente_actual).listarCuentas(true);
			System.out.println("Seleccione la cuenta por su identificador numérico: ");
			cuenta_seleccionada=var_scanner.nextInt();
			cuenta_seleccionada=cuenta_seleccionada-1; //Posición en el array de cuentas del cliente
			((Clientes)cliente_actual).cuentas.eliminar(cuenta_seleccionada);
			System.out.println("Se ha eliminado correctamente la cuenta en la posición "+cuenta_seleccionada);
	}
	
	public static void login_personal(){
		cabecera(false);
		System.out.println("\t\tIntroduzca su código de trabajador del banco: ");
	}
	
	public static void login_cliente(){
		cabecera(false);
		System.out.println("\t\tIntroduzca su identificador de cliente:");
	}
	
	public static void login_cliente_pass(){
		System.out.println("\t\tIntroduzca la contraseña de su cuenta:");
	}
	
	public static void limpiar_pantalla(){
		for (int contador=1;contador<num_lineas_pantalla;contador++){
			System.out.println("\n");
		}
	}
	
	public static void cabecera(boolean admin){
		limpiar_pantalla();
		if (admin){
			System.out.println("- MODO ADMINISTRADOR BANCARIO ACTIVO -\n\n");
		}
		System.out.println("\t\t- Bienvenido al Banco del Grupo 1 -\n\n");
	}
}