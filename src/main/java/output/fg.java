package output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class fg {

    public static String[] ss = new String[20];

    public fg() {

        String s = "The rain in Spain falls mainly in the plain.";
        // 在每个空格字符处进行分解。
        ss = s.split(" ");
    }

    public static void main(String[] args) {


            try {
                PrintStream out = System.out;// 保存原输出流
                PrintStream ps=new PrintStream("C:\\Users\\86176\\Desktop\\谷歌招聘数据.txt");// 创建文件输出流1


                System.setOut(ps);// 设置使用新的输出流
                System.out.println("使用新的输出流将log输出到 E:/log.txt");
                fg demo = new fg();
                for (int i = 0; i < ss.length; i++)
                    System.out.println(ss[i]);


                System.setOut(out);// 恢复原有输出流
                System.out.println("程序运行完毕，恢复为原输出流。");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

