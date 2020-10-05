package semaforoSO;

public class MesaMonitor extends Mesa {

	boolean[] forks;

	public MesaMonitor(int numbers) {
		super(numbers);

		forks = new boolean[numbers];
		for (int i = 0; i < numbers; i++) {
			forks[i] = true;
		}
	}

	@Override
	public synchronized void getFork(int filoId) {

		int leftForkId = leftFork(filoId);
		int rightForkId = rightFork(filoId);

		while (forks[leftForkId] == false || forks[rightForkId] == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		}

		forks[leftForkId] = false;
		forks[rightForkId] = false;
		System.out.println("Filosofo " + filoId + " conseguiu pegar os garfos com sucesso.");
	}

	@Override
	public synchronized void returnFork(int filoId) {

		int leftForkId = leftFork(filoId);
		int rightForkId = rightFork(filoId);
		forks[leftForkId] = true;
		forks[rightForkId] = true;
		System.out.println("Filosofo " + filoId + " conseguiu devolver os garfos com sucesso.");
		notifyAll();
	}

}
