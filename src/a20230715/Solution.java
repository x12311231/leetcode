package a20230715;

import java.util.*;

public class Solution implements C{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList<>();
                    for (int l = k + 1; l < nums.length; l++) {
                        int[] arr = new int[]{nums[i], nums[j], nums[k], nums[l]};
                        Arrays.sort(arr);
                        String key = String.valueOf(arr[0])+ arr[1] + arr[2] + arr[3];
                        if (map.containsKey(key)) {
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            map.put(key, true);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
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
