import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc = null;

        try{doc = Jsoup.connect("https://store.steampowered.com/stats/").get();}
        catch(IOException e){
            e.printStackTrace();}

        Element element1 = doc.getAllElements().first();
        Element topgames = doc.getElementById("detailStats");
        Elements topgamestr = topgames.getElementsByTag("tr");
        Elements topgameslinks = topgames.getElementsByClass("gameLink");
        Elements topgamesrow = topgames.getElementsByClass("player_count_row");

        String url = topgameslinks.attr("href");

        String title = doc.title();

        System.out.println(title);
        System.out.println(topgamesrow.text()+"\n");
        System.out.println(url);
    }
}
