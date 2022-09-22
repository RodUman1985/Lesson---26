package com.company;

public abstract class Messenger extends  Thread {
    protected static final  Object syncObj = new Object();
     protected String name;
     private static String massage;

     public Messenger(String name){
         this.name = name;
     }

     public static void sendMessage (String msg){
         massage=msg;
         synchronized (syncObj) {
             syncObj.notifyAll();
         }
     }

    @Override
    public void run() {
       while (!this.isInterrupted()) {
           synchronized (syncObj) {
               try {
                   syncObj.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
           System.out.println(this.name+":"+ massage);
       }

     }
}
