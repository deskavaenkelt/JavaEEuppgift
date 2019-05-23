
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
            System.out.println(preSplit);


            //Splitting them up
            String [] arrOfStr = preSplit.split("unit");

            //assigning their new names
            String currentCelsius = arrOfStr[12];
            String currentCloudy = arrOfStr[7];
            String currentWindSpeed = arrOfStr[15];
            String avgRainChance = arrOfStr[4];
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







            /*
            //Combining them
            String strOfArr = Arrays.toString(arrOfStr);
            //Splitting them again
            String [] tempArray = strOfArr.split("unit");
            //Combined again
            strOfArr = Arrays.toString(tempArray);
            //splitting them again

            arrOfStr = strOfArr.split("parameters");
            //Combining them again
            strOfArr = Arrays.toString(arrOfStr);
            //splitting
            arrOfStr = strOfArr.split("percent");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("level");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("levelType");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("h1");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("values");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("name");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("spp");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("category");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("pcat");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("kg/m2/h");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            arrOfStr = strOfArr.split("pmin");
            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //splitting

            //arrOfStr = strOfArr.split("pmean");

            //combining them again

            //strOfArr = Arrays.toString(arrOfStr);



            //splitting

            arrOfStr = strOfArr.split("Type\":\"hl\"");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("pmax");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("pmedian");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("lcc_mean");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("mcc_mean");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("hcc_mean");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("hPa");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("Type\":\"hmsl\"");

            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("msl");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("t");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("km");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("degree");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("wd");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("ws");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("r");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("tstm");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("Wsymb2");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("\", \":");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split(",\", \":");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);


            //splitting

            arrOfStr = strOfArr.split("");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);


            //splitting

            arrOfStr = strOfArr.split(",");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);


            //splitting

            arrOfStr = strOfArr.split("");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);

            //splitting

            arrOfStr = strOfArr.split("\\[");


            //combining them again

            strOfArr = Arrays.toString(arrOfStr);

            //printing

            System.out.println(strOfArr);
*/















        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

