
package se.theflow.vaderaktivitet.business;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Arrays;
import org.json.JSONObject;
import se.theflow.vaderaktivitet.models.Place;

public class smhi {
    public static void main(String[] args) {
        //String location = getName();

       // if(location== gothenburg)
        //Now

        weatherFetcher(10, urlGenerator("gothenburg"));






    }
    public static float[] weatherFetcher(float currentTime, String whatUrl){
        float weatherNow[] = new float[4];





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
                System.out.println(preSplit);


                //Splitting them up
                String [] arrOfStr = preSplit.split("unit");
                System.out.println("Array 20  " + arrOfStr[20]);

                //assigning their new names
                String currentCelsius = "";
                String currentCloudy = "";
                String currentWindSpeed = "";
                String avgRainChance = "";
                int i = 0;
                int loopStart = 1;
                int loopStop = 19;

                if(currentTime != 0) {
                    for (int j = 0; j < currentTime; j++){
                        loopStart += 19;
                        loopStop += 19;
                        System.out.println("current loop variable status: " + loopStart + "  " + loopStop);
                    }
                }

                for(i = loopStart; i <= loopStop; i++){
                    if(arrOfStr[i].contains("Cel")){
                        currentCelsius = arrOfStr[i];
                    }
                    else if(arrOfStr[i].contains("tcc_mean")){
                        currentCloudy = arrOfStr[i];
                    }
                    else if(arrOfStr[i].contains("\"name\":\"ws\"")){
                        currentWindSpeed = arrOfStr[i];
                    }
                    else if(arrOfStr[i].contains("pmean")){
                        avgRainChance = arrOfStr[i];
                    }


                }

                System.out.println(currentCelsius + " Degrees celsius");
                System.out.println(currentCloudy + " Amount of cloudiness");
                System.out.println(currentWindSpeed + " Current windspeed");
                System.out.println(avgRainChance + " Average rainfall");
                //Removing trash(")<--
                currentCelsius = currentCelsius.replace("\"", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("\"", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("\"", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("\"", "");
                System.out.println(avgRainChance);

                //Removing trash(:)<--
                currentCelsius = currentCelsius.replace(":", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace(":", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace(":", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace(":", "");
                System.out.println(avgRainChance);
                //Removing trash({)<--
                currentCelsius = currentCelsius.replace("{", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("{", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("{", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("{", "");
                System.out.println(avgRainChance);
                //Removing trash(,)<--
                currentCelsius = currentCelsius.replace(",", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace(",", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace(",", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace(",", "");
                System.out.println(avgRainChance);
                //Removing trash(})<--
                currentCelsius = currentCelsius.replace("}", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("}", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("}", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("}", "");
                System.out.println(avgRainChance);
                //Removing trash(names)<--
                currentCelsius = currentCelsius.replace("namet", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("nametcc_mean", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("namews", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("namepmean", "");
                System.out.println(avgRainChance);

                //Splitting them up to extract values
                String[] tempCelArray = currentCelsius.split("values");
                String[] tempCloudArray = currentCloudy.split("values");
                String[] tempWsArray = currentWindSpeed.split("values");
                String[] tempRainArray = avgRainChance.split("values");

                currentCelsius = tempCelArray[1];
                currentCloudy = tempCloudArray[1];
                currentWindSpeed = tempWsArray[1];
                avgRainChance = tempRainArray[1];

                //Finalizing trash removal (1/2(])<--)
                currentCelsius = currentCelsius.replace("]", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("]", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("]", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("]", "");
                System.out.println(avgRainChance);

                //Finalizing trash removal (2/2([)<--)
                currentCelsius = currentCelsius.replace("[", "");
                System.out.println(currentCelsius);
                currentCloudy = currentCloudy.replace("[", "");
                System.out.println(currentCloudy);
                currentWindSpeed = currentWindSpeed.replace("[", "");
                System.out.println(currentWindSpeed);
                avgRainChance = avgRainChance.replace("[", "");
                System.out.println(avgRainChance);


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
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/11.94/lat/57.69/data.json";
            return myUrl;
        }
        else if(location.contains("kungsbacka")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.06/lat/57.46/data.json";
            return myUrl;
        }
        else if(location.contains("åsa")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.12/lat/57.34/data.json";
            return myUrl;
        }
        else if(location.contains("varberg")){
            myUrl = "http://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/12.24/lat/57.09/data.json";
            return myUrl;
        }
        return myUrl;
    }

}

