package taursus.remoteControlServer;

import com.remoteControl.ILogger;
import com.remoteControl.Transporter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Transporter {
    protected ServerSocket socket = null;
    protected Socket clientSocket = null;
    protected int port = 4000;

    public Server(ILogger logger) {
        super(logger);
    }

    public Server setPort(int port) {
        this.port = port;
        return this;
    }

    public int getPort() {
        return this.port;
    }

    public void run() {
        try {
            this.socket = new ServerSocket(this.port);
            waitForClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void waitForClient() {
        this.logger.log("Server", "waiting for client");

        try {
            this.clientSocket = this.socket.accept();
            this.input = this.clientSocket.getInputStream();
            this.output = this.clientSocket.getOutputStream();
            onConnected();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void disconnect() {
        super.disconnect();

        if (this.isConnected) {
            try {
                this.clientSocket.close();
                this.clientSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        waitForClient();
    }

    public void close() {
        super.close();

        try {
            this.socket.close();
            this.socket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
