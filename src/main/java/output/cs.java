package output;

import java.io.IOException;
import java.util.Scanner;

public class cs {

        public static void main(String args[]) {
            String sourceStr = "1,2,3,4,5";
            String[] sourceStrArray = sourceStr.split(",");
            for (int i = 0; i < sourceStrArray.length; i++) {
                System.out.println(sourceStrArray[i]);
            }

        }
//    String getUrl = "http://product.auto.163.com/rank/hotIndices_all.html";
//    Document doc =  Jsoup.parse(new URL(getUrl).openStream(), "gb2312", getUrl);
//    Connection con = Jsoup.connect(String.valueOf(doc));
    }