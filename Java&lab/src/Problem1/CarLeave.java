package Problem1;


public class CarLeave extends  Thread{
    Parking park;
    int placesall=5;
    public CarLeave(Parking park)
    {
        this.park=park;
    }
    public void run()
    {
        try {
                while (placesall > 0 ) {
                    placesall = placesall - park.Away();
                    System.out.println("Car leave it's place,"+" rest:"+(park.places-park.placeRest));
                    sleep(65);
                }
        }
        catch (InterruptedException e)
        {
            System.out.println("Car leaving thread interupted");
        }
    }
}
