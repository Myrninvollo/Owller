package org.owller.CubeWorld.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.owller.CubeWorld.Server.Network.CubeSocketCloseReason;
import org.owller.CubeWorld.Server.Network.CubeSocketManager;
import org.owller.CubeWorld.Server.Threads.CubeSocketServerThread;

public class CubeSocketServer {
    private static final int BACK_LOG = 100;
    
    private CubeServer server;
    private ServerSocket socketServer;
    private CubeSocketServerThread socketThread;
    private InetAddress bindAddress;
    private int port;
    
    private List<CubeSocketManager> sockets;
    
    public CubeSocketServer(CubeServer server, InetAddress bindAddress, int port) {
        this.server = server;
        this.bindAddress = bindAddress;
        this.port = port;
        this.sockets = new ArrayList<CubeSocketManager>();
        
        this.socketThread = new CubeSocketServerThread(this);
    }
    
    public CubeSocketServer(CubeServer server, int port) {
        this(server, null, port);
    }
    
    public CubeServer getServer() {return this.server;}
    public ServerSocket getSocketServer() {return this.socketServer;}
    
    public boolean stop() {try{tryStop();}catch(IOException e){return false;}return true;}
    public boolean start() {try {tryStart(); return true;} catch(IOException e) {return false;}}
    
    public void tryStop() throws IOException {
        for(CubeSocketManager socketManager : this.sockets) {
            if(socketManager == null) continue;
            socketManager.getThread().stopThread();
        }
        
        this.socketThread.stopThread();
        this.socketServer.close();
    }
    
    public void tryStart() throws IOException {
        if(this.bindAddress != null) this.socketServer = new ServerSocket(port, BACK_LOG, bindAddress);
        else this.socketServer = new ServerSocket(port, BACK_LOG);
        
        this.socketThread.startThread();
    }   

    public void handleSocket(Socket connection) {
        getServer().getLogger().debug(connection.getInetAddress().getHostAddress() + " pinged.");
        CubeSocketManager socket = new CubeSocketManager(connection, this);
        this.sockets.add(socket);
        socket.getThread().startThread();
    }

    public void closeConnection(CubeSocketManager manager, CubeSocketCloseReason reason) {
        if(manager.getThread() != null) manager.getThread().stopThread();
        try {manager.getSocket().close();} catch(Exception e) {}
        
        this.sockets.remove(manager);
        
        this.getServer().getLogger().info(manager.getIP() + " lost connection due to " + reason.getReason());
        
        manager = null;
    }
}
