package ymtccs;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;

public class s {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);//模拟火狐浏览器
        try {
//
//            HtmlPage page = webClient.getPage("http://www.baidu.com");
//            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.setJavaScriptTimeout(5000);
            webClient.getOptions().setUseInsecureSSL(true);//接受任何主机连接 无论是否有有效证书
            webClient.getOptions().setJavaScriptEnabled(true);//设置支持javascript脚本
            webClient.getOptions().setCssEnabled(false);//禁用css支持
//            webClient.getOptions().set
            webClient.getOptions().setThrowExceptionOnScriptError(false);//js运行错误时不抛出异常
            webClient.getOptions().setTimeout(100000);//设置连接超时时间
            webClient.getOptions().setDoNotTrackEnabled(false);
//            HtmlPage page = webClient.getPage("http://blog.csdn.net/su20145104009?viewmode=contents");
            HtmlPage page = webClient.getPage("https://zhaopin.baidu.com/quanzhi?query=%E8%B0%B7%E6%AD%8C%E6%8B%9B%E8%81%98%E6%95%B0%E6%8D%AE&city_sug=%E8%B0%B7%E6%AD%8C&zp_fr=aladdin-5463-zp_exact_new");
//            String res=page.asText();
            Thread.sleep(3000);
            System.out.println(page.asXml());
            Document document = Jsoup.parse(page.asXml());
            System.out.println(document);
        } catch (FailingHttpStatusCodeException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally {
            webClient.close();
        }

    }
}