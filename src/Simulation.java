import adt.LinkedPriorityQueue;

public class Simulation {
    private int simulationId;
    private LinkedPriorityQueue<Computation> computationLinkedPriorityQueue=new LinkedPriorityQueue<>();


    public Simulation(int simulationId) {
        this.simulationId = simulationId;
    }

    public int getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(int simulationId) {
        this.simulationId = simulationId;
    }

    public LinkedPriorityQueue<Computation> getComputationLinkedPriorityQueue() {
        return computationLinkedPriorityQueue;
    }

    public void setComputationLinkedPriorityQueue(LinkedPriorityQueue<Computation> computationLinkedPriorityQueue) {
        this.computationLinkedPriorityQueue = computationLinkedPriorityQueue;
    }
}
