import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;

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

        //Elements url = topgameslinks.attributes();



        String title = doc.title();
        String topgamesstr=topgamesrow.text();
        //usuwanie przerw
        topgamesstr = topgamesstr.replaceAll("[0-9]","");
        topgamesstr = topgamesstr.replaceAll("[0-9]","");
        topgamesstr = topgamesstr.replaceAll(",",";");

        String[] array = topgamesstr.split(";", -1);


        System.out.println(title);
        System.out.println(Arrays.toString(array));
        //System.out.println(url);
    }
}
