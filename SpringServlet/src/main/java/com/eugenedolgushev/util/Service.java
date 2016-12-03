package com.eugenedolgushev.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.logging.Logger;

public class Service {

    private static final String URL = "http://example.com";
    private static Logger log = Logger.getLogger(Service.class.getName());

    public static String readPage() {
        URLConnection connection = null;
        String content = "";
        try {
            connection = new URL(URL).openConnection();
            connection.connect();
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line);
            }
            content = sb.toString();
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
        return content;
    }
}
