import java.util.ArrayList;
import java.util.Random;

public class Computation {
    private int id;
    private IProcess process;
    private int occupation;

    public Computation() {
    }

    public Computation(int computationId,IProcess process) {
        this.id=computationId;
        this.process = process;
        setOccupation(generateOccupationTime());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IProcess getProcess() {
        return process;
    }

    public void setProcess(IProcess process) {
        this.process = process;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }
    private int generateOccupationTime(){
        Random random=new Random();
        return random.nextInt(10)+1;
    }



    @Override
    public String toString() {
        return process.toString()+","+occupation+"ns";

    }
}
