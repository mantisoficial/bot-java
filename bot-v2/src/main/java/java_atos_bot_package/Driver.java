package java_atos_bot_package;

import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		int timeSeconds = 36;

		BuscaPorNome buscaNomeCelg = new BuscaPorNome();
		BuscaPorNome buscaNomeConsorcio = new BuscaPorNome();
		BuscaPorNome buscaNomeLago = new BuscaPorNome();
		BuscaPorNome buscaNomePantanal = new BuscaPorNome();
		BuscaPorNome buscaNomeVale = new BuscaPorNome();
		BuscaPorNome buscaNomeFirminopolis = new BuscaPorNome();

		while (true) {

			buscaNomeCelg.buscarNome("Celg");
			buscaNomeConsorcio.buscarNome("Consórcio Corumbá");
			buscaNomeLago.buscarNome("Lago Azul");
			buscaNomePantanal.buscarNome("Pantanal Transmissão");
			buscaNomeVale.buscarNome("Vale do São Bartolomeu");
			buscaNomeFirminopolis.buscarNome("Firminópolis");

			
				try {
					Thread.sleep((timeSeconds * 1000));
				} catch (InterruptedException interruptedException) {
				}

		}
	}
}
