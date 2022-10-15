import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {

    List<String> str = new ArrayList<>();

    public String handleRequest(URI url) {
        if(url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                str.add(parameters[1]);
                return String.format("The item %s has been added", parameters[1]);
            }
        } else if (url.getPath().equals("/")) {
            String items = "";
            for (String s : str) {
                items += s + ", ";
            } return String.format("The String contains: %s ", items);
        }  else if(url.getPath().contains("/search")) {
            String[] parameter = url.getQuery().split("=");
            if (parameter[0].equals("s")) {
                String items = "";
                for (String s : str) {
                    if (s.contains(parameter[1])) {
                        items += s + ", "; 
                    } 
                    else { return "Sorry, there is no item that matches your search"; } 
                } return String.format("The items that match your search are %s ", items);
            } 
        } return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

