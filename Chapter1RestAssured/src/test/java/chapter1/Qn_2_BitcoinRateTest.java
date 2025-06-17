package chapter1;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Random;

public class Qn_2_BitcoinRateTest {

    private final Faker faker = new Faker();
    private final Random random = new Random();

    private void printFakeCurrencyDetails(String currencyCode, String symbol, String description) {
        double rateFloat = 50000 + (random.nextDouble() * 20000); // Random rate between 50k and 70k
        String rate = String.format("%,.4f", rateFloat);

        System.out.println("Currency: " + currencyCode);
        System.out.println("Code: " + currencyCode);
        System.out.println("Symbol: " + symbol);
        System.out.println("Rate: " + rate);
        System.out.println("Description: " + description);
        System.out.println("Rate Float: " + rateFloat);
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testFakeBitcoinRateUSD() {
        printFakeCurrencyDetails("USD", "$", "United States Dollar");
    }

    @Test
    public void testFakeBitcoinRateGBP() {
        printFakeCurrencyDetails("GBP", "£", "British Pound Sterling");
    }

    @Test
    public void testFakeBitcoinRateEUR() {
        printFakeCurrencyDetails("EUR", "€", "Euro");
    }

	public Faker getFaker() {
		return faker;
	}
}
