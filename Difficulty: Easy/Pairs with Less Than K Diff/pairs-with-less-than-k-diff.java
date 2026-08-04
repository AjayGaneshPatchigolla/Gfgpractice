class Solution {
    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length,ans=0;
         for (int i = 0; i < n; i++) {
            int idx = lowerBound(arr, arr[i] + k);
            ans += idx - i - 1;
        }
        return ans;
    }
}
