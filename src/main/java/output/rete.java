package output;

import java.io.IOException;

public class rete {
    public static void main(String[] args) throws IOException {
        String[] str = {"广州-番禺区","1年经验","大专","招若干人"};
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buf.append(str[i]).append(",");
        }
        String str1 = buf.substring(0,buf.length()-1);
        String[] str2 = str1.split(",", 4);
        for ( int  i= 0 ;i<str.length;i++){

        }
        String s = str[0].replace('[', ' ');
        String a =  s.replace(']', ' ');
        System.out.println(a.replace('"', ' '));
        String sq = str[1].replace('[', ' ');
        String aq =  sq.replace(']', ' ');
        System.out.println(aq.replace('"', ' '));
        String sw = str[2].replace('[', ' ');
        String aw =  sw.replace(']', ' ');
        System.out.println(aw.replace('"', ' '));
        String se = str[3].replace('[', ' ');
        String ae =  se.replace(']', ' ');
        System.out.println(ae.replace('"', ' '));


    }
}