class TwoDimensionArray {
    public static void main(String[] args) {
        int[][] b = { { 11 }, { 21, 22 }, { 31, 32, 33 } };
        int sum = 0;
        b[0][0] = 1000;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                sum += b[i][j];
        }
        System.out.println("b[0][0] = " + b[0][0] + '\n' +
                "sum = " + sum + '\n' +
                "b.lengh = " + b.length);

        int[][] arr1 = new int[3][4];
        int[][] arr2 = new int[3][];
        int[][] arr3 = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        int i, j, k = 0;

        // 为arr1[][]赋值，从上到下，从左到右，0-11
        int cnt = 0;
        for (i = 0; i < 3; i++) {
            // arr1为3行4列
            for (j = 0; j < 4; j++) {
                arr1[i][j] = cnt++;
            }
        }

        // 为arr2[][]开辟内存空间，arr2每一行是变长的，元素个数为3、4、5
        for (i = 0; i < 3; i++) {
            // 参考开辟内存空间：new int[2]，开辟2个int的空间
            arr2[i] = new int[3 + i];
        }

        // arr2[][]赋值，从上到下，从左到右，从0开始递增
        cnt = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = cnt++;
            }
        }

        // 输出arr1
        System.out.println(" arr1:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(" " + arr1[i][j]);
                //参考：System.out.print(" " + arr1[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 输出arr2
        System.out.println(" arr2:");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < arr2[i].length; j++) {
                System.out.print(" " + arr2[i][j]);
            }
            System.out.println();
        }

        // 输出arr3
        System.out.println(" arr3:");
        for (i = 0; i < 3; i++) {
            // arr3为3行3列
            for (j = 0; j < 3; j++) {
                System.out.print(" " + arr3[i][j]);
            }
            System.out.println();
        }
    }
}