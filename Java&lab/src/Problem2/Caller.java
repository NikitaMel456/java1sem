package Problem2;

public class Caller extends Thread {
    private  boolean reading =false;
    private CallCenter<PhoneCall> pool;
    public Caller(CallCenter<PhoneCall> pool)
    {
        this.pool=pool;
    }
    public void run()
    {
        PhoneCall call=null;
        try{
            call=pool.getResourc(300);
            reading=true;
            System.out.println("Phone call Client "+this.getId());
            call.using();
        }
        catch (Exception e)
        {
            System.out.println("Client "+this.getId()+" abort: "+e.getMessage());

        }
        finally{
            if(call !=null){
                reading=false;
                System.out.println("Phone call Client "+this.getId()+" ends his call");
                pool.returnResource(call);
            }
        }
    }
    public boolean isReading(){return reading;}
}
