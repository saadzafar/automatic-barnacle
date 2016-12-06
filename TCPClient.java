import java.io.*;
import java.net.*;

class TCPClient
{
	public static void main (String argv[]) throws Exception
	{
		
		String sentence;
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader (System.in));
		
		Socket clientSocket = new Socket("127.0.0.1" , 6789);
		
		System.out.println("Connected to Server @ 127.0.0.1");
		
		DataOutputStream outToServer = new DataOutputStream ((clientSocket.getOutputStream()));
		
		BufferedReader inFromServer = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
		
		System.out.println("CLIENT: ");
		//takes the input from the user and stores it inside sentence string
		sentence = inFromUser.readLine();
		
		System.out.println("Processing your input...");
		
		//pushes the sentence string out to the server
		outToServer.writeBytes(sentence + '\n');
		
		//stores the server's response inside modifiedSentence string
		modifiedSentence = inFromServer.readLine();
		
		//prints out the server's response on the client's screen
		System.out.println("FROM SERVER: " + modifiedSentence);
		
		//closes the connection to the server
		clientSocket.close();
		
	}
	
}