package belstu.it.Melentev;
/**
 * Created by Никита on 10.02.2017.
 */
import java.util.Random;

import static java.lang.Math.*;
public class JavaTest {

    public static void main(String[] args) {

char ch='o';
int ints=10;
boolean logic=true;
short shoort=213;
byte byt=13;
long lon=445454999898444L;
double dob=1.46548833432423434216;
String str="Str";
System.out.println(str+ints);
        System.out.println("String+char="+(str+ch));
        System.out.println("String+double="+(str+dob));
        byte res= (byte) (byt+ints);
        int doblon= (int) (dob+lon);
        long intnum=ints+2147483647;
        System.out.println("int+2147483647="+intnum);
double sum=(byt+ch+dob)/2;
        boolean b;
        b = true&false;
        System.out.println("true&&false="+b);
        b=true^false;
        System.out.println("true^false="+b);

        System.out.println("str+ints="+str+ints);
char c='a';
char h='\u0061';
char a=97;
System.out.println("c+h+a="+(c+h+a));
char r= (char) (c+h+a);
System.out.println("c+h+a="+r);
        System.out.println("3.45%2.4="+(9.85%2.7));
        System.out.println("1.0/0.0="+1.0/0.0);
        System.out.println("log(-345)="+log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000)="+Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000)="+Float.intBitsToFloat(0xFF800000));

        final int S=100;
       class TryConst{

            public final int O=200;
            public static final int N=700;
        }

        System.out.println("PI="+PI+" E="+E);
        System.out.println(" round E="+round(E)+" round PI="+round(PI));
        System.out.println("min(E,PI)="+min(E,PI));


  int y=8;

        Boolean obj1=false;
            System.out.println("boolean obj1="+obj1);
        Float objfl=(float)1.1315;
            System.out.println("Float objfl="+objfl);
        Long objlon=(long)154654665;
            System.out.println("Long objlon="+(0+objlon));
        Character objch='f';
            System.out.println("Char objch="+objch);
        Integer objint=565412312;
            System.out.println("Int obgint="+objint);
        Byte objby=46;
            System.out.println("Byte objby="+objby);
        Double objdo=1.465544;
double dd=objdo+1.2154;

        System.out.println("Double objdo="+objdo);
        System.out.println("3 >>>objint="+(objint >>>3));
        System.out.println("true&false="+(true&false));
        System.out.println("true|false="+(true|false));
        System.out.println("Double maxval="+Double.MAX_VALUE);
        System.out.println("Long maxval="+Long.MAX_VALUE);
        String io=Integer.toHexString(23);
            System.out.println("Integer.toHexString(23)="+io);
        Integer oo=Integer.compare(34,35);
            System.out.println("Integer.compare(34,35)="+oo);
        String op=Integer.toString(1234);
            System.out.println("Integer.toString(1234)="+op);
       Integer pp= Integer.bitCount(12);
            System.out.println("Integer.bitCount(12)="+pp);
       Integer po= Integer.bitCount(13);
            System.out.println("Integer.bitCount(13)="+po);



        String s34="2345";
            System.out.println("s34="+s34);
        s34.split("4");
            System.out.println("s34.split(\"4\")="+s34.split("4",2).toString());
        s34.replace("5","2");
            System.out.println("s34.replace(\"5\",\"2\")="+s34.replace("5","2"));
        s34.length();
            System.out.println("s34.length()="+s34.length());
        s34.indexOf(3);
            System.out.println("s34.indexOf(3)="+s34.indexOf(3));
        String.valueOf(s34);
            System.out.println("String.valueOf(s34)="+String.valueOf(s34));
        Integer.parseInt(s34);
            System.out.println("Integer.parseInt(s34)="+Integer.parseInt(s34));
        System.out.println("value of="+Boolean.valueOf(s34));
        System.out.println( "getBoolean="+Boolean.getBoolean(s34));
        byte arr[]=s34.getBytes();
        System.out.println("Byte massive s34="+arr);



        String qq="qwe";
        String ww="qwe";
        System.out.println("str==str "+(qq==ww));
        System.out.println("str compare srt="+qq.compareTo(ww));
        System.out.println("equals="+qq.equals(ww));
        ww=null;
        System.out.println("after ww=null:");
        System.out.println("str==str "+(qq==ww));
        System.out.println("equals="+qq.equals(ww));

        char[][] c1;
        char []c2[];
        char c3[][];
            c2=new char[3][2];
            c3=new char[4][1];
            boolean crz= c2==c3;
        System.out.println("boolean crz= c2==c3 "+crz);
            c2=c3;
            boolean crqz=c2==c3;
        System.out.println("boolean crqz= c2==c3 "+crqz);
        System.out.println(c2[0].length);


    }
}
