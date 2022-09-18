package view;

import java.util.concurrent.Semaphore;

import controller.PistaController;

public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		
		Semaphore Norte = new Semaphore(permissao);
		Semaphore Sul = new Semaphore(permissao);
		
		for (int i = 0; i < 12; i++) {
			PistaController aviao = new PistaController(Norte, Sul);
			aviao.start();
		}

	}

}
