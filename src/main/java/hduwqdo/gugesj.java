package hduwqdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class gugesj {
    public static void main(String[] args) throws IOException {
        String getUrl = "https://zhiyun.souche.com/dataQuery?typeId=25&prodId=43";
        Document document =  Jsoup.parse(new URL(getUrl).openStream(),"utf-8",getUrl);
        System.out.println(document);
        Elements element = document.getElementsByClass("fn-clear ");
        Elements elements = element.get(0).getElementsByTag("li");
        for (Element el : elements){

            String q = el.getElementsByTag("p").eq(0).text();
            String w = el.getElementsByClass("price-box fn-clear").eq(0).text();
            String e = el.getElementsByClass("car-series").eq(0).text();
            System.out.println("-------------------------------------------------------------");
            System.out.println(e);
            System.out.println(w);
            System.out.println(q);

        }

    }
}