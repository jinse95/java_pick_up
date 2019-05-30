
package javalang.继承;


abstract class AbsPdfElementVoBuilder {

    protected static String bf;

    static {
        bf = "aaaa";
        System.out.println("父类 static");
    }

    public abstract void buildPdfElementVo(String t);
}


public class PdfElementVoBuilder {

    public static String testStr;

    static {
        testStr = "23165";
        print(testStr);
    }


    public static void main(String[] args) {
        new AbsPdfElementVoBuilder(){
            @Override
            public void buildPdfElementVo(String t) {
                System.out.println(t);
            }
        }.buildPdfElementVo("子类1");


        new AbsPdfElementVoBuilder(){
            @Override
            public void buildPdfElementVo(String t) {
                System.out.println(t);
            }
        }.buildPdfElementVo("子类2");
    }

    public static void print(String ss){
        System.out.println("------" + ss);
    }
}
