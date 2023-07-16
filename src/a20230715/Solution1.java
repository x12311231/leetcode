package a20230715;

import java.util.*;

public class Solution1 implements C{
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList<>();
                    long search =  ((long) target - nums[i] - nums[j] - nums[k]);
                    long[] arr = new long[]{nums[i], nums[j], nums[k], search};
                    Arrays.sort(arr);
                    String key = String.valueOf(arr[0])+ arr[1] + arr[2] + search;
                    if (map.containsKey(key)) {
                        continue;
                    }
                    int left = k + 1;
                    int right = nums.length - 1;
                    while (left <= right) {
                        int middle = (left + right) / 2;
                        if (search > nums[middle]) {
                            left = middle + 1;
                        } else if (search < nums[middle]) {
                            right = middle - 1;
                        } else {
                            map.put(key, true);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add((int) search);
                            lists.add(list);
                            break;
                        }
                    }
                }
            }
        }
        return lists;
    }
}
