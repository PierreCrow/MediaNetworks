package com.futuremobile.wox.data.datasource.cloud.ro;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public class TokenAuthenticator implements Authenticator {
    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {

        String userRefreshToken="your refresh token";
        String cid="your client id";
        String csecret="your client secret";
        String baseUrl="your base url";

        Boolean refreshResult;
        refreshResult=refreshToken(baseUrl,userRefreshToken,cid,csecret);
        if (refreshResult) {
            //refresh is successful
            String newaccess="your new access token";

            // make current request with new access token
            return response.request().newBuilder()
                    .header("Authorization", newaccess)
                    .build();

        } else {
            // refresh failed , maybe you can logout user
            // returning null is critical here, because if you do not return null
            // it will try to refresh token continuously like 1000 times.
            // also you can try 2-3-4 times by depending you before logging out your user
            return null;
        }
    }

    public boolean refreshToken(String url,String refresh,String cid,String csecret) throws IOException{
        URL refreshUrl=new URL(url+"token");
        HttpURLConnection urlConnection = (HttpURLConnection) refreshUrl.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setUseCaches(false);
        String urlParameters  = "grant_type=refresh_token&client_id="+cid+"&client_secret="+csecret+"&refresh_token="+refresh;

        urlConnection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = urlConnection.getResponseCode();

        if(responseCode==200){
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // this gson part is optional , you can read response directly from Json too
           // Gson gson = new Gson();
           // RefreshTokenResult refreshTokenResult=gson.fromJson(response.toString(),RefreshTokenResult.class);

            // handle new token ...
            // save it to the sharedpreferences, storage bla bla ...
            return true;

        } else {
            //cannot refresh
            return false;
        }

    }
}
