package hduwqdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class four {
    public static void main(String[] args) throws IOException {
        String url = "http://product.auto.163.com/rank/hotIndices_all.html";
        Document document = Jsoup.parse(new URL(url), 30000);
        System.out.println(document);
//        Elements element = document.getElementsByClass("db");
//        Elements elements = element.get(0).getElementsByTag("div");
//        for (Element el : elements){
//            String title = el.getElementsByClass("tt clearfix").eq(0).text();
//
//            System.out.println("-------------------------------------------------------------");
//            System.out.println(title);
//
//        }
    }
}