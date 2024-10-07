package com.android.scientificcalci;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RateUploder {
    public interface ConversionListener {
        void onConversionCompleted(double result);
        void onConversionFailed(Exception e);
    }

    public static void convertInBackground(double amount, String fromCurrency, String toCurrency, CurrencyConversion.ConversionListener listener) {
        new CurrencyConversion.ConversionTask(amount, fromCurrency, toCurrency, listener).execute();
    }

    private static class ConversionTask extends AsyncTask<Void, Void, Double> {
        private double amount;
        private String fromCurrency;
        private String toCurrency;
        private CurrencyConversion.ConversionListener listener;



        public ConversionTask(double amount, String fromCurrency, String toCurrency, CurrencyConversion.ConversionListener listener) {
            this.amount = amount;
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.listener = listener;
        }

        @Override
        protected Double doInBackground(Void... voids) {
            try {
                // API endpoint for exchange rates
                String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + fromCurrency;

                // Make HTTP GET request to fetch exchange rates
                URL url = new URL(apiUrl);
                String jsonResponse = getString(url);
                double exchangeRate = parseExchangeRate(jsonResponse, toCurrency);

                // Perform conversion
                double result = amount * exchangeRate;

                return result;
            } catch (IOException | NumberFormatException e) {
                Log.e("ConversionTask", "Error occurred during conversion", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Double result) {
            if (result != null) {
                listener.onConversionCompleted(result);
            } else {
                listener.onConversionFailed(new Exception("Conversion failed"));
            }
        }
    }

    private static String getString(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse JSON response to get exchange rates
        return response.toString();
    }

    private static double parseExchangeRate(String jsonResponse, String toCurrency) throws NumberFormatException {
        // Parse JSON to get exchange rate for the target currency
        // This is just a simple example, you may need a more robust JSON parser in a real-world application
        // Assuming the JSON response has a structure like {"rates": {"USD": 1.0, "EUR": 0.83, ...}}
        String[] parts = jsonResponse.split("\"" + toCurrency + "\":");
        if (parts.length >= 2) {
            String rateString = parts[1].split(",")[0];
            return Double.parseDouble(rateString);
        } else {
            throw new NumberFormatException("Exchange rate not found for " + toCurrency);
        }
    }
}
