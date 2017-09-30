package Problem1;

public class Parking {
  public   int placeRest = 0;
   public  int places = 5;




   public synchronized int Park() {
        if (placeRest < places) {
            placeRest++;
            System.out.println((places - placeRest) + " places rest");
            return 1;
        }
        return 0;
    }

   public synchronized int Away()
    {
        if(placeRest >0)
        {
            placeRest--;
            System.out.println((places - placeRest) + "places rest");
        return  1;
        }
        return 0;
    }


}
