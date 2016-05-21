package io.veronicacrowe;


/**
 * Created by veronicacrowe on 5/19/16.
 */
public interface Connection {

    String getIP();
    int getPort();
    String getProtocol();
    void close();

}
