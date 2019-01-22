/**
 * Solution class
 *
 * @author ZhaoMing
 * @data 2019/1/15
 */
package cn.stylefeng.guns.modular.zhao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Solution {
    int removeDuplicates(int[] nums);

    List<List<Integer>> combinationSum(int[] candidates, int target);
}


class SortArraySolution implements Solution{

    @Override
    public int removeDuplicates(int[] nums) {
//        long start = System.currentTimeMillis();
//        if(nums.length == 0){return 0;}
//        if(nums.length == 1){return 1;}
//        int number = 0 ;
//        int length = nums.length;
//        for (int i = 0; i < length ; i++) {
//            if(nums[i] != nums[number]){
//                number++;
//                nums[number] = nums[i];
//
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println((Long)(end - start));
//        return ++number;

        if (nums.length == 0) {return 0;};
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,5,5,7,7,9};
        SortArraySolution sortArraySolution = new SortArraySolution();
        int line = sortArraySolution.removeDuplicates(nums);
        System.out.println(line);
    }
}


/**
 * @description
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
class CombinedSummationSolution implements Solution{

    @Override
    public int removeDuplicates(int[] nums) {
        return 0;
    }

    /**
     *
     * @param candidates
     * @param target
     * @return
     *
     */
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        findArray(listAll,list,candidates,target,0);
        return listAll;
    }

    //递归
    public void findArray(List<List<Integer>> listAll,List<Integer> list,int[] candidates, int target,int num){
        if(target == 0){
            listAll.add(list);
            return;
        }
        /**
         * 如果排序数组的最小元素小于target，则无解
         */
        if(target < candidates[0]){return;}

        for(int i = num ;i < candidates.length && candidates[i] <= target ; i++){
            //深拷贝
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            findArray(listAll,temp,candidates,target-candidates[i],i);

        }
    }

    public static void main(String[] args) {
        CombinedSummationSolution solution = new CombinedSummationSolution();
        int[] candidates = new int[]{2,3,5};
        int target = 8 ;
        List<List<Integer>> result = solution.combinationSum(candidates,8);
        for (List<Integer> item: result) {
            System.out.println(item.toString());
        }

        //可以用二叉树的思想理解递归
    }

    /**
     * 解法二
     *
     * class Solution {
     *     private List<List<Integer>> ret;
     *
     *      public List<List<Integer>> combinationSum(int[] candidates, int target) {
     *          ret = new ArrayList<>();
     *          doCombination(candidates, target, 0, new ArrayList<>());
     *          return ret;
     *      }
     *
     *      private void doCombination(int[] candidates, int target, int start, List<Integer> list) {
     *          if (target == 0) {
     *              ret.add(new ArrayList<>(list));
     *              return;
     *          }
     *          for (int i = start; i < candidates.length; i++) {
     *              if (candidates[i] <= target) {
     *                  list.add(candidates[i]);
     *                  doCombination(candidates, target - candidates[i], i, list);
     *                  list.remove(list.size() - 1);
     *              }
     *          }
     *      }
     * }
     */
}