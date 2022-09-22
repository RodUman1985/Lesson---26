package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// синхронизация работы потоков
        Viber v=new Viber();
        Telegram t=new Telegram();
        v.start();
        t.start();
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Введите новое сообщение");
            String s=sc.next();
            Messenger.sendMessage(s);
        }

    }
}
