import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer {
    // make list of advices
    final private String[] adviceList ={
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat.",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut."
    };
    // make a Random obj.
    private final Random random = new Random();
    
    // MAIN Method
    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }

    // go method
    public void go(){
        // Make a ServerSocketChannel and open it
        /**
         * ServerSocketChannel makes this server application “listen” for 
         * client requests on the port it’s bound to.         
         * */
        try(ServerSocketChannel serverChannel = ServerSocketChannel.open()){
            // bind
            /**
             * You have to bind the ServerSocketChannel to 
             * the port you want to run the application on.
             */
            serverChannel.bind(new InetSocketAddress(5000));

            /**
             *  The server goes into a permanent loop,  
             * waiting for (and servicing) client requests.
             */
            while (serverChannel.isOpen()) {
                /**
                 * The accept method blocks (just sits there) *until* a request comes in,
                 * and then the method returns a SocketChannel for communicating with 
                 * the client.
                 */
                SocketChannel clientChannel = serverChannel.accept();
                
                // Create an output stream for the client’s channel, and 
                // wrap it in a PrintWriter.
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                
                String advice = getAdvice();
                // sent the client a String advice message
                writer.println(advice);
                // close writer, which will close client SocketChannel
                writer.close();
                // print in server console, so we can see what's happening
                System.out.println(advice);            
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    // return a random advice from the adviceList
    private String getAdvice(){
        int nextAdvice = random.nextInt(adviceList.length);
        return adviceList[nextAdvice];
    }

}

