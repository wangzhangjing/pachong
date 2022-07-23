package output;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class text2 {


    public static void main(String[] args) throws IOException{
    //向这个篇小说所在的主页发送请求,并获取到HTML文档
    String url ="https://www.qbiqu.com/0_1/1.html";

    //使用jsoup解析得到的html
    Document document = Jsoup.parse(new URL(url), 30000);
//        System.out.println(document);
    //使用select查询出所有的li标签
    Elements li = document.select("#content");
    System.out.print(li);
    //根据li的数量循环遍历

}

}