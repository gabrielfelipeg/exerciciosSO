package semaforoSO;

public class Main {

	public static void main(String[] args) {

		int number = 5; // Quantidade de filosofos
		//Mesa mesa = new MesaSemaforo(number);
		Mesa mesa = new MesaMonitor(number);

		for (int i = 0; i < number; i++) {
			new Filosofo(i, mesa);
		}

	}

}