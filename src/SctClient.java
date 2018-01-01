import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SctClient extends Thread {
	
	private static final int PORT = 2047;
	
	class NgrokThread implements Runnable {

		@Override
		public void run() {
			
			
		}
		
	}
	
	class StartServer implements Runnable {

		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(PORT);
				Socket socket = serverSocket.accept();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[]args) {
		String username = args[1];
		String choice = args[2];
		
		SctClient client = new SctClient();
		Thread ngrokThread = new Thread(client.new NgrokThread());
		Thread startServer = new Thread(client.new StartServer());
		
		ngrokThread.start();
		startServer.start();
		
		
	}
}
