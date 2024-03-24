package view;

import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

import controller.CavaleiroController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Olá, informe o Exercicio que gostaria de ver:"
					+ "\n1 - Quatro Cavaleiros e Corredor\n" + "2 - Aeroporto\n" +"9 - Sair" ));

			switch (opc) {
			case 1:
				int porta = Integer.parseInt(JOptionPane.showInputDialog(
						"Informe um número entre 1 a 4, " + "está seria a porta da saída do corredor"));
				if (porta < 1 || porta > 4) {
					JOptionPane.showMessageDialog(null, "Número da porta deve ser entre 1 a 4, tente novamente!");
					break;
				}

				JOptionPane.showMessageDialog(null, "O resultado será mostrado no terminal");
				for (int i = 1; i <= 4; i++) {
					CavaleiroController cav = new CavaleiroController(i, porta, semaforo);
					cav.start();
				}

				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Exercício ainda em construção!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Saindo...");
				break;
			}

		}

	}

}
