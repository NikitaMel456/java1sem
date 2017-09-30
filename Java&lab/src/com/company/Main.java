package com.company;

import Problem1.Car;
import Problem1.CarLeave;
import Problem1.Parking;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parking park=new Parking();
        new Car(park).start();
        new CarLeave(park).start();

//for Call Center problem
//        LinkedList<PhoneCall> list=new LinkedList<PhoneCall>(){
//
//            { this.add(new PhoneCall(1));
//            this.add(new PhoneCall(2));
//            this.add(new PhoneCall(3));}
//        };
//        CallCenter<PhoneCall> pool=new CallCenter<>(list);
//        for (int i=0;i<10;i++){
//            new Caller(pool).start();
//        }
    }
}
