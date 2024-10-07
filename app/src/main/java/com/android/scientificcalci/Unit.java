package com.android.scientificcalci;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Unit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Unit extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CardView card1, card2, card3, card4, card5, card6, card7, card8;
    LinearLayout card_layout;
    RelativeLayout field;
    View Unit_Conv_button,switch_button;

    View buttonLayout;


    private ImageView back_btn;
    Spinner from_unit, to_unit;


    TextView input, output, main_screen, currency_screen, unit_screen;
    String input_txt = "";

    String selected_unit1, selected_unit2;

    AppCompatButton AC, cut, equals;

    View Cards;

    int flag = 0;

    View card;



    AppCompatButton btn1, btn2, btn3, btn4,btn5,btn6, btn7, btn8, btn9, btn0, btnFloat, btnDoubleZero;



    // Create an ArrayList to store units of length
    ArrayList<String> lengthUnits = new ArrayList<>();
    ArrayList<String> areaUnits = new ArrayList<>();
    ArrayList<String> volumeUnits = new ArrayList<>();
    ArrayList<String> speedUnits = new ArrayList<>();
    ArrayList<String> weightUnits = new ArrayList<>();
    ArrayList<String> temperatureUnits = new ArrayList<>();
    ArrayList<String> powerUnits = new ArrayList<>();
    ArrayList<String> pressureUnits = new ArrayList<>();

    public Unit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Unit.
     */
    // TODO: Rename and change types and number of parameters
    public static Unit newInstance(String param1, String param2) {
        Unit fragment = new Unit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_unit, container, false);


        different_unit();

        // Create ArrayAdapter for each ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, lengthUnits);
        ArrayAdapter<String> areaAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, areaUnits);
        ArrayAdapter<String> volumeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, volumeUnits);
        ArrayAdapter<String> speedAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, speedUnits);
        ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, weightUnits);
        ArrayAdapter<String> temperatureAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, temperatureUnits);
        ArrayAdapter<String> powerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, powerUnits);
        ArrayAdapter<String> pressureAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, pressureUnits);

        // Set dropdown layout style for each adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperatureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        powerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pressureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);




        Cards =view.findViewById(R.id.unit_card);
        // Finding The Ids of Cards
        card1 = Cards.findViewById(R.id.cardView1);
        card2 = Cards.findViewById(R.id.cardView2);
        card3 = Cards.findViewById(R.id.cardView3);
        card4 = Cards.findViewById(R.id.cardView4);
        card5 = Cards.findViewById(R.id.cardView5);
        card6 = Cards.findViewById(R.id.cardView6);
        card7 = Cards.findViewById(R.id.cardView7);
        card8 = Cards.findViewById(R.id.cardView8);

        // Finding Input & output Textview
        input = view.findViewById(R.id.inputUnit);
        output =view. findViewById(R.id.outputUnit);

        // Finding Views Of Buttons

        AC = view.findViewById(R.id.ac);
        equals = view.findViewById(R.id.equals);
        cut = view.findViewById(R.id.cut);


        // finding the ids of layout & views
        card_layout = view.findViewById(R.id.cards_layout);
        field = view.findViewById(R.id.field);
        Unit_Conv_button = view.findViewById(R.id.num_button);

        // finding ids of Spinner
        from_unit = view.findViewById(R.id.select_unit);
        to_unit = view.findViewById(R.id.to_unit);



        buttonLayout=view.findViewById(R.id.num_button);
        // Finding The Views of Operational Buttons
        btn1 = buttonLayout.findViewById(R.id.one);
        btn2 = buttonLayout.findViewById(R.id.two);
        btn3 = buttonLayout.findViewById(R.id.three);
        btn4 = buttonLayout.findViewById(R.id.four);
        btn5=buttonLayout.findViewById(R.id.five);
        btn6=buttonLayout.findViewById(R.id.six);
        btn7 = buttonLayout.findViewById(R.id.seven);
        btn8 = buttonLayout.findViewById(R.id.eight);
        btn9 = buttonLayout.findViewById(R.id.nine);
        btn0 = buttonLayout.findViewById(R.id.zero);
        btnFloat = buttonLayout.findViewById(R.id.float_value); // Initialize btnFloat
        btnDoubleZero = buttonLayout.findViewById(R.id.double_zero); // Initialize btnDoubleZero


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


        card1.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(adapter);
            to_unit.setAdapter(adapter);


            flag = 1;

        });

        card2.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(areaAdapter);
            to_unit.setAdapter(areaAdapter);


            flag = 2;


        });


        card3.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(volumeAdapter);
            to_unit.setAdapter(volumeAdapter);
            flag = 3;
        });


        card4.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(speedAdapter);
            to_unit.setAdapter(speedAdapter);

            flag = 4;


        });


        card5.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(weightAdapter);
            to_unit.setAdapter(weightAdapter);

            flag = 5;


        });


        card6.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(temperatureAdapter);
            to_unit.setAdapter(temperatureAdapter);

            flag = 6;


        });

        card7.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(powerAdapter);
            to_unit.setAdapter(powerAdapter);

            flag = 7;


        });

        card8.setOnClickListener(v -> {
            card_layout.setVisibility(View.INVISIBLE);
            Unit_Conv_button.setVisibility(View.VISIBLE);
            field.setVisibility(View.VISIBLE);
            from_unit.setAdapter(pressureAdapter);
            to_unit.setAdapter(pressureAdapter);
            flag = 8;


        });


        from_unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the 'from_unit' Spinner
                String selectedFromUnit = parent.getItemAtPosition(position).toString();

                // Do something with the selected item, if needed
                // For example, you can update 'selected_unit1'
                selected_unit1 = selectedFromUnit;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected, if needed
            }
        });

        to_unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the 'to_unit' Spinner
                String selectedToUnit = parent.getItemAtPosition(position).toString();

                // Do something with the selected item, if needed
                // For example, you can update 'selected_unit2'
                selected_unit2 = selectedToUnit;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected, if needed
            }
        });


        cut.setOnClickListener(v -> {
            input_txt = input_txt.substring(0, input_txt.length() - 1);
            input.setText(input_txt);
        });

        AC.setOnClickListener(v -> {
            input_txt = "";
            input.setText(input_txt);
        });


        equals.setOnClickListener(v -> {
            // Get the input value from the input field
            String inputValueStr = input.getText().toString();

            // Check if the input field is empty
            if (inputValueStr.isEmpty() || inputValueStr.equalsIgnoreCase("Enter units")) {
                Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                return;
            }

            // Parse the input value to a double
            double inputValue = Double.parseDouble(inputValueStr);

            // Check if the selected units are the same
            if (selected_unit1.equals(selected_unit2)) {
                Toast.makeText(getContext(), "Selected units are the same", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform the conversion based on the selected conversion type
            double result = 0.0; // Initialize result variable
            switch (flag) {
                case 1:
                    result = Unit_Conversion.FindLength(inputValue, selected_unit1, selected_unit2);
                    break;
                case 2:
                    result = Unit_Conversion.FindArea(inputValue, selected_unit1, selected_unit2);
                    break;
                case 3:
                    result = Unit_Conversion.FindVolume(inputValue, selected_unit1, selected_unit2);
                    break;
                case 4:
                    result = Unit_Conversion.FindSpeed(inputValue, selected_unit1, selected_unit2);
                    break;
                case 5:
                    result = Unit_Conversion.FindWeight(inputValue, selected_unit1, selected_unit2);
                    break;
                case 6:
                    result = Unit_Conversion.FindTemperature(inputValue, selected_unit1, selected_unit2);
                    break;
                case 7:
                    result = Unit_Conversion.FindPower(inputValue, selected_unit1, selected_unit2);
                    break;
                case 8:
                    result = Unit_Conversion.FindPressure(inputValue, selected_unit1, selected_unit2);
                    break;
                // Add cases for other conversions if needed
                default:
                    Toast.makeText(getContext(), "Unsupported conversion", Toast.LENGTH_SHORT).show();
                    return;
            }

            // Display the result
            output.setText(String.valueOf(result));
        });





        return view;
    }


    public void different_unit() {
        // Add units of length to the ArrayList
        lengthUnits.add("Meter");
        lengthUnits.add("Kilometer");
        lengthUnits.add("Centimeter");
        lengthUnits.add("Millimeter");
        lengthUnits.add("Mile");
        lengthUnits.add("Yard");
        lengthUnits.add("Foot");
        lengthUnits.add("Inch");


        // Units of Area
        areaUnits.add("Square Meter");
        areaUnits.add("Square Kilometer");
        areaUnits.add("Square Mile");
        areaUnits.add("Square Yard");
        areaUnits.add("Square Foot");
        areaUnits.add("Acre");

        // Units of Volume
        volumeUnits.add("Cubic Meter");
        volumeUnits.add("Liter");
        volumeUnits.add("Milliliter");
        volumeUnits.add("Cubic Foot");
        volumeUnits.add("Gallon");

        // Units of Speed
        speedUnits.add("Meter per Second");
        speedUnits.add("Kilometer per Hour");
        speedUnits.add("Mile per Hour");
        speedUnits.add("Knot");

        // Units of Weight
        weightUnits.add("Kilogram");
        weightUnits.add("Gram");
        weightUnits.add("Pound");
        weightUnits.add("Ounce");

        // Units of Temperature
        temperatureUnits.add("Celsius");
        temperatureUnits.add("Fahrenheit");
        temperatureUnits.add("Kelvin");

        // Units of Power
        powerUnits.add("Watt");
        powerUnits.add("Kilowatt");
        powerUnits.add("Horsepower");

        // Units of Pressure
        pressureUnits.add("Pascal");
        pressureUnits.add("Bar");
        pressureUnits.add("Atmosphere");
    }

    @Override
    public void onClick(View view) {
        AppCompatButton current_btn = (AppCompatButton) view;
        input_txt += current_btn.getText().toString();
        input.setText(input_txt);
    }




}