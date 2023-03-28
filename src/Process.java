public class Process implements IProcess {
    private int priority;
    private String type;

    public Process() {
    }

    public Process(int priority) {
        this.priority = priority;
        if(priority==1){
            this.type ="High";
        }
        else if(priority==2){
            this.type="Normal";
        }
        else if(priority==3){
            this.type="Low";
        }
        else{
            System.out.println("Unexpected priority");
        }

    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return type;


    }

}
