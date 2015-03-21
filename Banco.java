import java.util.Scanner;

public class Banco {

	static Scanner sc = new Scanner(System.in);

	public static void menutransacciones() {

		char menu = 0;

		do {

			System.out.println("Seleccione la opción que desee realizar");
			System.out.println("[1] Ingresar");
			System.out.println("[2] Retirar");
			System.out.println("[3] Transferencia");
			System.out.println("[0] Volver al menú anterior");

			menu = sc.next().charAt(0);

			switch (menu) {

			case '1':
			case 'I':
			case 'i': {

			}
				break;

			case '2':
			case 'R':
			case 'r': {

			}
				break;

			case '3':
			case 'T':
			case 't': {

			}
				break;

			case '0':
			case 'V':
			case 'v': {
				menucuentas();

			}
				break;
			}
		} while (menu != 0);
	}

	public static void menucuentas() {

		System.out
				.println("Cuenta 1: 34249204823408234098240820348082840 tipo caca.. etc");
		// Visualizaría todas las cuentas

		char menu = 0;

		do {

			System.out.println("Seleccione la opción que desea realizar");
			System.out.println("[1] Editar cuenta existente ");
			System.out.println("[2] Agregar cuenta");
			System.out.println("[3] Eliminar cuenta");
			System.out.println("[4] Realizar transacciones");
			System.out.println("[0] Volver al menú anterior");

			menu = sc.next().charAt(0);

			switch (menu) {

			case '1':
			case 'D':
			case 'd': {

			}
				break;

			case '2':
			case 'C':
			case 'c': {

			}
				break;

			case '3':
			case 'E':
			case 'e': {

			}
				break;

			case '4':
			case 'T':
			case 't': {

				menutransacciones();

			}
				break;

			case '0':
			case 'V':
			case 'v': {
				menucliente();

			}
				break;
			}
		} while (menu != 0);
	}

	public static void menudatos() {

		System.out.println("Clara mola blablablabla");
		// Visualizaría todos los datos personales

		char menu = 0;

		do {

			System.out
					.println("Pulse [1] si desea modificar sus datos personales o pulse [0] para regresar al menú anterior");

			menu = sc.next().charAt(0);

			switch (menu) {

			case '1':
			case 'M':
			case 'm': {
				// modificar datos
			}
				break;

			case '0':
			case 'V':
			case 'v': {
				menucliente();
			}
				break;
			}
		} while (menu != 0);
	}

	public static void menucliente() {

		char menu = 0;

		do {

			System.out
					.println("Bienvenido + nombre +. Seleccione la opción con la que desea trabajar");
			System.out.println("[1] Datos personales");
			System.out.println("[2] Cuentas bancarias");
			System.out.println("[0] Volver al menú anterior");

			menu = sc.next().charAt(0);

			switch (menu) {

			case '1':
			case 'D':
			case 'd': {
				menudatos();

			}
				break;

			case '2':
			case 'C':
			case 'c': {
				menucuentas();

			}
				break;

			case '0':
			case 'V':
			case 'v': {

				menuprincipal();
			}
				break;
			}
		} while (menu != 0);
	}

	public static void menuprincipal() {
		char menu = 0;

		do {

			System.out
					.println("Bienvenido al banco Grrrr. Seleccione la opción que desee realizar.");
			System.out.println("[1] Iniciar sesión con mis datos");
			System.out.println("[2] Dar de alta cuenta nueva");
			System.out.println("[0] Salir");

			menu = sc.next().charAt(0);

			switch (menu) {

			case '1':
			case 'I':
			case 'i': {
				// login
				menucliente();
			}
				break;

			case '2':
			case 'N':
			case 'n': {
				// altausuario

			}
				break;

			case '0':
			case 'S':
			case 's': {

			}
				break;
			}
		} while (menu != 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		menuprincipal();

		sc.close();
	}

}
