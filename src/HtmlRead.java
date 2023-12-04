import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("href=") && line.contains("www")){
                    //int beginIndex = line.indexOf("href=") + 6;
                    int beginIndex = 0;
                    //System.out.println("og: "+ line );
                    if (line.contains("https:")){
                        beginIndex = line.indexOf("https:");
                    }
                    if (!line.contains("https:")){
                        beginIndex = line.indexOf("www");
                    }
                    int endIndex = 0;
                    if (line.substring(beginIndex).contains("\'")){
                         endIndex = line.indexOf("\'", beginIndex+1);
                    }
                    if (line.substring(beginIndex).contains("\"")){
                         endIndex = line.indexOf("\"", beginIndex+1);
                    }
                    if (line.substring(beginIndex).contains("\"") && line.substring(beginIndex).contains("\'")){
                        if (line.indexOf("\'") > line.indexOf("\"")){
                            endIndex = line.indexOf("\"", beginIndex+1);
                        }else{
                            endIndex = line.indexOf("\'", beginIndex+1);
                        }
                    }
                    String substring = line.substring(beginIndex, endIndex);
                    System.out.println(substring);
                }
            }

            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
