import java.io.BufferedReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

class DailyAdviceClient{
    public void go(){
        // create a Server
        InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1",5000);
        // create a Socket Channel in try-with-resource
        try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {
            // make a Reader that reads the message(bytes) sent via Socket channel
            /**
             * Reader helps in coverting the low-level message to high-level 
             * message i.e. bytes to characters.
             */
            
            Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);

            // make a BufferedReader using the above Reader object to read
            // the String message.
             BufferedReader reader = new BufferedReader(channelReader);

             // read the line(String) 
            String advice = reader.readLine();
            System.out.println("Today you should: "+advice);

            // close the channelReader and this BufferedReader
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        // create a DailyAdviceClient object and invoke go()
        new DailyAdviceClient().go();
    }
}