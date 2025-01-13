public class StringCatch {
    /**
     * 将任意个字符串顺序连接，不应该改变任意一个原有参数
     * @param args 字符串们
     * @return args中的字符串顺序连接组成的新字符串
     */
    public static String strscat(String... args) {
        String str = "";
        for(String arg : args) {
            str += arg;
        }
        return str;
    }

//    public static String strscat(String[] arg) {
//
//    }

    public static void main(String[] args) {
//        System.out.println(strscat(new String[]{"a", "b"}));
    }
}
