package hduwqdo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class dz {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;// 保存原输出流
        PrintStream ps = new PrintStream("C:\\Users\\86176\\Desktop\\gugezpsj.txt");// 创建文件输出流1
        System.setOut(ps);// 设置使用新的输出流
        // System.out.println("使用新的输出流将log输出到C:\Users\86176\Desktop\谷歌招聘数据.txt");
        int sum = 1;
        List<String> url_list = new ArrayList<>();
        for (int m = 1; m <= 5; m++) {
            try {

                //m为网页页数，即1到10页，这里的url可根据需求进行修改
                String url = "https://search.51job.com/list/000000,000000,0000,00,9,99,%25E8%25B0%25B7%25E6%25AD%258C,2," + m + ".html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";

                Connection con = Jsoup.connect(url);
                String cook = "search=jobarea%7E%60000000%7C%21ord_field%7E%600%7C%21recentSearch0%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FA%B9%C8%B8%E8%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch1%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FA%B9%C8%B8%E8%D5%D0%C6%B8%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21; expires=Sun, 20-Nov-2022 11:38:28 GMT; Max-Age=31536000; path=/; domain=.51job.com; HttpOnly";
                //请求头设置，特别是cookie设置
                con.header("Accept", "text/html, application/xhtml+xml, */*");
                con.header("Content-Type", "application/x-www-form-urlencoded");
                con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
                con.header("Cookie", cook);
                //发送请求
                Connection.Response resp = con.method(Connection.Method.GET).execute();
                Document document = Jsoup.parse(resp.body(), "utf8");
                Elements e = document.getElementsByTag("script");
                Elements eq = e.eq(10);





                /*循环遍历script下面的JS变量*/
                for (Element element : eq) {

                    /*取得JS变量数组*/
                    String[] data = element.data().toString().split("=", 2);
                    JSONObject obj = (JSONObject) JSON.parse(data[1]);
                    JSONArray jobs = (JSONArray) obj.getJSONArray("engine_jds");
                    for (int j = 0; j < jobs.size(); j++) {
                        JSONObject o = jobs.getJSONObject(j);
                        System.out.println("职业:" + o.getString("job_name"));
                        System.out.println("工资:" + o.getString("providesalary_text"));
                        System.out.println("待遇:" + o.getString("jobwelf"));
                        System.out.println("发布时间:" + o.getString("issuedate"));
                        String input = o.getString("attribute_text");
                        String[] str = input.split(",", 4);
                        for (int i = 0; i < str.length; i++) {
                            //
//                    String s = str[i].replace('[', ' ');
//                    String a =  s.replace(']', ' ');
//                    System.out.println(a.replace('"', ' '));

                        }
                        String s = str[0].replace('[', ' ');
                        String a = s.replace(']', ' ');
                        System.out.println("地点:" + a.replace('"', ' '));
                        String sq = str[1].replace('[', ' ');
                        String aq = sq.replace(']', ' ');
                        System.out.println("资历：" + aq.replace('"', ' '));
                        String sw = str[2].replace('[', ' ');
                        String aw = sw.replace(']', ' ');
                        System.out.println("学历：" + aw.replace('"', ' '));
                        //无需求
                        // String se = str[3].replace('[', ' ');
                        // String ae =  se.replace(']', ' ');
                        // System.out.println("需求人数："+ae.replace('"', ' '));
                        // System.out.println("------------------------------------------------------");


                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            }
            sum++;


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



        }

    }
}