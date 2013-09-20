package org.owller.CubeWorld.Server.Network;

import java.io.IOException;
import java.net.Socket;
import org.owller.CubeWorld.Server.CubeSocketServer;
import org.owller.CubeWorld.Server.Threads.CubeSocketThread;

public class CubeSocketManager {
    private Socket socket;
    private CubeSocketServer socketServer;
    private CubeSocketThread socketThread;
    
    private String clientVersion;
    private String ipAddress;
    private boolean isConnected;
    
    public CubeSocketManager(Socket socket, CubeSocketServer socketServer) {
        this.socket = socket;
        this.ipAddress = this.socket.getInetAddress().getHostAddress();
        this.isConnected = false;
        
        this.socketServer = socketServer;
        this.socketThread = new CubeSocketThread(this);
    }
    
    public Socket getSocket() {return this.socket;}
    public CubeSocketServer getServer() {return this.socketServer;}
    public CubeSocketThread getThread() {return this.socketThread;}
    public String getClientVersion() {return this.clientVersion;}
    public String getIP() {return this.ipAddress;}
    
    public boolean isConnnected() {return this.isConnected;}
    
    public void setVersion(byte[] v) {
        if(v.length < 5) return;
        this.clientVersion = Byte.toString(v[1]) + Byte.toString(v[2]) + "." + Byte.toString(v[3]) + Byte.toString(v[4]);
    }

    public void closeSocket(CubeSocketCloseReason reason) {
        try {
            this.socket.getInputStream().close();
            this.socket.getOutputStream().close();
        } catch(IOException e) {}
        this.getServer().closeConnection(this, reason);
    }
}
