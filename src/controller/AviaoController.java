package controller;

import java.util.concurrent.Semaphore;

public class AviaoController extends Thread {
	private String pistaAeroporto;
	private int aviaoId;
	private Semaphore semaforo;
	
	public AviaoController(String pistaAeroporto, int aviaoId, Semaphore semaforo) {
		this.pistaAeroporto = pistaAeroporto;
		this.aviaoId = aviaoId;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		//4 fases de decolagem (taxiar, decolagem e afastamento da área).
		try {
			semaforo.acquire();
			manobrar();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}finally {
			semaforo.release();			
		}
	}

	private void manobrar() {
		//300 a 700 milisegundos
		taxiar();
	}
	private void taxiar() {
		//500 a 1000 milisegundos
		decolagem();
		afastamentoDaArea();
	}

	private void afastamentoDaArea() {
		//600 a 800 milisegundos
	}

	private void decolagem() {
		//300 a 800 milisegundos
	}
	
	
	
	

}
