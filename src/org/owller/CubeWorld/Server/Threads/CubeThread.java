package org.owller.CubeWorld.Server.Threads;

public class CubeThread implements Runnable {
    private Thread thread;
    
    public CubeThread() {
        this.thread = new Thread(this);
    }
    
    public void startThread() {this.thread.start();}
    public void stopThread() {
        if(!this.isThreadRunning()) return;
        this.thread.interrupt();
    }
    
    public Thread getThread() {return this.thread;}
    
    public boolean isThreadRunning() {return this.thread.isAlive() && !this.thread.isInterrupted();}

    @Override
    public void run() {}
}
