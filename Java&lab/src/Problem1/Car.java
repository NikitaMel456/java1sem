package Problem1;


public class Car extends  Thread {
    Parking park;
    int places=0;
    public Car(Parking park)
    {
        this.park=park;
    }
     public void run()
     {
         try
         {
             while (places<5){
                 places=places+park.Park();
                 System.out.println("Car parked"+" rest:"+(park.places-park.placeRest) );
                 sleep(20);
             }
         }
         catch(InterruptedException e)
         {
             System.out.println("Car parking thread interrupted.");
         }
     }


}
