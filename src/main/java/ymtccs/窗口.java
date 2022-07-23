package ymtccs;

import java.awt.Frame;
class myframe extends Frame {
    public void lunchFrame()
    {
        this.setLocation(200, 100);
        this.setSize(800, 600);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        myframe win = new myframe();
        win.lunchFrame();
    }
}