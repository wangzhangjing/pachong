package hduwqdo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
public class dfw {
    public static void main(String[] args) throws IOException {
        String url = "https://search.51job.com/list/000000,000000,0000,00,9,99,%25E8%25B0%25B7%25E6%25AD%258C,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";

        Connection con = Jsoup.connect(url);
        String cook = "nsearch=jobarea%3D%26%7C%26ord_field%3D%26%7C%26recentSearch0%3D%26%7C%26recentSearch1%3D%26%7C%26recentSearch2%3D%26%7C%26recentSearch3%3D%26%7C%26recentSearch4%3D%26%7C%26collapse_expansion%3D; expires=Tue, 28-Mar-2023 12:47:29 GMT; Max-Age=31536000; path=/; domain=.51job.com; HttpOnly";
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cook);
        //发送请求
        Connection.Response resp = con.method(Connection.Method.GET).execute();
        Document document = Jsoup.parse(resp.body(), "utf8");
        Elements e = document.getElementsByTag("script");
        Elements eq = e.eq(7);
        System.out.println(document);
    }
}