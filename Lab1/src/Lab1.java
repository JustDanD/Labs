public class Lab1 {
    public class Lab1 {
        public static void main(String[] args) {
            short[] d = new short[12];
            double[] x = new double[16];
            double[][] a = new double[12][16];

            for (int i = 0; i < 12; i++)
                d[i] = (short) (i + 4);
            for (int i = 0; i < 12; i++)
                x[i] = -9.0 + Math.random() * 23;

            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 16; j++) {
                    if (d[i] == 8)
                        a[i][j] = Math.pow(2 * Math.exp(x[j]), 2 + Math.atan(Math.cos(x[j])));
                    else if (d[i] == 4 || d[i] == 5 || d[i] == 6 || d[i] == 11 || d[i] == 12 || d[i] == 13)
                        a[i][j] = Math.exp(Math.log(Math.pow(Math.cos(x[j]), 2)));
                    else {
                        double arg = (x[j] + 2.5) / 23, secpow = (0.5 - Math.pow(x[j] / (x[j] - 0.25), 2)) / Math.asin(arg) + 0.75;

                        a[i][j] = Math.cos(Math.pow(Math.cos(Math.atan(arg)), Math.atan(Math.pow(arg, 2)) * secpow));
                    }
                }
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 16; j++)
                    if (a[i][j] < 10)
                        System.out.printf("%10.5f; ", a[i][j]);
                    else
                        System.out.printf("%10.5g; ", a[i][j]);
                System.out.print("\n");
            }

        }
    }
}
