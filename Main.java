import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ServiceWorker serviceWorker =new ServiceWorker();
        System.out.println("Выберите словарь:");
        System.out.println("1-Латинско-русский");
        System.out.println("2-Десятично-доичный");
        String num = bufferedReader.readLine();
        switch (num) {
            case "1":serviceWorker.Slovar(1);
                break;
            case "2":serviceWorker.Slovar(2);
                break;
            default:serviceWorker.Slovar(1);
        }

    }


}
