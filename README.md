# automatic-barnacle
A demonstration of client-server communication using java sockets.
Created for my Data Communications and Security class.

# Usage
Open a terminal and navigate to the directory which has the files.
Run the Server:
```
TCPServer
```

Open another terminal.
Run the Client:
```
TCPClient
```

Type a string into the terminal running the client and the server should recieve it.
The server will then break up the passed string and compare each character to a hashtable and calculate a value and pass back to the client.
