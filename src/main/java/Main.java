import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    //output jako plik txt
        PrintStream out = new PrintStream(new FileOutputStream("MostPopularOnSteam.txt"));
        System.setOut(out);
    //Site
        Site List = new Site();
    //output
        System.out.println("------------------------------------------------------" +
                "\n10 najpopularniejszych gier na Steam (ostatnie 2 dni):" +
                "\n------------------------------------------------------");
        System.out.println(List.gameList());
        System.out.println("-----------------\nDawid Wilemski 3P\n-----------------");
    }
}
//https://github.com/Dawil69hehe/JZupa
