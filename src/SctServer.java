import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SctServer {
	
	private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    
    public static void main(String[]args) {
    		ProcessBuilder pb = new ProcessBuilder("./ngrok", "tcp", "2047");
    		try {
				Process p = pb.start();
				DataInputStream dis = new DataInputStream(p.getInputStream());
				new Thread(new Runnable() {

					@Override
					public void run() {
						while(true) {
							System.out.println("Hello World!");
							try {
								
								System.out.println("Echo Output:\n" + dis.readByte());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}).start();
			
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							p.waitFor();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /*catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    		
    }
    private static String output(InputStream inputStream) throws IOException {
    	
    		        StringBuilder sb = new StringBuilder();
    	
    		        BufferedReader br = null;
    	
    		        try {
    	
    		            br = new BufferedReader(new InputStreamReader(inputStream));
    	
    		            String line = null;
    	
    		            while ((line = br.readLine()) != null) {
    
    		                sb.append(line + System.getProperty("line.separator"));
    	
    		            }
    	
    		        } finally {
    	
    		            br.close();
    	
    		        }
    	
    		        return sb.toString();
    	
    		    }
    
	/*public static void main(String[] args) {
		try {
			
			
	String name = args[1];
			ServerSocket serverSocket = new ServerSocket(2407);
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
                    .getConnection("jdbc:mysql://db4free.net/uname2ngrok?user=eclair42&password=aadmin");
			
			String host;
			int port;
			
			name = "Pranab";
            host = "0.gsdjg.ngrok.io";
            port = 10978;
            
            String query = "insert into uname values (?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, host);
            preparedStatement.setInt(3, port);
            
            preparedStatement.execute();
            
            statement = connect.createStatement();
			resultSet = statement
                    .executeQuery("select * from uname");
			
			while (resultSet.next()) {
	           
				name = resultSet.getString("name");
	            host = resultSet.getString("host");
	            port = resultSet.getInt("port");
	            
	            System.out.println("Name : " + name);
	            System.out.println("Host : " + host);
	            System.out.println("Port : " + port);
	            
	            System.out.println();
	            
	        }

			
			
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String data = dataInputStream.readUTF();
			
			
						

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {

	        }
		}
		
    }*/
}
