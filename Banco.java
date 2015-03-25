import java.util.Scanner;

public class Banco {
	static Scanner var_scanner;
	static Contenedor clientes;
	static int num_max_clientes;
	static int num_max_cuentas;
	static int num_lineas_pantalla;
	static String numCuentaAcumulativo; //Pendiente de implementar el tokenizer para cargarnos esto
    
	public static void main(String[] args) {
        num_max_clientes=5;
        num_max_cuentas=5;
        num_lineas_pantalla=20;
        numCuentaAcumulativo="ES34.";
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
		String cuentaNueva;
		cuentaNueva=numCuentaAcumulativo;
		for (int cliente_actual=0;cliente_actual<num_max_clientes;cliente_actual++){
			cuentaNueva=cuentaNueva+String.valueOf(cliente_actual);
			clientes.elementos[cliente_actual]=new Clientes("Pedro"+cliente_actual,"Picapiedra",cliente_actual*10,cliente_actual,num_max_cuentas);
			for (int cuenta_actual=0;cuenta_actual<num_max_cuentas;cuenta_actual++){
				cuentaNueva=cuentaNueva+String.valueOf(cuenta_actual);
				((Clientes)clientes.elementos[cliente_actual]).abrirCuenta(cuenta_actual, cuentaNueva);
			}
			cuentaNueva=numCuentaAcumulativo;
		}
		numCuentaAcumulativo=cuentaNueva;
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
						if ((id_cliente.equals(((Clientes)clientes.elementos[i]).getCliente()))&&(pass_cliente.equals(((Clientes)clientes.elementos[i]).getContrasena()))){
							System.out.println("Sí"+id_cliente);
							menu_cliente(id_cliente);
							i=num_max_clientes;
						}else{
							System.out.println("NO ->"+i);
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
	
	public static void menu_cliente(String id_cliente){
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
					break;
				}
				case '2':
				case 'o':
				case 'O':{
					//OPERAR CON UNA CUENTA
					//SELECCIONA SU CUENTA, LISTADO, SELECCIONA NUM_CUENTA
					//COMPRUEBA QUE ES SUYA DE NUEVO Y LANZA MENU_CLIENTE_CUENTAS
					String cuenta_seleccionada;
					cuenta_seleccionada="a"; //CAMBIAR CUANDO ESTÉ IMPLEMENTADO EL PROCESO DE BÚSQUEDAD DE CUENTA
					menu_cliente_cuentas(id_cliente,cuenta_seleccionada);
					break;
				}
				case '3':
				case 'a':
				case 'A':{
					//CREAR CUENTA
					//MIRA QUE NO TENGA 100 CUENTAS
					//BUSCA EL PRIMER HUECO CON RECORRIDO Y MIRANDO SI ESTÁ LIBRE PARA QUE NO HAGA PUNTERO A NULL (cast)	
					break;
				}
				case '0':
				case 's':
				case 'S':{
					opc_menu_cliente='0';
					//LISTADO DE CUENTAS VERSION CLIENTE
					break;
				}
			}
		}while(opc_menu_cliente!='0');
	}
	
	public static void menu_cliente_cuentas(String id_cliente, String cuenta_actual){
		char opc_menu_cliente_cuentas;
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
					break;
				}
				case '2':
				case 'i':
				case 'I':{
					//INGRESAS DINERO EN LA CUENTA
					break;
				}
				case '3':
				case 'm':
				case 'M':{
					//CREAR UNA CUENTA NUEVA	
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
			System.out.println("\t\t3.- (B)aja de cliente actual");
			System.out.println("\n\t\t4.- (O)perar con las cuentas de un cliente");
			System.out.println("\n\n\t\t0.- (V)olver al menú principal");
			opc_menu_personal=var_scanner.next().charAt(0);
			switch (opc_menu_personal){
				case '1':
				case 'l':
				case 'L':{
					//LISTAR TODOS LOS CLIENTES DEL BANCO
					break;
				}
				case '2':
				case 'a':
				case 'A':{
					//DAR DE ALTA UN NUEVO CLIENTE
					break;
				}
				case '3':
				case 'b':
				case 'B':{
					//DAR DE BAJA UN CLIENTE EXISTENTE	
					//ATENCION CUENTAS!!!
					break;
				}
				case '4':
				case 'o':
				case 'O':{
					//OPERACIONES CON LAS CUENTAS DE UN CLIENTE
					//LISTAR CLIENTES
					//SELECCIONAR CLIENTE
					//PASAR EL ID_CLIENTE CON LOS MÉTODOS PARA LAS OPERACIONES
					//LANZAR MENU_PERSONAL_CLIENTE
					String cliente_seleccionado;
					cliente_seleccionado="patata"; //CAMBIAR CUANDO ESTÉ IMPLEMENTADO
					menu_personal_cliente(cliente_seleccionado);
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
	
	public static void menu_personal_cliente(String cliente_actual){
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
					//LISTADO DE LAS CUENTAS, OPCIÓN DE SALDO SÍ O NO
					break;
				}
				case '2':
				case 'a':
				case 'A':{
					//DAR DE ALTA UNA NUEVA CUENTA AL CLIENTE
					break;
				}
				case '3':
				case 'c':
				case 'C':{
					//CERRAR UNA CUENTA DEL CLIENTE
					//LISTAR, SELECCIONAR Y COMPROBAR
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