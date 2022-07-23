package xiaochongzhi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uilPool {
    public static void main(String[] args ) throws IOException {
    getuil("https://zhaopin.baidu.com/quanzhi?query=%E8%B0%B7%E6%AD%8C%E6%8B%9B%E8%81%98%E6%95%B0%E6%8D%AE&city_sug=%E8%B0%B7%E6%AD%8C&zp_fr=aladdin-5463-zp_exact_new");


    }

    private static void getuil(String s) throws IOException {
        Map<String,Boolean> oldmap = new LinkedHashMap<String,Boolean>();
        String oldLinkHost = "";
        Pattern p = Pattern.compile("(https?://)?[^/\\s]*");
        Matcher m =p.matcher(s);
        if(m.find()){
            oldLinkHost = m.group();
        }
        oldmap.put(s,false);
        oldmap = crawlLinks(oldLinkHost,oldmap);
        for (Map.Entry<String,Boolean>mapping : oldmap.entrySet()) {
            System.out.println("链接："+mapping.getKey());


        }

    }

    private static Map<String, Boolean> crawlLinks(String oldLinkHost, Map<String, Boolean> oldmap) {
        Map<String,Boolean> newmap = new LinkedHashMap<String, Boolean>();
        String oldLink = "";
        for (Map.Entry<String,Boolean>mapping : oldmap.entrySet()) {
            System.out.println("链接："+mapping.getKey()+"-----check:"+mapping.getValue());
            if (mapping.getValue()){}
            oldLink = mapping.getKey();
            try{
                URL url =new URL(oldLink);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == 200){
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    Pattern p = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+[\"']?.)");
                    Matcher matcher = null;
                    String line ="";
                    while ((line = reader.readLine()) !=null){
                        matcher = p.matcher(line);
                        if(matcher.find()){
                            String newlink = matcher.group(1).trim();
                            if(!newlink.startsWith("http")){
                                if(newlink.startsWith("/")){
                                newlink=oldLinkHost +newlink;
                            }else{
                                newlink = oldLinkHost +"/" +newlink;
                            }
                        }
                        if (newlink.endsWith("/")) {
                            newlink = newlink.substring(0,newlink.length()-1);
                            }
                        if(!oldmap.containsKey(newlink)
                            && !newmap.containsKey(newlink)
                            && newlink.startsWith(oldLinkHost)){
                            newmap.put(newlink,false);
                        }

                        }
                    }

                }
            }catch (Exception e){

            }finally {

            }
            oldmap.replace(oldLink,false,true);
        }
        if (!newmap.isEmpty()){
            oldmap.putAll(newmap);
            oldmap.putAll(crawlLinks(oldLinkHost,oldmap));

        }
        return oldmap;

    }

}

