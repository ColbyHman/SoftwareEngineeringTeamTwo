import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;
import java.net.*;

public class MapsTest {

    public String processString(String string, Boolean bool){

        string = string.trim();
        String[] splitString = string.split(" ");
        String processedString = "";

        for(int i = 0; i < splitString.length; i++){
            processedString += splitString[i];
            processedString += "+";
        }
        if(bool)
            processedString += "Bethlehem,+PA+18018";

        return processedString;
    }


    public HashMap generateLocationList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/locations.csv"));
        HashMap locations = new HashMap();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] data = line.split(",");
            locations.put(data[0], data[1]);
        }

        return locations;
    }

    public void createImage(String location) throws IOException {
        String crimeAddress = "";
        HashMap locations = generateLocationList();
        if(locations.get(location) != null){
            crimeAddress = (String) locations.get(location);
            System.out.println(crimeAddress);

        }
        String desiredLocation = "Haupert Union Building (HUB)";
        String desiredAddress = "1125 Monocacy St.";

        String processedAddress = this.processString(desiredAddress, true);
        String processedCrimeAddress = this.processString(crimeAddress, true);
        String processedDesiredLocation = this.processString(desiredLocation, false);

        //Process data to create URL
        String zoom = "16";
        String crimeMarker = "flag-8B0000-EVENT";
        String locationMarker = "marker-lg-3B5998-22407F";
        String key = "UDxbwAfazAkmB9R6pD6gdkK9hCgVhAB1";
        String center = desiredLocation;
        String typeOfMap = "map";
        String banner = "Event+in+Relation+to+:+"+processedDesiredLocation+"|lg-top-3B5998-22407F";
        String size = "800,800";

        System.out.println(processedAddress);
        System.out.println(processedCrimeAddress);

        String urlText = "https://www.mapquestapi.com/staticmap/v5/map?key="+key
                +"&center="+processedAddress+"&locations="+processedCrimeAddress+"|"+
                crimeMarker+"||"+processedAddress+"|"+locationMarker+"&zoom="+
                zoom+"&banner="+banner+"&type="+typeOfMap+"&size="+size;

        URL url = new URL(urlText);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStream inputStream = con.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("resources/image.png"));
        int bytesRead = -1;
        byte[] buffer = new byte[1024];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }

        fileOutputStream.close();
        inputStream.close();
    }




}
