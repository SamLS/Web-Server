import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebService implements Runnable
{
   /**
      Constructs a service object that processes commands
      from a socket for a bank.
      @param aSocket the socket
   */
   public WebService(Socket aSocket)
   {
      s = aSocket;
   }

   public void run()
   {
      try
      {
         try
         {
            in = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream());
            executeCommand();
         }
         finally
         {
            s.close();
         }
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
      Executes a single command.
   */
   public void executeCommand()
   {
      String command = "GET " + "/" + " HTTP/1.0\n\n";
      out.print(command);
      out.flush();

      while (in.hasNextLine())
      {
		  String input = in.nextLine();
		  out.println(input);
		}
   }

   private Socket s;
   private Scanner in;
   private PrintWriter out;
}
