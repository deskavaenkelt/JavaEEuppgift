
package se.theflow.vaderaktivitet.business;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Arrays;

import org.json.JSONObject;

public class smhi {
    public static void main(String[] args) {

        try {
            String url = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/11.94/lat/57.69/data.json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject myResponse = new JSONObject(response.toString());

            //System.out.println(myResponse);
            String preSplit = myResponse.toString();
            String [] arrOfStr = preSplit.split("\\{\"validTime\":");
            //System.out.println(Arrays.toString(arrOfStr));
            String tempString = arrOfStr[1];
            System.out.println(tempString);


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

