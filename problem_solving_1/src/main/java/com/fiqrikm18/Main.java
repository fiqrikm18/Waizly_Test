package com.fiqrikm18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> ans = solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(ans.get(0) + " " + ans.get(1));
    }

    public static List<Long> solution(int[] arr) {
        Arrays.sort(arr);
        List<Long> ans = new ArrayList<>();

        long sum = Arrays.stream(arr).sum();
        long min = sum - arr[arr.length - 1];
        long max = sum - arr[0];

        ans.add(min);
        ans.add(max);
        return ans;
    }
}

