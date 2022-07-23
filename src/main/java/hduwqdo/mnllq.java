package hduwqdo;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class mnllq {

        public static void main(String[] args){

            //创建HttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //目标网址
            String url = "https://zhaopin.baidu.com/quanzhi?query=%E8%B0%B7%E6%AD%8C%E6%8B%9B%E8%81%98%E6%95%B0%E6%8D%AE&city=%E8%B0%B7%E6%AD%8C&ua_from=pc";

            Connection con = Jsoup.connect(url);
            String cook="PSTM=1587010046; BIDUPSID=5D0039D042483C880237FFDB84426001; MCITY=-158%3A; BAIDUID=F7EE4CAA5189E54B21A602FC1DC3E079:FG=1; __yjs_duid=1_237ff908286fd06b0714827a650063cb1620208920094; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_PSSID=34440_35104_31253_35049_35097_34584_34518_35245_34812_26350_35145_22160; BDSFRCVID=g5IOJeC62AHJtu3H9bJKM60tsmm_4aOTH6f3OQ_QCT04wvtQPxqVEG0PoM8g0KubZoYLogKKLmOTHpKF_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF=tJFD_ItMtDK3jtOY5-__-4_tbh_X5-RLfKJ3Mh7F5l8-hlDw2loM-xkXMpbDW6KjbgQMabrkMC3xOKQebTOB3-AHXecw3-IttCJj2xnN3KJmHRL9bT3v5tDfbaju2-biW2JL2Mbd-pvP_IoG2Mn8M4bb3qOpBtQmJeTxoUJ25DnJhbLGe6KKDTQbjHA8q-3tat_D_D88Kb7VbpogLUnkbfJBDGjgLbQRLebHBb5PBCL2f-86Bn-2W5L7yajK2M5nWKnUbIIy54JOEn6c24rpQT8rBn_OK5Oi0Cr8_lL-ab3vOpRzXpO1KMPzBN5thURB2DkO-4bCWJ5TMl5jDh3Mb6ksD-FtqjD8JbI8oC82f-bKHJONq6_aM44Vqxby26nn06T9aJ5nJDoCftPGQtT1etD33-FqJn3e0Ccf2b4KQpP-HJ73hMRzbxPjy-jla5Q3fgrqKl0MLUOtbb0xynoDMt--jxnMBMnramOnaPJc3fAKftnOM46JehL3346-35543bRTLnLy5KJtMDF4ejthejoyjaRJbto254_toRcOKjrjDnCrLfbdXUI8LNDHQJQOBNr2aITtbnbYMCJmKPcV2tLrDnO7ttoyJIjt0I3n3tJjHl4GM57IhML1Db3gKjvMtg3t3JTjMCQoepvoX-cc3MkQyPjdJJQOBKQB0KnGbUQkeq8CQft20b0EeMtjKjLEtJKJoDt-JKK3fP36qR6sMJ8thmT22-us5bTA2hcH0KLKEqn_5b_5y5FVy4RutjOJ-KjLMKbqBMb1MRLRXpQr0ft7DaOf-J3ILTbD-q5TtUJo8DnTDMRh-lIeWtvyKMniBIj9-pnMWhQrh459XP68bTkA5bjZKxtq3mkjbPbDfn02eCKu-n5jHj5LDaD83e; delPer=0; BDSFRCVID_BFESS=g5IOJeC62AHJtu3H9bJKM60tsmm_4aOTH6f3OQ_QCT04wvtQPxqVEG0PoM8g0KubZoYLogKKLmOTHpKF_2uxOjjg8UtVJeC6EG0Ptf8g0f5; H_BDCLCKID_SF_BFESS=tJFD_ItMtDK3jtOY5-__-4_tbh_X5-RLfKJ3Mh7F5l8-hlDw2loM-xkXMpbDW6KjbgQMabrkMC3xOKQebTOB3-AHXecw3-IttCJj2xnN3KJmHRL9bT3v5tDfbaju2-biW2JL2Mbd-pvP_IoG2Mn8M4bb3qOpBtQmJeTxoUJ25DnJhbLGe6KKDTQbjHA8q-3tat_D_D88Kb7VbpogLUnkbfJBDGjgLbQRLebHBb5PBCL2f-86Bn-2W5L7yajK2M5nWKnUbIIy54JOEn6c24rpQT8rBn_OK5Oi0Cr8_lL-ab3vOpRzXpO1KMPzBN5thURB2DkO-4bCWJ5TMl5jDh3Mb6ksD-FtqjD8JbI8oC82f-bKHJONq6_aM44Vqxby26nn06T9aJ5nJDoCftPGQtT1etD33-FqJn3e0Ccf2b4KQpP-HJ73hMRzbxPjy-jla5Q3fgrqKl0MLUOtbb0xynoDMt--jxnMBMnramOnaPJc3fAKftnOM46JehL3346-35543bRTLnLy5KJtMDF4ejthejoyjaRJbto254_toRcOKjrjDnCrLfbdXUI8LNDHQJQOBNr2aITtbnbYMCJmKPcV2tLrDnO7ttoyJIjt0I3n3tJjHl4GM57IhML1Db3gKjvMtg3t3JTjMCQoepvoX-cc3MkQyPjdJJQOBKQB0KnGbUQkeq8CQft20b0EeMtjKjLEtJKJoDt-JKK3fP36qR6sMJ8thmT22-us5bTA2hcH0KLKEqn_5b_5y5FVy4RutjOJ-KjLMKbqBMb1MRLRXpQr0ft7DaOf-J3ILTbD-q5TtUJo8DnTDMRh-lIeWtvyKMniBIj9-pnMWhQrh459XP68bTkA5bjZKxtq3mkjbPbDfn02eCKu-n5jHj5LDaD83e; BAIDUID_BFESS=FC9DBEA9F955970DB5F1A6B150C045EE:FG=1; ZP_FLAG=5; ZP_FR=aladdin-5463-zp_exact_new-----check%3Afalse; PSINO=3; BA_HECTOR=2h81a18h8l00a101no1gpha000r; __yjs_st=2_ODk2OTNmYzg1ZDQ1YWM1NmJhZDVlYmJiNTk2N2ZhMWNjNWQ0NGVkMjFkNDgwNDYzYWZiOWYxZTgwNjIzNDk0YzRmYmU4MjhmNmJjODlhZjYzZDRkMGFhMzIxMzQ1ODgwNjEyNWQ0YzgzNzg3ZjNlODE0NGQwMTZkYTIwYjA3Yzc5ZjlkNDUzNWY0YjkyMDk4N2UyYzBmY2U0MjMyY2I4ZmE4ZTY2MzBkMDU1NmI1MTY1MDliOWY5NWE1YzM3MzFhMjZiZTIxZTJiMTBmODUzNDUwMWE1ZDQzYTRlODkzOThmOTA0NTBkMTExYWFjMGU2Nzc5OTM5NDhlZjczYWM4Nl83XzY5MTcyMTYz; BDUSS=05XcHZzc2NteTNubkpFOWp4MkRaVGdqazFnbk1yQklqMkgyQ2FCdEtlaWFQTUJoSUFBQUFBJCQAAAAAAAAAAAEAAAD5eF~5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJqvmGGar5hhU; BDUSS_BFESS=05XcHZzc2NteTNubkpFOWp4MkRaVGdqazFnbk1yQklqMkgyQ2FCdEtlaWFQTUJoSUFBQUFBJCQAAAAAAAAAAAEAAAD5eF~5AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJqvmGGar5hhU; Hm_lvt_da3258e243c3132f66f0f3c247b48473=1637375432,1637375598,1637396382,1637396467; Hm_lpvt_da3258e243c3132f66f0f3c247b48473=1637396467; SECKEY_CID2=5407ee10a1b2b4c4617c2c9805b7f201c250cc1c; ab_sr=1.0.1_NWYyNTU1OWQ3ZTljOTAxYzViYjE3NGY2YmFjMGZmNmJhYTk2NjlmMWViNWM5N2JiNmM3YzhmNmVmZWVhNWI5Yjk0YWEzNjU1YWY1NzQ5MWU1NTYwYjdkNWU3ZmNiMTIxNmU5MmJkY2RiMjlkZTkyNGZhNWUwYmYyMDY0NGI3OTFkN2ExY2UzYzUyYzNjODVjNGQ5ZjI2OWQwZjI5NjYwOQ==; BMAP_SECKEY2=e7ccd76a71cca7384bc9d56993ddbed2e19bbff4744b85e39bb3d65be30e7613e76ae0b8689ae7f5bb14207898aef6950e69432a9314fa542a239fa64bfb5b4505462da566eb1d7cd476c830eecff4c2fa8658ec37b37373f8f3a5199dd93fd960cc334bcfc6d3530b4c0b910fd064db81734156762dc9db61748c0b5647c145f647d8bd518a88895c35c851b516442bfcf26ff62840d936133cd5cf846e38e5fc350ea4fdcbaa4bd6bc4aa6384f8cc65c3ce293f7699c1f9d1c2e08817435e2c989f49416214b5c8cdc42653e7f0a19dac845c9a089efed9909074c91e4d250d6ab43e45b89cdf1d7212ba78c35dd1a";
            //请求头设置，特别是cookie设置
            con.header("Accept", "text/html, application/xhtml+xml, */*");
            con.header("Content-Type", "application/x-www-form-urlencoded");
            con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
            con.header("Cookie", cook);

            //创建请求方法

            HttpGet httpGet = new HttpGet(url);

            //设置Header模拟浏览器行为
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");

            try {
                //发送请求，收取响应
                CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

                if(httpResponse.getStatusLine().getStatusCode() == 200){
                    //解析响应
                    String entity = EntityUtils.toString(httpResponse.getEntity(),"UTF8");//用UTf-8解析

                    System.out.println(entity);
                }

                EntityUtils.consume(httpResponse.getEntity());
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

