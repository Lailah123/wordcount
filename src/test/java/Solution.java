//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//    public static void main(String[] args) {
//        new Solution().twoSum(new int[]{3,2,4},6);
//    }
//}


import java.util.InputMismatchException;
import java.util.Scanner;

class Solution {
    public int numIslands(char[][] grid) {
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    //感染函数
    public void infect(char[][] grid, int i, int j) {
        //判断是否越过边界，是否是陆地
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        draw(grid);
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }

    public void draw(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == '0') {
                    System.out.print("-");
                }
                if (a[i][j] == '1') {
                    System.out.print("*");
                }
                if (a[i][j] == '2') {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}};
        new Solution().draw(a);
        System.out.println(new Solution().numIslands(a));
//        int m=(int)(Math.random()*100+1);
//        Scanner sc = new Scanner(System.in);
//        int count = 0;
//        while(true){
//            System.out.println("渣渣禾，请输入一个数字");
//            int x = 0;
//            String regx ="\\d++";
//            try {
//                x = Integer.parseInt(sc.next(regx));
//            } catch (InputMismatchException e) {
//                e.printStackTrace();
//            }
//            if(x>m){
//                System.out.println("猜大了");
//            }
//            if(x<m){
//                System.out.println("猜小了");
//            }
//            if(x==m){
//                System.out.println("猜对了");
//                break;
//            }
//            count++;
//        }
//        if(count > 4){
//            System.out.println("垃圾，这么慢");
//            System.out.println("你居然猜了 "+count+" 次！");
//            System.out.println("恕我直言 **");
//        }else {
//            System.out.println("可以兄弟！");
//        }
    }
}

//import java.util.ArrayList;
//import java.util.List;

//class Solution {
//    public boolean isPalindrome(int x) {
//        int old = x;
//        if(x<0){
//            return false;
//        }
//        if(x<10){
//            return true;
//        }
//        int[] lis = new int[String.valueOf(x).length()];
//        int count = 0;
//        while(x>0) {//记住这个规律     比如：每次用10取模会得到个位数  由于是int类型除以10只会去掉个位上的数
//            int m=x%10;
//            System.out.print(m);//这里会输出这个数的每一位
//            lis[count] = m;
//            x/=10;
//            count++;
//        }
//        int res2 = 0;
//        int length = lis.length;
//        for(int i=0;i<length;i++){
//            res2 += lis[length-1-i]*Math.pow(10,i);
//        }
//        if(old == res2){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().isPalindrome(121));
//    }
//}

//class Solution {
//    public int reverse(int x) {
//        int ans = 0;
//        while (x != 0) {
//            if ((ans * 10) / 10 != ans) {
//                ans = 0;
//                break;
//            }
//            ans = ans * 10 + x % 10;
//            x = x / 10;
//        }
//        return ans;
//    }
//}