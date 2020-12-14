import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
    //połączenie
        try{doc = Jsoup.connect("https://store.steampowered.com/stats/").get();}
        catch(IOException e){
            e.printStackTrace();}
    //pobieranie najpopularniejszych gier
        Element topgames = doc.getElementById("detailStats");
        Elements topgamesrow = topgames.getElementsByClass("player_count_row");
        String title = doc.title();
        String topgamesstr=topgamesrow.text();
    //usuwanie przerw i tworzenie listy
        topgamesstr = topgamesstr.replaceAll("[0-9]","");
        String[] array = topgamesstr.split(",", -1);
        List<String> al = new ArrayList<String>();
        List list = new ArrayList(Arrays.asList(array));
        int z2 = 0;
        while(z2<101){
            list.remove(" ");
            list.remove("");
            z2++;}
        Object[] array2 = al.toArray();



        System.out.println(title);
        System.out.println(list);
    }
}
