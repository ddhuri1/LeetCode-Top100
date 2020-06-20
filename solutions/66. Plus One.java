class Solution 
{
    public int[] plusOne(int[] digits) 
    {
        int carry = 0;
        if(digits == null || digits.length < 1) 
        {
            int[] array = new int[1];
            array[0] = 1;
            return array;
        }
        int len = digits.length - 1;
        if(digits[len] <=8)
            digits[len] += 1;
        else
        {
            for(int i = digits.length-1 ; i >=0 ; i--)
            { 
                if((digits[i] + 1) == 10)
                {
                    digits[i] = (digits[i] + 1) % 10;
                    carry = 1;
                }
                else
                {
                    digits[i] = (digits[i] + 1);
                    carry = 0;
                    break;
                }
            }
            if(carry == 1)
            {
                int[] newa = new int[digits.length + 1];
                newa[0] = 1;
                for(int j = 1; j < newa.length; j ++)
                {
                    newa[j] = digits[j-1];
                }
                return newa;
            }
        }
        return digits;   
    }
}