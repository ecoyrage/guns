package cn.stylefeng.guns.modular.zhao.TopK;

public class TestSolution {
    public static void main(String[] args) {
//        int[] data = new int[10];

        //关键是数据结构是怎么样的
        /*
                  0
              1       2
            3   4   5   6
          7   8

         */

        //假设节点是x，子节点，左：
//        int x = left(0);
//        System.out.println(x);
//
//        int y = right(0);
//        System.out.println(y);


        String[] array = new String[]{"23"};
        System.out.println(array.length);
        System.out.println(array[0].equals(""));
        System.out.println(array[0]=="");


    }

    private static int left(int x){
        return ((x+1) << 1) -1;
    }
    private static int right(int x){
        return (x+1 << 1);
    }
}
