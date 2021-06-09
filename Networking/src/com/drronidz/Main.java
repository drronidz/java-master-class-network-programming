package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/9/2021 , 
    CREATED ON : 3:53 PM
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if(responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line ;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("--------key = " + key);
//                for (String string: value) {
//                    System.out.println("value = " + value);
//                }
//            }

//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }

//            inputStream.close();
//            URI uri = url.toURI();

//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());


//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI baseURI = new URI("http://username:password@mynewserver.com:5000");
//            URI uriOne = new URI("/catalogue/phones?os=android#samsung");
//            URI uriTwo = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uriThree = new URI("/stores/locations?zip=12345");
//
//            URI resolvedURIOne = baseURI.resolve(uriOne);
//            URI resolvedURITwo = baseURI.resolve(uriTwo);
//            URI resolvedURIThree = baseURI.resolve(uriThree);
//
//
//            URL urlOne = resolvedURIOne.toURL();
//            System.out.println("URL = " + urlOne);
//
//            URL urlTwo = resolvedURITwo.toURL();
//            System.out.println("URL = " + urlTwo);
//
//            URL urlThree = resolvedURIThree.toURL();
//            System.out.println("URL = " + urlThree);
//
//            URI relativizedURI = baseURI.relativize(resolvedURITwo);
//            System.out.println("Relative URI = " + relativizedURI);
//
//
////            URI uri = new URI("hello");
//
////            System.out.println("Scheme = " + uri.getScheme());
////            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
////            System.out.println("Authority = " + uri.getAuthority());
////            System.out.println("User info = " + uri.getUserInfo());
////            System.out.println("Host = " + uri.getHost());
////            System.out.println("Port = " + uri.getPort());
////            System.out.println("Path = " + uri.getPath());
////            System.out.println("Query = " + uri.getQuery());
////            System.out.println("Fragment = " + uri.getFragment());
//
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
