package semaforoSO;

import java.util.*;
import java.lang.*;
import java.io.*;

class Filosofo implements Runnable {

	private int id;
	private int thinkingT;
	private int eatingT;
	private Mesa mesa;

	public Filosofo(int id, Mesa mesa) {
		this.id = id;
		this.mesa = mesa;

		Random gerador = new Random();
		this.thinkingT = gerador.nextInt(3000) + 1000;
		this.eatingT = gerador.nextInt(3000) + 1000;
		new Thread((Runnable) this, "Filosofo" + id).start();
	}

	@Override
	public void run() {
		while (true) {
			thinking();
			getFork();
			eating();
			returnFork();
		}
	}

	private void thinking() {
		try {
			System.out.println("Filosofo " + this.id + " esta pensando");
			Thread.sleep(this.thinkingT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void eating() {
		try {
			System.out.println("Filosofo " + this.id + " esta comendo");
			Thread.sleep(this.eatingT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void getFork() {
		System.out.println("Filosofo " + this.id + " vai tentar pegar os garfos");
		mesa.getFork(id);
	}

	private void returnFork() {
		System.out.println("Filosofo " + this.id + " vai tentar devolver os garfos");
		mesa.returnFork(id);
	}
}