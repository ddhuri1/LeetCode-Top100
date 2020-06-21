class Solution 
{
    public String fractionToDecimal(int numerator, int denominator) 
    {
        StringBuilder res = new StringBuilder();
        if(numerator == 0) return "0";
        String sign = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? "-" : "";
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        res.append(sign);
        res.append(n / d);
        long rem = n % d;
        if (rem == 0)
            return res.toString();
        res.append(".");
        //-----------------------------------------------------------
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(rem)) 
        {
            hashMap.put(rem, res.length());
            res.append(10 * rem / d);
            rem = 10 * rem % d;
        }
        int index = hashMap.get(rem);
        res.insert(index, "(");
        res.append(")");
        return res.toString().replace("(0)", "");
    }
}