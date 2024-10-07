package com.android.scientificcalci;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class CurrencyConver extends Fragment implements CurrencyConversion.ConversionListener, View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    TextView input, output;
    String user_input = "";
    AppCompatButton cut, ac, equal;
    Spinner select_item1, select_item2;
    String from_currency, to_currency;

    AppCompatButton btn1, btn2, btn3, btn4,btn5,btn6, btn7, btn8, btn9, btn0, btnFloat, btnDoubleZero;

    private final String[] currencies = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD", "KRW", "SGD", "NOK", "MXN", "INR", "RUB", "ZAR", "HKD", "BRL", "TRY"};

    public CurrencyConver() {
        // Required empty public constructor
    }

    public static CurrencyConver newInstance(String param1, String param2) {
        CurrencyConver fragment = new CurrencyConver();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_conver, container, false);

        input = view.findViewById(R.id.inputcurrency);
        output = view.findViewById(R.id.outputcurrency);
        select_item1 = view.findViewById(R.id.from_currency);
        select_item2 = view.findViewById(R.id.to_currency);
        cut = view.findViewById(R.id.cut);
        ac = view.findViewById(R.id.ac);
        equal = view.findViewById(R.id.equals);

        // Finding The Views of Operational Buttons
        btn1 = view.findViewById(R.id.one);
        btn2 = view.findViewById(R.id.two);
        btn3 = view.findViewById(R.id.three);
        btn4 = view.findViewById(R.id.four);
        btn5=view.findViewById(R.id.five);
        btn6=view.findViewById(R.id.six);
        btn7 = view.findViewById(R.id.seven);
        btn8 = view.findViewById(R.id.eight);
        btn9 = view.findViewById(R.id.nine);
        btn0 = view.findViewById(R.id.zero);

        btnFloat = view.findViewById(R.id.float_value);
        btnDoubleZero = view.findViewById(R.id.double_zero);

        // Set onClick listeners for all buttons
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnFloat.setOnClickListener(this);
        btnDoubleZero.setOnClickListener(this);

        // Setting An Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_item1.setAdapter(adapter);
        select_item2.setAdapter(adapter);

        select_item1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from_currency = currencies[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        select_item2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_currency = currencies[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        cut.setOnClickListener(v -> {
            if (!user_input.isEmpty()) {
                user_input = user_input.substring(0, user_input.length() - 1);
                input.setText(user_input);
            }
        });

        ac.setOnClickListener(v -> {
            user_input = "";
            input.setText(user_input);
        });

        equal.setOnClickListener(v -> {
            if (!user_input.isEmpty()) {
                double inputAmount = Double.parseDouble(user_input);
                CurrencyConversion.convertInBackground(inputAmount, from_currency, to_currency, CurrencyConver.this);
            }
        });

        return view;
    }

    @Override
    public void onConversionCompleted(double result) {
        String res = String.valueOf(result);
        if (res.contains(".0")) {
            output.setText(String.valueOf((int) result));
        } else {
            output.setText(String.valueOf((float) result));
        }
    }

    @Override
    public void onConversionFailed(Exception e) {
        Toast.makeText(getContext(), "Conversion failed. Please try again later.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        AppCompatButton current = (AppCompatButton) view;
        user_input += current.getText().toString();
        input.setText(user_input);
    }
}
