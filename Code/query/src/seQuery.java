import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class seQuery {
    String path;

    public seQuery(String path) {
        this.path = path;
    }

    public String[] query(String query1, String query2) {
        String[] result = new String[100];
        int k = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.path));
            String query = "<"+query1+"> <"+query2+">";
            String str;
            while ((str = in.readLine()) != null) {

                String[] info = str.split(">");
                String item1 = info[0].substring(1);
                String item2 = info[1].substring(2);
                if (item1.equals(query1) && item2.equals(query2)) {
                    result[k] = info[2];
                    k++;
                }
                if (item2.equals(query1) && item1.equals(query2)) {
                    result[k] = info[2];
                    k++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return result;
    }
}
