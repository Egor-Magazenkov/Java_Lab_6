package Lab_6.Parts.ClientSide;

import Lab_6.Collection.StudyGroup;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.ParseXML;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Socket socket = new Socket("localhost", 5000);

                System.out.println("Connected with Server...");
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(dout);
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                ObjectInputStream ois = new ObjectInputStream(dis);
                HashSet<StudyGroup> groups;
                String response;
                String command;
                while (true) {
                    command = sc.nextLine();
                    try {
                        oos.writeObject(command);
                    } catch (IOException e) {
                        System.out.println("error");
                    }

                    response = ois.readObject().toString();
                    System.out.println(response);

                }

            } catch (Exception e) {
                System.out.println("Проблемы с сервером. Стоит подождать или уточнить по телефону 02.");
                System.out.println("Ждать? (Yes/no)");
                String ans = sc.nextLine();
                if (ans.equals("") || ans.equalsIgnoreCase("yes")){
                    continue;
                }
                else {
                    break;
                }
            }
        }
    }
}