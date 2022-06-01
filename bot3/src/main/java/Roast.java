import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Roast {

    private String user, roast;
    private String line = "";
    private File file = new File("C:/Users/16693/Git_Repositories/bots/bot3/src/main/java/txt/roasts.txt");

    public void generateRoast() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<String> roasts = new ArrayList<String>();

        while (sc.hasNextLine())
            roasts.add(sc.nextLine());

        roast = roasts.get((int) (Math.random() * roasts.size()));
    }

    public void setRoast(String msg) {
        roast = msg;
    }

    public String getRoast() { return roast; }

//    Testing
//    public static void main(String[] args) throws FileNotFoundException {
//        Roast r = new Roast();
//        r.generateRoast();
//        System.out.println(r.getRoast());
//    }
}
