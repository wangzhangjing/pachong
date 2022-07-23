package hduwqdo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;

import java.io.IOException;

//设置请求头。不行
public class ghqqt {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://zhiyun.souche.com/dataQuery?typeId=25&prodId=43");
        httpGet.setHeader("User-Agent", "ozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.98");

        httpGet.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");

        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");

        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");

        httpGet.setHeader("Connection", "keep-alive");

        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
        HttpResponse response = httpClient.execute(httpGet);
        String contents = EntityUtils.toString(response.getEntity(),"utf-8");//utf-8
        Document document = Jsoup.parse(contents);
//        Elements elements = document.select("div#hza11 div.boxtxthot a"); Elements elements = document.select(".rankcell_d");
//

        System.out.println(document);
                }
                }