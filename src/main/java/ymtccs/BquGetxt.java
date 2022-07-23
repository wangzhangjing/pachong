package ymtccs;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BquGetxt {

        // ��ȡĿ����ַ���ӵ�һ�¿�ʼ��ȡ��ֱ�����һ��
        private static String url = "https://www.bxwxorg.com/read/179910/670732.html";
        // ����ļ�����(һ��Ϊ����)������������������ø������������͹���
        private static String fileName = "��ձ˰�";


        // �ո��ĸ�λ��
        private static String space = "    ";
        // �ļ������
        private static FileWriter writer;
        // ������
        private static int pageCount = 1;

        // �����ຯ��
        public static void main(String[] args) throws Exception {
            // ��ʼ������

            getWriter();
            long l = System.currentTimeMillis();
            // ѭ����ȡС˵
            do {
                Element element = nextPage(url);
                outputToFile(element);
                url = hasNext(element);
            } while (url != null);
            writer.close();
            long time = (System.currentTimeMillis() - l) / 1000;
            System.out.println("\n\n �ɹ���ȡ�����½ڣ���ʱ" + time + "��");

        }


        // ��ȡҳ��
        private static Element nextPage(String url) throws Exception{
            // ��ȡ����ʵ����α����������
            Connection con= Jsoup.connect(url);
            String cook="__51cke__=; jieqiVisitTime=jieqiArticlesearchTime%3D1649596102; jieqiVisitId=article_articleviews%3D262; __tins__21281617=%7B%22sid%22%3A%201649596077740%2C%20%22vd%22%3A%203%2C%20%22expires%22%3A%201649597907324%7D; __51laig__=3";
            //����ͷ���ã��ر���cookie����
            con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            con.header("Content-Type", "Content-type, application/json;charset=gbk");
            con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
            con.header("Cookie", cook);
            //����������
            return con.execute().parse().body();
        }

        // ��ȡ��ǰ�½ڱ���
        private static String getTitle(Element element) {
            return element.select(".bookname h1").text();
        }

        // ��ȡ�½ھ�������
        private static String getContent(Element element) {
            // ɾ���ײ�P��ǩ�Ĺ������
            element.select("p[style=color: #999;font-size: 10px;line-height: 18px;]").remove();
            // ��ȡ��IDΪcontent������HTML����
            String body = element.select("#content").html();
            // ��body���д�������������ʽ������
            body = body.replace("&nbsp;&nbsp;&nbsp;&nbsp;", space);
            body = body.replace("<p>", "  ");
            body = body.replace("</p>", "\n");
            return body.replace(" \n \n", "\r\n");
        }

        // �Ƿ�����һҳ���з�����һҳURL��ַ��û�оͷ���NULL
        private static String hasNext(Element element) {
            // �ҵ�"��һ��"�İ�ť����ȡ��ת��Ŀ���ַ
            Elements div = element.getElementsByClass("bottem2").select("#A3");
            String href = div.attr("href");
            // ͨ���۲������һ�µ�ʱ��URL����.html��β��������ʱ����ת����ҳ��ͨ������ص��ж��Ƿ������һ��
            String url1 = "https://www.bxwxorg.com/read/179910/";
            String url2 = "https://www.bxwxorg.com";
//            return href.endsWith(".html") ? "https://www.bxwxorg.com/read/899/" + href : null;
            url2 =url2.concat(href);

            if (null!=url2){
                return url2;
            }else {
                return null;
            }
        }

        // ��ȡ�����
        private static void getWriter() throws IOException {
            String path = "D:\\workspace\\SparkProject\\pachong\\" + fileName + ".txt";
            File file = new File(path);
            if (file.exists()) {
                System.out.println("Ŀ���鼮�Ѵ��ڣ����޸��ļ����ƻ�ɾ��ԭ�鼮��" + path);
                System.exit(0);
            }

            writer = new FileWriter(file);
        }

        // ������ļ�
        private static void outputToFile(Element element) throws IOException, InterruptedException {
            String title = getTitle(element);
            String content = getContent(element);
            String text = space + title + "\r\n\r\n" + content;
            writer.write(text);
            writer.flush();
            System.out.println("==>>��" + title + "����ȡ��ɣ�������ȡ��һ�£���" + pageCount++ + "�β�����");
//                    sleep(10*1000);
                    //�������д���Լ�Ҫ���е��߼�����
//                    System.out.println("10������һ��");

        }

    }

