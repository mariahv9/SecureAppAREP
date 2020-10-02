package edu.escuelaing.arep.HTTPSserver;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLReader {


    public static void configuration () {
        // Create a file and a password representation
        File trustStoreFile = new File("keyStores/myTrustStore");
        char[] trustStorePassword = "987654".toCharArray();
        // Load the trust store, the default type is "pkcs12", the alternative is "jks"
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        // Get the singleton instance of the TrustManagerFactory
        TrustManagerFactory tmf = null;
        try {
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Itit the TrustManagerFactory using the truststore object
        try {
            tmf.init(trustStore);
            //Set the default global SSLContext so all the connections will use it
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that does the connection and evaluation of url
     * @param sitetoread
     */
    public static String readURL(String sitetoread) {
        configuration();
        try {
            URL siteURL = new URL(sitetoread);
            URLConnection urlConnection = siteURL.openConnection();
            System.out.println("-------message-body------");
            InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);

            String inputLine = null;
            String url = "";
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                url += inputLine;
                return url;
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
        return "";
    }
}