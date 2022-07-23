package hduwqdo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import output.fg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class tpyqcjsoup {
    public static void main(String[] args) throws IOException {
        String url = "https://zhiyun.souche.com/dataQuery?typeId=25&prodId=43";

        Connection con = Jsoup.connect(url);
        String cook = "Hm_lvt_4f39064ba41b08e411d9c9f60a3303ea=1637631887; Hm_lpvt_4f39064ba41b08e411d9c9f60a3303ea=1637631887; Qs_lvt_367590=1637631887; Qs_pv_367590=844925654205755600; mediav=%7B%22eid%22%3A%221008084%22%2C%22ep%22%3A%22%22%2C%22vid%22%3A%22ujsVy%25N5%25!8qJadIkr%5Bt%22%2C%22ctn%22%3A%22%22%2C%22vvid%22%3A%22ujsVy%25N5%25!8qJadIkr%5Bt%22%2C%22_mvnf%22%3A1%2C%22_mvctn%22%3A0%2C%22_mvck%22%3A0%2C%22_refnf%22%3A1%7D";
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/text/html ;charset=utf-8");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cook);
        //发送请求
        Connection.Response resp = con.method(Connection.Method.GET).execute();
        Document document = Jsoup.parse(resp.body(), "utf8");
        System.out.println(document);
        //Elements e = document.getElementsByTag("script");






            /*循环遍历script下面的JS变量*/
//            for (Element element : eq) {
//
//                /*取得JS变量数组*/
//                String[] data = element.data().toString().split("=", 2);
//                        JSONObject obj = (JSONObject) JSON.parse(data[1]);
//                        JSONArray jobs = (JSONArray) obj.getJSONArray("engine_jds");
//                        for (int j = 0; j < jobs.size(); j++) {
//                            JSONObject o = jobs.getJSONObject(j);
//                            System.out.println("职业:"+o.getString("job_name"));
//                            System.out.println("工资:"+o.getString("providesalary_text"));
//                            System.out.println("待遇:"+o.getString("jobwelf"));
//                            System.out.println("发布时间:"+o.getString("issuedate"));
//                            String input = o.getString("attribute_text");
//                            String[] str = input.split(",", 4);
//                            for ( int  i= 0 ;i<str.length;i++){
//                        //
//                    String s = str[i].replace('[', ' ');
//                    String a =  s.replace(']', ' ');
//                    System.out.println(a.replace('"', ' '));

                    }
//                    String s = str[0].replace('[', ' ');
//                    String a =  s.replace(']', ' ');
//                    System.out.println("地点:"+a.replace('"', ' '));
//                    String sq = str[1].replace('[', ' ');
//                    String aq =  sq.replace(']', ' ');
//                    System.out.println("资历："+aq.replace('"', ' '));
//                    String sw = str[2].replace('[', ' ');
//                    String aw =  sw.replace(']', ' ');
//                    System.out.println("学历："+aw.replace('"', ' '));
                    //无需求
                    // String se = str[3].replace('[', ' ');
                    // String ae =  se.replace(']', ' ');
                    // System.out.println("需求人数："+ae.replace('"', ' '));
                    // System.out.println("------------------------------------------------------");

                }

//
//        }
//通过class下载数据
//        Elements element = document.getElementsByClass("j_joblist");
//        Elements elements = element.get(0).getElementsByTag("div");
//        for (Element el : elements){
//            String gs = el.getElementsByClass("sal").eq(0).text();
//            String gz = el.getElementsByClass("d at").eq(0).text();
//            String jh = el.getElementsByClass("info").eq(0).text();
//
//            System.out.println("-------------------------------------------------------------");
//            System.out.println(gs);
//            System.out.println(gz);
//            System.out.println(jh);
//
//        }
//    }
//}