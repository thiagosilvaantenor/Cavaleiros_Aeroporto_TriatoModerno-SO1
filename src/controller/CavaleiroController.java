package controller;

import java.util.concurrent.Semaphore;

public class CavaleiroController extends Thread {

	private Semaphore semaforo;
	private int idCavaleiro;
	private int velocidadeCavaleiro = (int) (Math.random() * (4 + 1)) + 2;
	private double distanciaPercorrida;
	private static int tocha, pedraBrilhante;
	private final double distanciaCorredor = 2000.0;
	private int portaEscolhida;
	private static int[] portas = new int[4];

	public CavaleiroController(int idCavaleiro, int portaEscolhida, Semaphore semaforo) {
		this.idCavaleiro = idCavaleiro;
		this.portaEscolhida = portaEscolhida;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {

		while (distanciaPercorrida < distanciaCorredor) {
			caminhar();

			if (distanciaPercorrida == 500 && tocha == 0) {
				pegaTocha();
			}
			if (distanciaPercorrida == 1500 && pedraBrilhante == 0) {
				pegaPedraBrilhante();
			}
		}
		portaRandomica();
	}

	private void caminhar() {
		distanciaPercorrida += velocidadeCavaleiro;
		try {
			sleep(50);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

		System.out.println(
				"Cavaleiro #" + idCavaleiro + " andou por " + distanciaPercorrida + 
				" metros de " + distanciaCorredor);

	}

	private void pegaPedraBrilhante() {
		try {
			semaforo.acquire();
			System.out.println("O cavaleiro #" + idCavaleiro + " pegou a pedraBrilhante");
			velocidadeCavaleiro += 2.0;
			pedraBrilhante = idCavaleiro;
			sleep(50);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}

	}

	private void pegaTocha() {

		try {
			semaforo.acquire();
			velocidadeCavaleiro += 2.0;
			System.out.println("O cavaleiro #" + idCavaleiro + " pegou a tocha!");
			sleep(50);
			tocha = idCavaleiro;
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}

	}

	private void portaRandomica() {
		int escolha = 0;
		try {
			semaforo.acquire();
			System.out.println("4 portas aparecem!");
			// escolha = 1 |-|	 4
			escolha = (int) ((Math.random() * 4) + 1);
			while (portas[escolha - 1] != 0) {
				escolha = (int) ((Math.random() * 4) + 1);
			}
			System.out.println("O cavaleiro #" + idCavaleiro + " escolheu a porta: " + escolha);
			portas[escolha - 1] = idCavaleiro;
			if (escolha != portaEscolhida) {
				System.out.println("Infelizmente o cavaleiro #" + idCavaleiro + " virou a janta de um monstro!");
			} else {
				System.out.println("O cavaleiro #" + idCavaleiro + " chegou na saída");
			}

		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}
}
