package ymtccs;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sss {

    public static void main(String[] args) {
        String strUrl = "https://search.51job.com/list/000000,000000,0000,00,9,99,%25E8%25B0%25B7%25E6%25AD%258C,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        Document document = getDom(strUrl);

        int pageNum = getPageNum(document);
        for(int i=1;i<=pageNum;i++){
            strUrl = "https://search.51job.com/list/000000,000000,0000,00,9,99,%25E8%25B0%25B7%25E6%25AD%258C,2,\" + m + \".html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
            Document document2 = getDom(strUrl);
            List<ssss> list = getPageInfo(document2);
            System.out.println("-------------"+i+"--------------");
            for (ssss jobBean : list) {
                System.out.println(jobBean);
            }
        }
    }

    public static int getPageNum(Document document) {
        Elements elements = document.select(".td");
        String text = elements.get(0).text();
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(text);
        String pageNum = matcher.replaceAll("");
        return Integer.parseInt(pageNum);
    }

    public static List<ssss> getPageInfo(Document document) {
        List<ssss> list = new ArrayList<ssss>();
        Elements elements = document.select("#resultList .el");
        elements.remove(0);
        for (Element element : elements) {
            Elements elements2 = element.select("span");
            ssss jobBean = new ssss();
            jobBean.set(elements2.get(0).text(), elements2.get(1).text(), elements2.get(2).text(),
                    elements2.get(3).text(), elements2.get(4).text());
            list.add(jobBean);
        }
        return list;
    }

    public static Document getDom(String strUrl) {
        try {
            URL url = new URL(strUrl);
            Document document = Jsoup.parse(url, 4000);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
