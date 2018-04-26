import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    private static List<Integer> getPrimeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }

    public void displayPrimeFactors(String arg) {
        System.out.println("Primefactors of "+ arg);
        for (Integer integer : getPrimeFactors(Integer.parseInt(arg))) {
            System.out.print(integer + " ");
        }
    }
}
