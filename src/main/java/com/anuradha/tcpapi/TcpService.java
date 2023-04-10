package com.anuradha.tcpapi;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import javax.net.SocketFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

@Service
public class TcpService {

    public String sendAndReceiveXml(String host, int port, String requestXml) throws Exception {
        // create TCP socket
        Socket socket = SocketFactory.getDefault().createSocket(host, port);

        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            // send request XML
            out.write(requestXml.getBytes());
            out.flush();

            // receive response XML
            String responseXml = StreamUtils.copyToString(in, Charset.defaultCharset());

            // close the socket
            socket.close();

            return responseXml;
        }
    }
}
