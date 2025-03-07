class Solution {
    private int[] sieve(int upperLimit) {
        int[] sieve = new int[upperLimit + 1];
        Arrays.fill(sieve, 1);
        sieve[0] = 0;
        sieve[1] = 0;
        for (int number = 2; number * number <= upperLimit; number++) {
            if (sieve[number] == 1) {
                for (int multiple = number * number;multiple <= upperLimit;multiple += number)
                    sieve[multiple] = 0;
            }
        }
        return sieve;
    }
    public int[] closestPrimes(int left, int right) {
        int[] sieveArray = sieve(right);
        List<Integer> l=new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (sieveArray[num] == 1) {
                l.add(num);
            }
        }
        int x=-1;
        int y=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<l.size()-1;i++)
        {
            int diff=l.get(i+1)-l.get(i);
            if(diff<min)
            {
                min=diff;
                x=l.get(i);
                y=l.get(i+1);
            }
        }
        return new int[]{x,y};
    }
}