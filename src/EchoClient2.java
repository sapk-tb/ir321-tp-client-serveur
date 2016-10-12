
import java.io.*;

/**
 * This module contains the presentaton logic of an Echo Client.
 *
 * @author M. L. Liu
 */
public class EchoClient2 {

    static final String endMessage = ".";

    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            System.out.println("Welcome to the Echo client.\n"
                    + "What is the name of the server host?");
            String hostName = br.readLine();
            if (hostName.length() == 0) // if user did not enter a name
            {
                hostName = "localhost";  //   use the default host name
            }
            System.out.println("What is the port number of the server host?");
            String portNum = br.readLine();
            if (portNum.length() == 0) {
                portNum = "7";          // default port number
            }
            EchoClientHelper2 helper
                    = new EchoClientHelper2(hostName, portNum);
            System.out.println(helper.add(1, 2));
            System.out.println(helper.mul(2,5));
            System.out.println(helper.div(2,5));
            System.out.println(helper.div(2,0));
            System.out.println(helper.div(2,1));
            /*
         boolean done = false;
         String message, echo;
         while (!done) {
            System.out.println("Enter a line to receive an echo "
               + "from the server, or a single period to quit.");
            message = br.readLine( );
            if ((message.trim()).equals (endMessage)){
               done = true;
               helper.done( );
            }
            else {
               echo = helper.getEcho( message);
               System.out.println(echo);
            }
          } // end while
             */
            
            helper.done( );
        } // end try  
        catch (Exception ex) {
            ex.printStackTrace();
        } //end catch
    } //end main
} // end class
