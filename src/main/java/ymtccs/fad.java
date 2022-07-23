package ymtccs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class fad {
    public static void main(String[] args ) throws IOException {

        String url ="https://zhiyun.souche.com/dataQuery?typeId=25&prodId=43";
        Document content = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
                .timeout(6000).get();//取得整个页面内容；
        Document document = Jsoup.parse(String.valueOf(content));
        System.out.println(document);

    }
}
