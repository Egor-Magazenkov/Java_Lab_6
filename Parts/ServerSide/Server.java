package Lab_6.Parts.ServerSide;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.ServerResponseException;
import Lab_6.Utilities.Control;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

class Server {
    public static void main(String args[]) {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(5000);

                System.out.println("Waiting for Client...");

                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                ObjectInputStream ois = new ObjectInputStream(dis);
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                ObjectOutputStream oos = new ObjectOutputStream(dout);
                HashSet<StudyGroup> groups = new HashSet<>();
                Control control = new Control(groups);

                System.out.println("Client Connected...");
                String command;
                control.setOis(ois);
                control.setOos(oos);
                while (true) {
                    try {
                        command = ois.readObject().toString();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(command);

                    try {
                        control.processing(command);
                    } catch (ServerResponseException e) {
                        if (e.getStatus() != -1) {
                            oos.writeObject(e.getMessage());
                        }
                    }

                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}

