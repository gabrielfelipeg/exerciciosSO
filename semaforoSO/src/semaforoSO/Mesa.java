package semaforoSO;

public abstract class Mesa {

	private int numbers;

	public Mesa(int numbers) {
		this.numbers = numbers;
	}

	public int leftFork(int id) {
		return id;
	}

	public int rightFork(int id) {
		return (id + 1) % this.numbers;
	}

	public void getFork(int id) {
	}

	public void returnFork(int id) {
	}

	public int getNumbers() {
		return this.numbers;
	}

}