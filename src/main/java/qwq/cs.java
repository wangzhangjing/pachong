package qwq;

public class cs {



        //成员变量列表
        private String pm;
        private String gj;
        private String dq;
        private String gdp;
        private String bfb;
        public String getPm() {
            return pm;
        }


        //有参构造方法
        public void setPm(String pm) {
            this.pm = pm;
        }
        public String getGj() {
            return gj;
        }
        public void setGj(String gj) {
            this.gj = gj;
        }
        public String getDq() {
            return dq;
        }
        public void setDq(String dq) {
            this.dq = dq;
        }
        public String getGdp() {
            return gdp;
        }
        public void setGdp(String gdp) {
            this.gdp = gdp;
        }
        public String getBfb() {
            return bfb;
        }
        public void setBfb(String bfb) {
            this.bfb = bfb;
        }


        public cs(String pm, String gj, String dq, String gdp, String bfb) {
            super();
            this.pm = pm;
            this.gj = gj;
            this.dq = dq;
            this.gdp = gdp;
            this.bfb = bfb;
        }


        @Override
        public String toString() {
            return "EntityBean [pm=" + pm + ", gj=" + gj + ", dq=" + dq + ", gdp=" + gdp + ", bfb=" + bfb + "]";
        }


        //无参构造方法

        //重写tiString()方法
    }


