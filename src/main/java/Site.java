import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Site {
    public List gameList() {
    //połączenie
        Document doc = null;
        String url = "https://store.steampowered.com/stats/";
        try {doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();}
    //pobieranie najpopularniejszych gier
        Element topgames = doc.getElementById("detailStats");
        Elements topgamesrow = topgames.getElementsByClass("player_count_row");
        String title = doc.title();
        String topgamesstr = topgamesrow.text();
    //usuwanie przerw i tworzenie listy
        topgamesstr = topgamesstr.replaceAll("[0-9]", "");
        String[] array = topgamesstr.split(",", -1);
        List<String> al = new ArrayList<String>();
        List list = new ArrayList(Arrays.asList(array));
        int z2 = 0;
        while (z2 < 101) {
            list.remove(" ");
            list.remove("");
            z2++;
        }
        //tylko top 10
        while (z2 < 191) {
            list.remove(9);
            z2++;
        }
        Object[] array2 = al.toArray();
    //return
        return list;
    }
}
