/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation 
{
    public int findCelebrity(int n) 
    {
        for(int i=0, j=0; i<n; i++)
        {
            for( j=i+1; j<n; j++)
            { 
                if(knows(i, j))
                {
                    i = j - 1;
                    break;
                }
            }
            if(j == n)
            {
                for(j=0; j<n; j++)
                    if((j<i && knows(i, j)) || (j!=i && !knows(j, i)))
                        return -1;
                return i;
            }
            
        }
        return -1;
    }
}