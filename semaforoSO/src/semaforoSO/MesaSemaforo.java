package semaforoSO;

import java.util.concurrent.Semaphore;

public class MesaSemaforo extends Mesa {

	private Semaphore[] forks;

	public MesaSemaforo(int numbers) {    
		super(numbers);
		this.forks = new Semaphore[numbers];
		
		for(int i = 0; i < numbers; i++) {
			this.forks[i] = new Semaphore(1);
		}
	}
	
    @Override
	public void getFork(int filoId) {
		
		int leftForkId = leftFork(filoId);
		int rightForkId = rightFork(filoId);
		
        if(leftForkId > rightForkId){
        	int aux = rightForkId;
        	rightForkId = leftForkId;
        	leftForkId = aux;
        }
		try {
			forks[leftForkId].acquire();
            forks[rightForkId].acquire();
			System.out.println("Filosofo " + filoId + " conseguiu pegar os garfos com sucesso.");
		}catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
	}

    @Override
	public void returnFork(int filoId) {

		int leftForkId = leftFork(filoId);
		int rightForkId = rightFork(filoId);
		
        forks[leftForkId].release();
        forks[rightForkId].release();
		System.out.println("Filosofo " + filoId + " conseguiu devolver os garfos com sucesso.");
    }
	
}