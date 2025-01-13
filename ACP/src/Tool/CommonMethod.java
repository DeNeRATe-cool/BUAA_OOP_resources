package Tool;

import MyType.Pair;

public class CommonMethod {
    public static Pair courseTime2Pair(String arg) {
        int l = Integer.valueOf(arg.substring(2).split("-")[0]);
        int r = Integer.valueOf(arg.split("-")[1]);

        // Test
//        System.out.println("课程开始时间: " + l + " 课程结束时间: " + r);

        return new Pair(l, r);
    }

    public static int getWeekday(String arg) {
        return Integer.valueOf(arg.split("_")[0]);
    }

    public static boolean periodConflict(int weekdayA, Pair a, int weekdayB, Pair b) {
        if (weekdayA != weekdayB) return false;
        if(Math.min(a.first(), a.second()) > Math.max(b.first(), b.second()) ||
            Math.max(a.first(), a.second()) < Math.min(b.first(), b.second())) return false;
        return true;
    }
}
