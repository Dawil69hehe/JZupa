import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        try{
        doc = Jsoup.connect("https://www.zsmeie.torun.pl/glowna/plan/planp.php").get();}
        catch(IOException e){
            e.printStackTrace();
        }
        Element element1 = doc.getAllElements().first();
        Elements elements1 = elements1 = element1.getAllElements();
        System.out.println(elements1.text());
    }
}
