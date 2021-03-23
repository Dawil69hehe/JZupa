import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static Statement stmt;
    public static ResultSet results;

    public static void main(String[] args) throws SQLException {

    //menu
        Scanner scan = new Scanner(System.in);
        System.out.println("Jeśli chcesz zapisać w bazie 10 najpopularniejszych gier z ostatnich 48 godzin\n-Wpisz 1");
        System.out.println("Jeśli chcesz odczytać dane z bazy\n-Wpisz 2");
        int menuins = scan.nextInt();

    //output jako plik txt
    //PrintStream out = new PrintStream(new FileOutputStream("MostPopularOnSteam.txt"));
    //System.setOut(out);

    Connection conn = DBConnection.createNewDBconnection();
    Site List = new Site();
    List = new Site();

    LocalDateTime dt = LocalDateTime.now();

    if (menuins==1) {
        //wstawianie
        int i = 0;
        while (i < 10) {

            String data1 = String.valueOf(dt.getDayOfMonth()) + "-" + String.valueOf(dt.getMonth()) + "-" + String.valueOf(dt.getYear());
            String godzina1 = String.valueOf(dt.getHour()) + ":" + String.valueOf(dt.getMinute()) + ":" + String.valueOf(dt.getSecond());

            Object game1 = List.gameList().get(i);
            String game2 = game1.toString();

            String sqlInsert2 = "INSERT INTO topgry (gra, datawstaw, godzinawstaw) VALUES (?, ?, ?)";
            PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert2);
            stmtInsert.setString(1, game2);
            stmtInsert.setString(2, data1);
            stmtInsert.setString(3, godzina1);
            stmtInsert.execute();
            i++;
        }
        System.out.println("Dane wstawione");
    }

    if (menuins==2) {
        Date dat1 = new Date();
        double pocz = dat1.getTime();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM topgry");
        while (rs.next()) {
            String wyn1 = rs.getString("id");
            String wyn2 = rs.getString("gra");
            String wyn3 = rs.getString("datawstaw");
            String wyn4 = rs.getString("godzinawstaw");
            System.out.println("----------- id:"+wyn1+" -----------");
            System.out.println("tytuł gry:"+wyn2);
            System.out.println("data zapisu: "+wyn3);
            System.out.println("godzina zapisu: "+wyn4);
        }
        Date dat2 = new Date();
        double koniec = dat2.getTime();

        System.out.println("----------- ------ -----------");
        System.out.println("Czas wykonania w milisekundach: ");
        System.out.println(koniec-pocz);

    }

    }
}
//https://github.com/Dawil69hehe/JZupa
