package Problem2;

import java.util.Random;

public class PhoneCall {
private int connectId;
public PhoneCall(int id)
{
    super();
    this.connectId=id;
}
public int getConnectId()
{
    return connectId;
}
public void setConnectId(int id){this.connectId=id;}
public void using()
{
    try{
        Thread.sleep(new Random().nextInt(300));
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
}
}


