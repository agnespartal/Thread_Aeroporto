package controller;

import java.util.concurrent.Semaphore;

public class PistaController extends Thread {

	private Semaphore pistaNorte;
	private Semaphore pistaSul;
	
	
	public PistaController(Semaphore pistaNorte, Semaphore pistaSul) {
		super();
		this.pistaNorte = pistaNorte;
		this.pistaSul = pistaSul;
	}


	@Override
	public void run() {
		decolar();
	}

	private void decolar() {
		int pista = (int)((Math.random()*2)+1);
		
		if (pista == 1) {
			try {
				pistaNorte.acquire();
				System.out.println("Aviao "+getId()+ " entrou na pista Norte");
				manobra();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				pistaNorte.release();
			}
		} else {
			try {
				pistaSul.acquire();
				System.out.println("Aviao "+getId()+ " entrou na pista sul");
				manobra();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				pistaSul.release();
			}
		}
		
	}

	private void manobra() {
		int tempo = (int)((Math.random()*4001)+3000);
		try {
			System.out.println("Aviao "+getId()+ " esta manobrando");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		taxiar();
	}


	private void taxiar() {
		int tempo = (int)((Math.random()*5001)+5000);
		try {
			System.out.println("Aviao "+getId()+ " esta taxiando");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		decolagem();
	}


	private void decolagem() {
		int tempo = (int)((Math.random()*3001)+1000);
		try {
			System.out.println("Aviao "+getId()+ " irá decolar");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		afastamentoArea();
	}


	private void afastamentoArea() {
		int tempo = (int)((Math.random()*5001)+3000);
		try {
			System.out.println("Aviao "+getId()+ " esta na fase de afastamento");
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
