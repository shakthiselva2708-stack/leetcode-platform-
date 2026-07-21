class Solution {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int num : nums) {

            int digits = countDigits(num);

            if (digits % 2 == 0)
                count++;
        }

        return count;
    }

    private int countDigits(int num) {

        if (num == 0)
            return 1;

        int digits = 0;

        while (num != 0) {
            digits++;
            num /= 10;
        }

        return digits;
    }
}
