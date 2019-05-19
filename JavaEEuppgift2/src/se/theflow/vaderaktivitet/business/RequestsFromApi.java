package se.theflow.vaderaktivitet.business;

// Vet att den är felskapad men skapade den för röd tråd i planeringen

public class RequestsFromApi {

    public static String sunbathing(int day) {
        String text = "";
        if (day == 0) {
            text = "Current weather";
        } else if (day == 1) {
            text = "Today's weather";
        } else if (day == 2) {
            text = "Tomorrow's weather";
        } else if (day == 3) {
            text = "Day after tomorrow's weather";
        } else if (day == 4) {
            text = "Day 4's weather";
        } else if (day == 5) {
            text = "Day 5's weather";
        }
        return text;
    }
}
