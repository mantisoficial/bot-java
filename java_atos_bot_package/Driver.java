package java_atos_bot_package;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		int loopCounter = 10;
		int timeSeconds = 3600;

		JOptionPane.showMessageDialog(null,
				"O Bot vai ser iniciado. Configurado para " + loopCounter + " atualiza��o(�es) a cada " + timeSeconds
						+ " segundo(s).\nClique em OK ou feche a mensagem para continuar.");

		BuscaPorNome buscaNomeCelg = new BuscaPorNome();
		BuscaPorNome buscaNomeConsorcio = new BuscaPorNome();
		BuscaPorNome buscaNomeLago = new BuscaPorNome();
		BuscaPorNome buscaNomePantanal = new BuscaPorNome();
		BuscaPorNome buscaNomeVale = new BuscaPorNome();
		BuscaPorNome buscaNomeFirminopolis = new BuscaPorNome();

		while (loopCounter > 0) {

			buscaNomeCelg.buscarNome("");
			buscaNomeConsorcio.buscarNome("Cons�rcio Corumb�");
			buscaNomeLago.buscarNome("Lago Azul");
			buscaNomePantanal.buscarNome("Pantanal Transmiss�o");
			buscaNomeVale.buscarNome("Vale do S�o Bartolomeu");
			buscaNomeFirminopolis.buscarNome("Firmin�polis");

			if (loopCounter != 1) {
				try {
					Thread.sleep((timeSeconds * 1000));
				} catch (InterruptedException interruptedException) {
				}
			}

			loopCounter--;
		}
		JOptionPane.showMessageDialog(null,
				"Aplica��o finalizada com sucesso.\nClique em OK ou feche a mensagem para encerrar.");
	}
}
