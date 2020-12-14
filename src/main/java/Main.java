import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    //output jako plik txt
        PrintStream out = new PrintStream(new FileOutputStream("MostPopularOnSteam.txt"));
        System.setOut(out);

    //połączenie
        Document doc = null;
        String url="https://store.steampowered.com/stats/";
        try{doc = Jsoup.connect(url).get();}
        catch(IOException e){e.printStackTrace();}
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

    //output
        System.out.println("-----------------\n"+title);
        System.out.println(url);
        System.out.println("-----------------\n100 most popular steam games (last 2 days):");
        System.out.println(list);
        System.out.println("-----------------\nDawid Wilemski 3P\n-----------------");
    }
}
