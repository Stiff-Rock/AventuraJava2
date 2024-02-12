import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int valorDispositivo = 2000000;
		Scanner in = new Scanner(System.in);
		// Breve introducción
		System.out.println(
				"- Te despiertas de tu siesta muy confundido y sientes cómo rápidamente se te olvida lo que habias soñado.");
		System.out.println("- En tu cabeza resuenan las palabras \"Tesoro\" y \"Doblón\" pero no les das importancia.");
		System.out.println("- De hecho, has dormido tan profundamente que ni si quiera recuerdas como te llamas");
		System.out.println("\"¿Mi nombre...? ¿Cómo me llamo?\" - Te pregntas a ti mismo.");
		System.out.println("");
		System.out.println("En serio, ¿Cómo me llamo?");
		System.out.print("- Introduce tu nombre: ");
		// El usuario introduce su nombre
		String nombre = in.next();
		System.out.println("¿" + nombre + "? Es cierto, me llamo " + nombre + ", o eso creo.");
		System.out.println("");
		System.out.println(
				"Menuda siesta, será mejor que me levante y vaya a buscar al capitán de la nave, que hoy tenemos trabajo que hacer.");
		System.out.println("Pero antes de nada, ¿Que arma deberia cojer?");
		System.out.println("");

		System.out.println("- Introduce 1,2 o 3: ");
		System.out.println("1. Lanza de energía");
		System.out.println("2. Pistola láser");
		System.out.println("3. Dagas de nanocuchillas");
		String armaSelec = "";
		int eleccionArma = in.nextInt();
		// Indicamos al usuario sus opciones para que escoja su arma con un switch
		// ya que es el más cómodo para varias opciones a escoger con un entero
		switch (eleccionArma) {
		case 1:
			armaSelec = "lanza de energía";
			System.out.println("Esta vez me llevo la " + armaSelec
					+ " así podré emboscar a enemigos pero manteniendo la distancia.");
			armaSelec = "tu lanza de energía";
			break;
		case 2:
			armaSelec = "pistola láser";
			System.out.println(
					"La " + armaSelec + " siempre es buena opción, nada mejor que atacar desde lejos y con precisión.");
			armaSelec = "tu pistola láser";
			break;
		case 3:
			armaSelec = "dagas de nanocuchillas";
			System.out.println("Esta vez me mantendré sigiloso, cogeré mis " + armaSelec + ".");
			armaSelec = "tus dagas de nanocuchillas";
			;
		}

		System.out.println("- Te diriges a la sala del piloto donde está tu capitán.");
		System.out.println("");
		System.out.println("¡Hombre " + nombre + "! Estaba esperándote.");
		System.out.println(
				"Hoy tenemos un gran día por delante, han publicado una petición bastante jugosa en el foro de caza recompensas.");
		System.out.println(
				"Mientras nos lleva la nave te pongo al día. Tenemos que hallar el paradero de una nave militar que se a estrellado.");
		System.out.println(
				"Esa nave contiene un dispositivo de invisibilidad valorado por millones que estaba siendo transportado a la sede de la federación.");
		System.out.println(
				"Afortunadamente para nosotros, la nave ha tenido un accidente y la federación no ha conseguido localizarla aún para realizar el rescate.");
		System.out.println(
				"Pero como podrás ver, los caza recompensas lo hemos encontrado en cuestión de minutos como los buitres que somos.");
		System.out.println(
				"¡Anda! Ya hemos llegado. Ten cuidado, es muy probable que no seamos los únicos en intentar llevarnos el botín.");
		System.out.println("- La nave aterriza y os ponéis en marcha.");
		System.out.println("");
		System.out.println("Toma el radar, tu tienes mejor sentido de la orientación que yo.");
		System.out.println("- Ahora introduce \"izquierda\" o \"dereha\" (la que quieras) tres veces.");
		// Minijuego de encontrar el camino hasta el tesoro mediante el do while.
		// el usuario tendrá que escribir "izquierda" o "derecha" tres veces 
		// y avanzará independientemente de lo que escoja
		int contador = 3;
		do {
			String direccion = in.next();
			System.out.println("¡Vamor por la " + direccion + "!");
			contador--;
			// Uso del if para mandar un mensaje u otro en función del valor del contador
			if (contador == 2) {
				System.out.println("Nos estamos acercando. Sólo quedan " + contador + " pasos para llegar.");
			} else if (contador == 1) {
				System.out.println("Nos estamos acercando. Sólo queda " + contador + " paso para llegar.");
			} else {
				System.out.println("");
				System.out.println("¡Hemos llegado! Mira, ahí esta la nave, acerquémonos.");
			}
		} while (contador != 0);

		System.out.println("Cuidado " + nombre
				+ ", ahora debemos tener precaución, podría aparecer alguien en cualquier momento.");
		System.out.println(
				"- Ahora deberás tirar 2 dados, uno para determinar cuantos enemigos aparecen y otro para ver de cuantos te encargas.");

		// Uso del for para hacer un minijuego de tirar dos dados.
		// Es el bucle más compacto para lo que quiero realizar.

		int dado1enemigos = 0;
		int dado2encargarse = 0;
		Random numaleatorio = new Random();

		for (int contadorDados = 0; contadorDados != 2; contadorDados++) {
			System.out.print("Introduce \"t\" para tirar el dado: ");
			System.out.println("");
			String tirardado = in.next().toLowerCase();
			if (tirardado.equals("t") && contadorDados == 0) {
				dado1enemigos = numaleatorio.nextInt(6) + 1;
				System.out.println("Has sacado un " + dado1enemigos);
				System.out.println("Van a aparecer " + dado1enemigos + " enemigos");
				tirardado = "";
			} else if (tirardado.equals("t") && contadorDados == 1) {
				// Introducción de otro do-while para que saque numeros hasta que sea menor que
				// el primero valor
				do {
					dado2encargarse = numaleatorio.nextInt(6) + 1;
				} while (dado2encargarse > dado1enemigos);
				System.out.println("Has sacado un " + dado2encargarse);
				System.out.println("Te tendrás que encargar de " + dado2encargarse);
				tirardado = "";
			}
		}

		System.out.println("");
		System.out.println("¡Vamos a pelear!");
		System.out.println("- Ahora elige si atacar o defiender hasta acabar con los enemigos.");
		System.out.println("");

		// Uso del while para realizar el combate hasta que la condición sea falsa
		while (dado2encargarse > 0) {
			System.out.println("¿Atacar o Defnder?");
			String accionUser = in.next();

			if (accionUser.equalsIgnoreCase("atacar")) {
				// Si el usuario introduce atacar, mata a un enemigo,
				// por lo que disminuye el contador
				System.out.println("Atacas a un enemigo y acabas con el fulminantemente usando " + armaSelec + ".");
				dado2encargarse--;
				if (dado2encargarse > 0)
					System.out.println("Quedan " + dado2encargarse + " enemigos.");
			} else {
				System.out.println("Decides defenderte.");
				// Si el usuario introduce defender, pasa un turno sin contador
			}
		}
		System.out.println("- Despejáis la zona y os acercáis a la nave");
		System.out.println("");
		System.out.println("¡Corre a la nave y coge el tesoro antes de que venga alguien más!");
		System.out.println(
				"- No pierdes un minuto y abres la cabina de la nave estrllada donde yace el dispositivo que buscáis.");
		System.out.println(
				"- En tu cabeza debates por un segundo si coger el dispositivo e irte tu solo o seguir el plan e irte con el capitán");
		System.out.println("¿Vas a traicionar a tu capitán?");
		System.out.println("1. Si");
		System.out.println("2. No");
		int eleccionTraicion = in.nextInt();
		String valorDispoTexto = Integer.toString(valorDispositivo);
		// Última elección que hara el usuario con un if y un int que sea 1=Si, 2=No.
		if (eleccionTraicion == 1) {
			System.out.println("- Atacas a tu capitán y huyes con la nave. Ahora eres rico, pero estás podrido por dentro.");
			System.out.println(" Los " + valorDispoTexto + "€ no te van a quitar la culpabilidad que arrastrarás de por vida.");
			System.out.println("- ¿Estás contento?");
			System.out.println("FINAL MALO");
		} else {
			System.out.println("- Tu y tu capitán corréis de vuelta a la nave y abandonáis la zona.");
			System.out.println("Hemos conseguido escapar pero creo que las naves de la federación vienen a por nosotros.");
			System.out.println("Esto va a ser más complicado de lo que pensaba...");
			System.out.println("");
			System.out.println("¿Continuará?");
		}
		in.close();
	}
}
