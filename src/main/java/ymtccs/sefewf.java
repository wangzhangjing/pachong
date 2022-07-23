package ymtccs;



import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

   public class sefewf {
        public static void main(String[] args){

            //创建HttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //目标网址
            String url = "https://zhaopin.baidu.com/quanzhi?query=%E8%B0%B7%E6%AD%8C%E6%8B%9B%E8%81%98%E6%95%B0%E6%8D%AE&city_sug=%E8%B0%B7%E6%AD%8C&zp_fr=aladdin-5463-zp_exact_new";

            //创建请求方法
            HttpGet httpGet = new HttpGet(url);

            //设置Header模拟浏览器行为
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");

            try {
                //发送请求，收取响应
                CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

                if(httpResponse.getStatusLine().getStatusCode() == 200){
                    //解析响应
                    String entity = EntityUtils.toString(httpResponse.getEntity());
                    System.out.println(entity);
                }

                EntityUtils.consume(httpResponse.getEntity());
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


