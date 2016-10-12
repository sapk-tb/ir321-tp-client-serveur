
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * This class is a module which provides the application logic for an Echo
 * client using stream-mode socket.
 *
 * @author M. L. Liu
 */
public class EchoClientHelper2 {

    static final String endMessage = ".";
    private MyStreamSocket mySocket;
    private InetAddress serverHost;
    private int serverPort;

    EchoClientHelper2(String hostName,
            String portNum) throws SocketException,
            UnknownHostException, IOException {

        this.serverHost = InetAddress.getByName(hostName);
        this.serverPort = Integer.parseInt(portNum);
        //Instantiates a stream-mode socket and wait for a connection.
        this.mySocket = new MyStreamSocket(this.serverHost,
                this.serverPort);
        /**/ System.out.println("Connection request made");
    } // end constructor

    //TODO
    /*
    public String executeCMD(int id) throws SocketException,
            IOException {
        Scanner scanner = new Scanner(System.in);
        switch (id) {
            case 1:
                System.out.println("A = ");
                Integer a = Integer.parseInt(scanner.next());
                System.out.println("B = ");
                Integer b = Integer.parseInt(scanner.next());
                mySocket.sendMessage("ADD " + a + " " + b);
            case 2:
                System.out.println("A = ");
                Integer c = Integer.parseInt(scanner.next());
                System.out.println("B = ");
                Integer d = Integer.parseInt(scanner.next());
                mySocket.sendMessage("MUL " + c + " " + d);
        }
        //mySocket.sendMessage(message);
        // now receive the echo
        String result = mySocket.receiveMessage();
        return result;
    }
     */
    public String add(int a, int b) throws SocketException,
            IOException,
            Exception {
        return a + " + " + b + " = " + getResult("ADD " + a + " " + b);
    }

    public String mul(int a, int b) throws SocketException,
            IOException,
            Exception {
        return a + " * " + b + " = " + getResult("MUL " + a + " " + b);
    }

    public String div(int a, int b) throws SocketException,
            IOException,
            Exception {
        return a + " / " + b + " = " + getResult("DIV " + a + " " + b);
    }

    public String getResult(String req) throws Exception {
        mySocket.sendMessage(req);
        String result = mySocket.receiveMessage();
        if (result.startsWith("exception :")) {
            throw new Exception(result);
        } else {
            return result;
        }
    }

    public String getEcho(String message) throws SocketException,
            IOException {
        String echo = "";
        mySocket.sendMessage(message);
        // now receive the echo
        echo = mySocket.receiveMessage();
        return echo;
    } // end getEcho

    public void done() throws SocketException,
            IOException {
        mySocket.sendMessage(endMessage);
        mySocket.close();
    } // end done 
} //end class
