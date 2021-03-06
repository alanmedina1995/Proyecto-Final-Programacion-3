package Menu;

import java.util.Scanner;

import archivos.JsonUtiles;
import colecciones.ListaUsuarios;
import usuarios.Usuario;
/**
 * 
 * @author Alan Medina, Martin Gonzalez y Juan Voirin
 *
 */
public class OpcionesUsuario
{

	static Scanner scan;

	/**
	 * Menu de operador.
	 */
	public static void menu(Usuario usuario)
	{
		scan = new Scanner(System.in);
		System.out.println("1. Consultar ID.");
		System.out.println("2. Cambiar contraseņa.");
		System.out.println("0. Menu principal.");
		int menu = scan.nextInt();
		scan.nextLine();
		switch (menu)
		{
		case 1:
			System.out.println(usuario.getId());
			break;
		case 2:
			cambiarContraseņa(usuario);
			break;
		case 0:
			break;
		}
	}


	/**
	 * Menu cambiar contraseņa general
	 */
	private static void cambiarContraseņa(Usuario usuario)
	{
		scan = new Scanner(System.in);
		ListaUsuarios users = JsonUtiles.abrirArchivoUsuarios();
		Usuario aux = users.buscaUsuario(usuario.getId());
		System.out.println("\nIngrese contraseņa actual: ");
		int vieja = scan.nextInt();
		scan.nextLine();
		System.out.println("\nIngrese contraseņa nueva: ");
		int nueva = scan.nextInt();
		scan.nextLine();
		System.out.println(aux.modificarClave(vieja, nueva));
		JsonUtiles.guardarArchivoUsuarios(users);
	}
}
