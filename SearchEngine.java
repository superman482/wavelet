import java.io.IOException;
import java.net.URI;
import java.util.*;

public class SearchEngine implements URLHandler {
    ArrayList<String> str = new ArrayList<String>();
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("The String contains: ", str);
        } else if (url.getPath().contains("/add")) {

        }
    }
}
