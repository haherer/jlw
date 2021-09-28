package StringTest;

public class StringText {
    public static void main(String[] args) {
        System.out.println("abc".isEmpty());
        StringBuffer sb = new StringBuffer();
        sb.append("123");
        sb.append("456");
        System.out.println(sb);

        System.out.println("fafsfdas".replace("fa","http"));
        System.out.println("errewqwe".substring(0,3));

/*        int[] nub = new int[3];
        for (int i = 0; i < nub.length; i++) {
            System.out.println(nub[i]);
        }*/
/*        int[][] nub = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i = 0; i < nub.length; i++) {
            for (int j = 0; j < nub[i].length; j++) {
                System.out.print(nub[i][j]);
            }
            System.out.println();
        }*/
//        new StringBuffer().append("123").append("321").append(999);

        System.out.println(new StringBuffer().append("123").append("321").append(999));
    }
}
