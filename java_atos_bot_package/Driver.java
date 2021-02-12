package java_atos_bot_package;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		int loopCounter = 10;
		int timeSeconds = 3600;

		JOptionPane.showMessageDialog(null,
				"O Bot vai ser iniciado. Configurado para " + loopCounter + " atualização(ões) a cada " + timeSeconds
						+ " segundo(s).\nClique em OK ou feche a mensagem para continuar.");

		BuscaPorNome buscaNomeCelg = new BuscaPorNome();
		BuscaPorNome buscaNomeConsorcio = new BuscaPorNome();
		BuscaPorNome buscaNomeLago = new BuscaPorNome();
		BuscaPorNome buscaNomePantanal = new BuscaPorNome();
		BuscaPorNome buscaNomeVale = new BuscaPorNome();
		BuscaPorNome buscaNomeFirminopolis = new BuscaPorNome();

		while (loopCounter > 0) {

			buscaNomeCelg.buscarNome("");
			buscaNomeConsorcio.buscarNome("Consórcio Corumbá");
			buscaNomeLago.buscarNome("Lago Azul");
			buscaNomePantanal.buscarNome("Pantanal Transmissão");
			buscaNomeVale.buscarNome("Vale do São Bartolomeu");
			buscaNomeFirminopolis.buscarNome("Firminópolis");

			if (loopCounter != 1) {
				try {
					Thread.sleep((timeSeconds * 1000));
				} catch (InterruptedException interruptedException) {
				}
			}

			loopCounter--;
		}
		JOptionPane.showMessageDialog(null,
				"Aplicação finalizada com sucesso.\nClique em OK ou feche a mensagem para encerrar.");
	}
}
