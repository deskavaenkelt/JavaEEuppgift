
package se.theflow.vaderaktivitet.business;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import org.json.JSONObject;
import se.theflow.vaderaktivitet.models.Place;

public class smhi {
    public static void main(String[] args) {


        //String location = getName();

       // if(location== gothenburg)
        //Now

        weatherFetcher(timeConstructor(), urlGenerator("gothenburg"));
        timeConstructor();

    }
    public static float[] weatherFetcher(String currentTime, String whatUrl){
        //Assigning variables
        float weatherNow[] = new float[4];
        String currentCelsius = "";
        String currentCloudy = "";
        String currentWindSpeed = "";
        String avgRainChance = "";
        String newString = "";

        int i = 0;
        int loopStart = 1;
        int loopStop = 19;

        try {


                String url = whatUrl;
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

                //Splitting them up
                String [] tempArrOfStr = preSplit.split("validTime");
                System.out.println("before loop");
                for(int j=0; j <= tempArrOfStr.length; j++){
                    System.out.println("in loop");
                    String tempString = tempArrOfStr[j];
                    newString = tempString.replace("\"", "").replaceFirst(":", "").replaceFirst("t", "").replaceFirst("z", "").replace("T", " ");
                    System.out.println(newString);
                    if(newString.indexOf(currentTime) > -1){
                        System.out.println("found it");
                        break;

                    }



                }
            String [] arrOfStr = newString.split("unit");

            for(i = 0; i <= arrOfStr.length; i++){
                if(arrOfStr[i].contains("Cel")){
                    currentCelsius = arrOfStr[i];
                    System.out.println("cel obtained!");
                    break;
                }}
                for(i = 0; i <= arrOfStr.length; i++){
                if(arrOfStr[i].contains("tcc_mean")){
                    currentCloudy = arrOfStr[i];
                    System.out.println("clouds obtained!");
                    break;

                }}
                for(i = 0; i <= arrOfStr.length; i++){
                if(arrOfStr[i].contains("name:ws")){
                    currentWindSpeed = arrOfStr[i];
                    System.out.println("Wind obtained!");
                    break;
                }}
                for(i = 0; i <= arrOfStr.length; i++){
                if(arrOfStr[i].contains("pmean")){
                    avgRainChance = arrOfStr[i];
                    System.out.println("rain obtained!");
                    break;
                }



            }


            System.out.println("got out of forloop");



                //Removing trash
                currentCelsius = currentCelsius.replace("\"", "").replace(":", "").replace("{", "").replace(",", "").replace("}", "").replace("namet", "");
                currentCloudy = currentCloudy.replace("\"", "").replace(":", "").replace("{", "").replace(",", "").replace("}", "").replace("nametcc_mean", "");
                currentWindSpeed = currentWindSpeed.replace("\"", "").replace(":", "").replace("{", "").replace(",", "").replace("}", "").replace("namews", "");
                avgRainChance = avgRainChance.replace("\"", "").replace(":", "").replace("{", "").replace(",", "").replace("}", "").replace("namepmean", "");

                //Splitting them up to extract values
                String[] tempCelArray = currentCelsius.split("values");
                String[] tempCloudArray = currentCloudy.split("values");
                String[] tempWsArray = currentWindSpeed.split("values");
                String[] tempRainArray = avgRainChance.split("values");

                currentCelsius = tempCelArray[1];
                currentCloudy = tempCloudArray[1];
                currentWindSpeed = tempWsArray[1];
                avgRainChance = tempRainArray[1];

                //Finalizing trash removal
                currentCelsius = currentCelsius.replace("]", "").replace("[", "");
                currentCloudy = currentCloudy.replace("]", "").replace("[", "");
                currentWindSpeed = currentWindSpeed.replace("]", "").replace("[", "");
                avgRainChance = avgRainChance.replace("]", "").replace("[", "");


                System.out.println("The current weather: " + currentCelsius + " Degrees celsius, with "
                        + currentCloudy + " /8ths cloud-coverage, and a windspeed of "
                        + currentWindSpeed + " m/s and an average rainfall of " + avgRainChance);
                float floatCelsius = Float.parseFloat(currentCelsius);
                float floatCloudiness = Float.parseFloat(currentCloudy);
                float floatWindSpeed = Float.parseFloat(currentWindSpeed);
                float floatRainFall = Float.parseFloat(avgRainChance);
                System.out.println(floatCelsius + " " + floatCloudiness + " " + floatWindSpeed + " " + floatRainFall);
                System.out.println(floatWindSpeed);
                weatherNow[0] = floatCelsius;
                weatherNow[1] = floatCloudiness;
                weatherNow[2] = floatWindSpeed;
                weatherNow[3] = floatRainFall;
                

            }
            catch(Exception e){
                System.out.println(e);
            }


        return weatherNow;

    }
    public static String urlGenerator (String location){
        String myUrl = "";
        if(location.contains("gothenburg")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/11.85/lat/57.66/data.json";
            return myUrl;
        }
        else if(location.contains("kungsbacka")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/11.96/lat/57.49/data.json";
            return myUrl;
        }
        else if(location.contains("åsa")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.07/lat/57.33/data.json";
            return myUrl;
        }
        else if(location.contains("varberg")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.25/lat/57.10/data.json";
            return myUrl;
        }
        else if(location.contains("falkenberg")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.50/lat/56.88/data.json";
            return myUrl;
        }
        return myUrl;
    }
    public static String timeConstructor (){
        LocalDateTime myObj = LocalDateTime.now();
        System.out.println("unformatted: " + myObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        String formattedDate = myObj.format(myFormatObj);
        System.out.println("Formatted: " + formattedDate);
        return formattedDate;
    }

}

