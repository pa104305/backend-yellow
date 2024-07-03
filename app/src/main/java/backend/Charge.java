package backend;

import static spark.Spark.halt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Charge {
    private String content;
    private final String base = "src/main/resources/FRONTEND/";
    public Charge(){}

    public String chargeHTML(String route){
        try{
            content = new String(Files.readAllBytes(Paths.get(base + route)));
        }catch(IOException e){
            e.printStackTrace();
            halt(500, "Server error");
        }
        return content;
    }
}
