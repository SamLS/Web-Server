import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * A Server that prints out a file
 * @author Samantha Sturges
 *
 */
public class WebServer
{
	public static void main(String[] args) throws IOException
	{
		final int PORT_NUMBER = 8080;
        ServerSocket server = new ServerSocket(PORT_NUMBER);

        while (true)
        {
			Socket socket = server.accept();
			WebService service = new WebService(socket);
			Thread t = new Thread(service);
			t.start();
		}
    }
}








