class Solution {
        public int maxPoints(int[][] points) {
        if (points.length <=2) return points.length;
        int c = 2;

        for (int i = 0; i <= points.length-3; ++i) {

            int xc1 = points[i][0];
            int yc1 = points[i][1];

            int base = 2;
            for (int j = i + 1; j <= points.length-2; ++j) {
                int xc2 = points[j][0];
                int yc2 = points[j][1];
                int lc = base;

                if (xc1 == xc2 && yc1 == yc2) {
                    base++;
                    lc = base;
                    if (lc > c) c = lc;
                    continue;
                }

                for (int k = j + 1; k <= points.length-1; ++k) {
                    int xc3 = points[k][0];
                    int yc3 = points[k][1];

                    // is p1, p2 and p3 on the one line
                    if (xc1 == xc2) {
                        if (xc1 == xc3) lc++;
                    } else {
                        long i1 = (long)(yc2 - yc1) * (long)(xc3 - xc2);
                        long i2 = (long)(yc3 - yc2) * (long)(xc2 - xc1);
                        if (i1 == i2) lc++;
                    }
                }

                if (lc > c) c = lc;
            }

        }

        return c;
    }
}