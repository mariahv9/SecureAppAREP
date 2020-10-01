package edu.escuelaing.arep.login;

import spark.Request;
import spark.Response;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    public static boolean login (Request request, Response response){
        String userLog = "Maria";
        String passLog = "827ccb0eea8a706c4c34a16891f84e7b";
        boolean logged = false;
        if (request.queryParams("user") != null && request.queryParams("pssd") != null){
            try {
                String hash = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(request.queryParams("pssd").getBytes("UTF-8")));
                hash = hash.toLowerCase();
                if (request.queryParams("user").equals(userLog) && hash.equals(passLog)){
                    logged = true;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {
            logged = false;
        }
//        if (logged){
//            request.session().attribute("user", request.queryParams("user"));
//            response.redirect("/calculator");
//        }
        return logged;
    }

    public static String isLogged (Request request, Response response){
        String ans = "";
        if (login(request, response)){
            ans += "Estas loggeado";
        }else {
            ans += "Fallo el login";
        }
        return ans;
    }
}
