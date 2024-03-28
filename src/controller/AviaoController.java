package controller;

import java.util.concurrent.Semaphore;

public class AviaoController extends Thread {
	private int pistaAeroporto;
	private int aviaoId;
	private Semaphore semaforoN, semaforoS;
	
	public AviaoController(int pistaAeroporto, int aviaoId, Semaphore semaforoN, Semaphore semaforoS) {
		this.pistaAeroporto = pistaAeroporto;
		this.aviaoId = aviaoId;
		this.semaforoN = semaforoN;
		this.semaforoS = semaforoS;
	}
	
	@Override
	public void run() {
		//4 fases de decolagem (taxiar, decolagem e afastamento da área).
		verificaPista();
	}
	
	private void verificaPista() {
		switch(this.pistaAeroporto) {
		// pistaAeroporto 1 = norte || pistaAeroporto 2 = sul
		case 1:
			try {
				semaforoN.acquire();
				System.out.println("O aviao #" + this.aviaoId + " iniciou os processos para "
						+ "decolagem na pista norte!");
				String pista = "norte";
				manobrar(pista);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}finally {
				semaforoN.release();			
			}
			
			break;
		case 2:
			try {
				semaforoS.acquire();
				System.out.println("O aviao #" + this.aviaoId + " iniciou os processos para "
						+ "decolagem na pista sul!");
				String pista = "sul";
				manobrar(pista);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}finally {
				semaforoN.release();			
			}
			break;
			
		default: System.err.println("Pista do aeroporto inexistente!");
			break;
		}
	}

	private void manobrar(String pista) {
		//300 a 700 milisegundos
		System.out.println("O aviao #" + this.aviaoId +" está na fase de manobra na pista " 
				+ pista);
		try {
			sleep((int)(Math.random() * 701)+300);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		taxiar(pista);
	}
	private void taxiar(String pista) {
		//500 a 1000 milisegundos
		
		System.out.println("O aviao #" + this.aviaoId +" está na fase de taxiar na pista "
				+ pista);
		try {
			sleep((int)(Math.random() * 1001)+500);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		decolagem(pista);
		
	}

	private void decolagem(String pista) {
		//300 a 800 milisegundos
		System.out.println("O aviao #" + this.aviaoId +" está na fase de decolagem na pista "
				+ pista);
		try {
			sleep((int)(Math.random() * 801)+300);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		afastamentoDaArea(pista);
	}

	private void afastamentoDaArea(String pista) {
		//600 a 800 milisegundos
		System.out.println("O aviao #" + this.aviaoId +" está na fase de afastamento da area na pista "
				+ pista);
		try {
			sleep((int)(Math.random() * 801)+600);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("O aviao #" + this.aviaoId + " decolou da pista " + pista);
	}

	
	
	
	

}
