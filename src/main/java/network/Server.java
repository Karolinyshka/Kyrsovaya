package network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class Server implements Runnable {

    private static final String FILE = "client.txt";
    private Socket factSocket;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private static String currentUser;


    private String messServ=null;
    Server(Socket socket) throws IOException {
        factSocket = socket;
        try {
            inStream = new ObjectInputStream(factSocket.getInputStream());
            outStream = new ObjectOutputStream(factSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String doing = getAddress() + "\t" + "on" + "\t" + new java.util.Date().toString();
        System.out.println(doing);
        writeInFile(doing);
    }

    public void close() {
        try {
            outStream.flush();
            inStream.close();
            outStream.close();
            factSocket.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    private String readMessage() {
        try {
            messServ = (String) inStream.readObject();
        } catch (Exception e) {
            System.err.println("Клиент отключился");

        }
        return messServ;
    }

    private void sendMessage(String messServ) {
        try {
            outStream.flush();
            outStream.writeObject(messServ);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Object readObject() {
        Object object = null;
        try {
            object = inStream.readObject();
        } catch (Exception e ) {
            System.out.println("Нет данных в потоке");
            //e.printStackTrace();
        }

        return object;
    }



    private void sendObject(Object object) {
        try {
            outStream.flush();
            outStream.writeObject(object);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }


    private String getAddress() {
        return factSocket.getInetAddress().toString();
    }

    private void writeInFile(String doing) throws IOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE, true)))) {

            pw.println(doing);

        }
    }


    private void disconnect() {
        try {
            if (outStream != null) {
                outStream.close();
            }
            if (inStream != null) {
                inStream.close();
            }
            System.out.println(factSocket.getInetAddress() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    @Override
    public void run() {

    }
}
