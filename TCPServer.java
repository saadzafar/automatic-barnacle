import java.util.*;
import java.io.*;
import java.net.*;

public class TCPServer
{
	public static void main(String argv[]) throws Exception
	{
		int  Count = 0;
		//hashtable declaration
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		Enumeration names;
		char str;
		String name_number;
		
		String clientName;
		String capitalizedSentence;
		//hashtable
		table.put('A',1);
		table.put('I',1);
		table.put('J',1);
		table.put('Q',1);
		table.put('Y',1);
		table.put('B',2);
		table.put('K',2);
		table.put('R',2);
		table.put('C',3);
		table.put('G',3);
		table.put('L',3);
		table.put('S',3);
		table.put('D',4);
		table.put('M',4);
		table.put('T',4);
		table.put('H',5);
		table.put('E',5);
		table.put('N',5);
		table.put('X',5);
		table.put('U',6);
		table.put('V',6);
		table.put('W',6);
		table.put('O',7);
		table.put('Z',7);
		table.put('P',8);
		table.put('F',8);
		
		names = table.keys();
		
		while(names.hasMoreElements())
		{
			str = (char) names.nextElement();
			System.out.println(str + ": " + table.get(str));
		}
		System.out.println();
		
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true)
		{
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			//takes the input from the client and stores it inside clientName string
			clientName = inFromClient.readLine();
			
			//converts the clientName string to uppercase and stores it inside capitalizedSentence string
			capitalizedSentence = clientName.toUpperCase();
			
			//prints capitalizedSentence string
			System.out.println("FROM CLIENT: " + capitalizedSentence);
			
			//breaks the capitalizedSentence string into individual characters and stores them inside array nArray of type character  
			char[] nArray = capitalizedSentence.toCharArray();
			
			//compares the characters inside nArray with the hashtable and returns the associated keys if there is a match
			for (int a = 0; a < nArray.length; a++)
			{
				for (int b = 0; b < table.size(); b++)
				{
					if (table.containsKey(nArray[a]))
					{
						//sums the values of the returned keys and stores the sum inside Count variable
						Count += table.get(nArray[a]);
						break;
					}
				}
			}
			
			//stores the value of the Count variable inside name_number string 
			name_number = String.valueOf(Count);
			
			//prints the name_number string to screen
			System.out.println(name_number);
			
			name_number = name_number +'\n';
			
			//pushes the name_number string out to the client
			outToClient.writeBytes(name_number);
			
			//resets the value of the count to 0
			Count = 0;
		}
			
			
			
		}
			
	}
	
		
		