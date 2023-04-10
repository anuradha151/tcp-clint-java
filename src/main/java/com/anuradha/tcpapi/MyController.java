package com.anuradha.tcpapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private TcpService tcpService;

    @PostMapping("/send-xml")
    public String sendXml(@RequestBody String requestXml) throws Exception {
        logger.info("req : {}", requestXml);
        String host = "localhost";
        int port = 1234;
        String responseXml = tcpService.sendAndReceiveXml(host, port, requestXml);
        logger.info("res : {}", responseXml);
        return responseXml;
    }
}
