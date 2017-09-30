package belstu.it.Melentev;

/**
 * Created by Никита on 10.02.2017.
 */


public class wrapperstring {
    private String st;

    public wrapperstring(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof wrapperstring)) return false;

        wrapperstring that = (wrapperstring) o;

        return getSt() != null ? getSt().equals(that.getSt()) : that.getSt() == null;
    }

    @Override
    public int hashCode() {
        return getSt() != null ? getSt().hashCode() : 0;
    }

    @Override
    public String toString() {

        return "wrapperstring{" +
                "st='" + st + '\'' +
                '}';
    }
    public void replace(char oldchar,char newchar)
    {
    String nc="quanta";
    String l=nc.replace(oldchar, newchar);
    System.out.println(l);
    }
    public void delete(char newchar)
    {}
}
class Anon
{
    public static void main(String[] args) {
        String ob="qwerty";
        wrapperstring anonobj1=new wrapperstring(ob)
        {
            @Override
public void replace(char oldchar, char newchar)
{
    newchar='w';
String lob=ob.replace(oldchar,newchar);
System.out.println(lob);
}
        };
        wrapperstring anonobj2=new wrapperstring(ob)
        {
            @Override
           public void delete(char newchar)
           {

             String k= ob.substring(0,ob.indexOf(newchar));
              String c= ob.substring(ob.indexOf(newchar)+1);
              String ob=k.concat(c);
              System.out.println(ob);
           }
        };
        anonobj1.replace('q','Z');
        anonobj2.replace('q','v');
        anonobj2.delete('r');
    }
}

