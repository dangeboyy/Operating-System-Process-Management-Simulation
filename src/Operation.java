import java.util.Random;

public class Operation {


    public static void randomProcessGenerator(int numberOfProcess,Simulation simulation){
        Random random=new Random();
        for(int i=0;i<numberOfProcess;i++){
            int priority=random.nextInt(3) + 1;
            Process process = new Process(priority);
            Computation computation=new Computation(random.nextInt(1000),process);
            simulation.getComputationLinkedPriorityQueue().add(computation,priority);
        }
    }

}
