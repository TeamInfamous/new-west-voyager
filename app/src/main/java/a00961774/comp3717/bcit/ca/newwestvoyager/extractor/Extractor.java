package a00961774.comp3717.bcit.ca.newwestvoyager.extractor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Extractor {
    public static void main (String args[]) {
        try {
            BufferedReader br = new BufferedReader (new FileReader ("./doc.kml"));
            String line;
            ArrayList<String> lines = new ArrayList <>();
            while ((line = br.readLine()) != null)
                if (line.contains ("coordinates"))
                    lines.add (line);
            for (String temp : lines)
                System.out.println (temp);
        } catch (IOException ex) {
            System.out.println (":p");
        }
    }
}