package hduwqdo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class bianmacw {
    public static void main(String[] args) throws IOException {

        String getUrl = "http://product.auto.163.com/rank/hotIndices_all.html";
        Document doc =  Jsoup.parse(new URL(getUrl).openStream(), "gb2312", getUrl);
        Connection con = Jsoup.connect(String.valueOf(doc));


        String cook="_ntes_nnid=a26708dd723825373f72a29e7bd23a66,1608520881766; _ntes_nuid=a26708dd723825373f72a29e7bd23a66; hb_MA-93D5-9AD06EA4329A_source=www.baidu.com; __root_domain_v=.163.com; _qddaz=QD.109137322637929; vjuids=e8f17ee3.17d45143f81.0.b6c1e3285ddc3; vjlast=1637541495.1637541495.30; _ga=GA1.2.1225437514.1637541496; _gid=GA1.2.1211804880.1637541496; _antanalysis_s_id=1637541496405";
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/text/html ;charset=gb2312");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cook);
        //发送请求中
        Connection.Response resp=con.method(Connection.Method.GET).execute();
        Document document = Jsoup.parse(resp.body().replace("20%", " "));
        System.out.println(document);

        Elements element = document.getElementsByClass("db");
        Elements elements = element.get(0).getElementsByTag("rankcell_d");
        for (Element el : elements){
            String title = el.getElementsByClass("tt clearfix").eq(0).text();

            System.out.println("-------------------------------------------------------------");

            System.out.println(title);
        }

    }
}