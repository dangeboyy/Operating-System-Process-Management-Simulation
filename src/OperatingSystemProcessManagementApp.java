import adt.ArrayList;
import adt.LinkedList;

public class OperatingSystemProcessManagementApp {

    public static void main(String[] args) {
        LinkedList<Simulation> simulations=new LinkedList<>();


        Simulation simulation1=new Simulation(1);
        Simulation simulation2=new Simulation(2);
        Simulation simulation3=new Simulation(3);

        Operation.randomProcessGenerator(3,simulation1);
        Operation.randomProcessGenerator(5,simulation2);
        Operation.randomProcessGenerator(10,simulation3);

        simulations.add(simulation1);
        simulations.add(simulation2);
        simulations.add(simulation3);



       for(int i=1;i<simulations.getNumberOfEntries()+1;i++){
           int highCompNum=0; //number of high priorities
           int normalCompNum=0;
           int lowCompNum=0;

           int highWaiting=0;
           int normalWaiting=0;
           int lowWaiting=0;


           int totalWaitingTime=0;
           ArrayList<Computation> computations=new ArrayList<>(true);
           System.out.println("Simulation Number"+i);
           Simulation simulation=simulations.getDataAt(i);
           int simQueueSize=simulation.getComputationLinkedPriorityQueue().getSize();
           System.out.println("Computation Queue: ");

           for(int k=0;k<simQueueSize;k++){
               Computation computation=simulation.getComputationLinkedPriorityQueue().remove();
               computations.add(computation);
               System.out.print("P"+(k+1)+","+computation.toString()+"<--");//k+1 is the process id that is like P1
               if(computation.getProcess().getPriority()==1){
                   highCompNum++;
               }
               else if(computation.getProcess().getPriority()==2){
                   normalCompNum++;
               }
               else if(computation.getProcess().getPriority()==3){
                   lowCompNum++;
               }
               else{
                   System.out.println("Invalid priority");
               }
               if (k+1!=simQueueSize){
                   totalWaitingTime+=computation.getOccupation();
               }
           }
           System.out.println("\nTotal Number of Computations:"+simQueueSize);
           System.out.println();
           System.out.println("Total waiting time:"+totalWaitingTime+"ns");
           System.out.println("Avarage waiting time:"+ ((float)totalWaitingTime)/simQueueSize+"ns");

           System.out.println("Total number of computations for High:"+highCompNum);
           System.out.println("Total number of computations for Normal:"+normalCompNum);
           System.out.println("Total number of computations for Low:"+lowCompNum);


           for(int j=1;j<computations.getLength();j++){//for calculating the witing time
               int consecutiveFirst=computations.getEntry(j).getProcess().getPriority();
               int consecutiveSecond=computations.getEntry(j+1).getProcess().getPriority();
               int occupationFirst=computations.getEntry(j).getOccupation();
                   if(consecutiveFirst==1){
                       if(consecutiveFirst==consecutiveSecond){
                           highWaiting+=occupationFirst;
                       }
                       else{
                           if(consecutiveSecond==2){
                               normalWaiting+=highWaiting+occupationFirst;
                           }
                           else{
                               lowWaiting+=normalWaiting+occupationFirst;
                           }
                       }
                   }
                   else if(consecutiveFirst==2){
                       if(consecutiveFirst==consecutiveSecond){
                           normalWaiting+=occupationFirst;
                       }
                       else{
                           lowWaiting+=normalWaiting+occupationFirst;
                       }
                   }
                   else{
                       lowWaiting+=occupationFirst;
                   }

           }
           if(highCompNum>0){
               System.out.println("Total waiting time for High:"+highWaiting+"ns");
               System.out.println("Average waiting time for High:"+((float)highWaiting/highCompNum)+"ns");
           }
           if(normalCompNum>0){
               System.out.println("Total waiting time for Normal:"+(normalWaiting)+"ns");
               System.out.println("Average waiting time for Normal:"+((float)normalWaiting)/normalCompNum+"ns");
           }
           if(lowCompNum>0){
               System.out.println("Total waiting time for Low:"+(lowWaiting)+"ns");
               System.out.println("Average waiting time for Low:"+(((float)lowWaiting)/lowCompNum)+"ns");
           }

       }











    }



}
