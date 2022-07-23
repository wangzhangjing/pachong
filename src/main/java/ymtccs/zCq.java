package ymtccs;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class zCq {
    public static void main(String[] args) throws IOException {
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        HtmlPage page=webClient.getPage("http://www.quanso.com.cn/");
        System.out.println(page.asXml());
    }
    }

