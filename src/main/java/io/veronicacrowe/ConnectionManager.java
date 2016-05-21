package io.veronicacrowe;


/**
 * Created by veronicacrowe on 5/19/16.
 */
public class ConnectionManager {
    private int counter;
    private int counterLimit;

    public ConnectionManager(int counterLimit){
        this.counterLimit = counterLimit;
        this.counter = 0;
    }
    public ManagedConnection requestConnection(String ipAddress, int port, String protocol){
        ManagedConnection managedConnection = null;
        if (counter < counterLimit){
            managedConnection = new ManagedConnection(ipAddress, port, protocol);
            counter++;
        }
        return managedConnection;
    }

    public int getCounter(){
        return counter;
    }

    private class ManagedConnection implements Connection {

        String ipAddress;
        int port;
        String protocol;

        public ManagedConnection(String ipAddress, int port, String protocol){
            this.ipAddress = ipAddress;
            this.port = port;
            this.protocol = protocol;

        }

        public String getIP() {
            return ipAddress;
        }

        public int getPort() {
            return port;
        }

        public String getProtocol() {
            return protocol;
        }

        public void close() {
            ConnectionManager.this.counter -= 1;
        }

    }
}
