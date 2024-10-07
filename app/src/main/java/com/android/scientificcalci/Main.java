package com.android.scientificcalci;

import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Main extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Calculator Main Declaration
    // Declare buttons and text views
    AppCompatButton equal, cut, all_clear;

    View switch_button;


    Intent currency_layout, unit_layout;

    TextView main_calculator, currency, unit_conversion;

    TableLayout scientific_row;  // Row Contains Invisible Part of Calculator Two Rows
    AppCompatButton[] Scientific_column = new AppCompatButton[5];

    AppCompatButton[] non_scientific = new AppCompatButton[20];

    boolean visible_state = false;


    TextView input_values, result;
    AppCompatImageButton history_btn, history;

    String expression = ""; // String to hold the expression

    private AppCompatButton btnBracketOpen, btnTan, btnCos, btnSin, btnSquare, btnBracketClose,
            btnDegree, btnLog, btnInv, btnExponential, btnFactorial, btnAC, btnMultiply,
            btnMod, btnDivision, btnPower, btnSeven, btnEight, btnNine, btnSum, btnSquareRoot,
            btnFour, btnFive, btnSix, btnSubtract, btnPie, btnOne, btnTwo, btnThree, btnCut,
            btnRad, btnDoubleZero, btnZero, btnFloatValue, btnEquals;

    private static final String HISTORY_PREFS_KEY = "history";

    private ArrayList<String> history_list = new ArrayList<>();


    public Main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Main.
     */
    // TODO: Rename and change types and number of parameters
    public static Main newInstance(String param1, String param2) {
        Main fragment = new Main();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        equal = view.findViewById(R.id.equals);
        cut = view.findViewById(R.id.cut);
        all_clear = view.findViewById(R.id.ac);
        input_values = view.findViewById(R.id.input);
        result = view.findViewById(R.id.result);
        history_btn = view.findViewById(R.id.history_btn);
        scientific_row = view.findViewById(R.id.scientific_row);

        // row views
        // Find views using getView().findViewById() for consistency
        Scientific_column[0] = view.findViewById(R.id.factorial);
        Scientific_column[1] = view.findViewById(R.id.power);
        Scientific_column[2] = view.findViewById(R.id.square_root);
        Scientific_column[3] = view.findViewById(R.id.pie);
        Scientific_column[4] = view.findViewById(R.id.rad);

        // non Scientifc Calci
        non_scientific[0] = view.findViewById(R.id.ac);
        non_scientific[1] = view.findViewById(R.id.cut);
        non_scientific[2] = view.findViewById(R.id.mod);
        non_scientific[3] = view.findViewById(R.id.division);
        non_scientific[4] = view.findViewById(R.id.seven);
        non_scientific[5] = view.findViewById(R.id.eight);
        non_scientific[6] = view.findViewById(R.id.nine);
        non_scientific[7] = view.findViewById(R.id.multiply);
        non_scientific[8] = view.findViewById(R.id.four);
        non_scientific[9] = view.findViewById(R.id.five);
        non_scientific[10] = view.findViewById(R.id.six);
        non_scientific[11] = view.findViewById(R.id.subtract);
        non_scientific[12] = view.findViewById(R.id.one);
        non_scientific[13] = view.findViewById(R.id.two);
        non_scientific[14] = view.findViewById(R.id.three);
        non_scientific[15] = view.findViewById(R.id.sum);
        non_scientific[16] = view.findViewById(R.id.double_zero);
        non_scientific[17] = view.findViewById(R.id.zero);
        non_scientific[18] = view.findViewById(R.id.float_value);
        non_scientific[19] = view.findViewById(R.id.equals);


        // FInding the ids of button for on click views

        // Initialize all buttons by finding their IDs
        btnBracketOpen = view.findViewById(R.id.bracket_open);
        btnTan = view.findViewById(R.id.tan);
        btnCos = view.findViewById(R.id.cos);
        btnSin = view.findViewById(R.id.sin);
        btnSquare = view.findViewById(R.id.square);
        btnBracketClose = view.findViewById(R.id.bracket_close);
        btnDegree = view.findViewById(R.id.degree);
        btnLog = view.findViewById(R.id.log);
        btnInv = view.findViewById(R.id.inv);
        btnExponential = view.findViewById(R.id.exponentail);
        btnFactorial = view.findViewById(R.id.factorial);
        btnMultiply = view.findViewById(R.id.multiply);
        btnMod = view.findViewById(R.id.mod);
        btnDivision = view.findViewById(R.id.division);
        btnPower = view.findViewById(R.id.power);
        btnSeven = view.findViewById(R.id.seven);
        btnEight = view.findViewById(R.id.eight);
        btnNine = view.findViewById(R.id.nine);
        btnSum = view.findViewById(R.id.sum);
        btnSquareRoot = view.findViewById(R.id.square_root);
        btnFour = view.findViewById(R.id.four);
        btnFive = view.findViewById(R.id.five);
        btnSix = view.findViewById(R.id.six);
        btnSubtract = view.findViewById(R.id.subtract);
        btnPie = view.findViewById(R.id.pie);
        btnOne = view.findViewById(R.id.one);
        btnTwo = view.findViewById(R.id.two);
        btnThree = view.findViewById(R.id.three);
        btnRad = view.findViewById(R.id.rad);
        btnDoubleZero = view.findViewById(R.id.double_zero);
        btnZero = view.findViewById(R.id.zero);
        btnFloatValue = view.findViewById(R.id.float_value);


        // adding listners on the button
        // Set click listeners for all buttons
        btnBracketOpen.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnBracketClose.setOnClickListener(this);
        btnDegree.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnInv.setOnClickListener(this);
        btnExponential.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnSquareRoot.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnPie.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnDoubleZero.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnFloatValue.setOnClickListener(this);


        // Performing Operations

        // Set click listeners for buttons
        equal.setOnClickListener(v -> {
            Equal();
        });

        cut.setOnClickListener(v -> Cut());

        // Clear the expression
        all_clear.setOnClickListener(v -> ac());


        history_btn.setOnClickListener(v -> {
            if (!visible_state) {
                scientific_row.setVisibility(View.VISIBLE);
                for (AppCompatButton appCompatButton : Scientific_column) {
                    appCompatButton.setVisibility(View.VISIBLE);
                }
                button_Visible();
                visible_state = true;

            } else {
                scientific_row.setVisibility(View.GONE);
                for (AppCompatButton appCompatButton : Scientific_column) {
                    appCompatButton.setVisibility(View.GONE);
                }

                button_gone();
                visible_state = false;

            }

        });


        return view;
    }


    // Method to clear the expression
    private void ac() {
        expression = ""; // Reset expression
        input_values.setText(expression); // Clear input display
    }

    private void Equal() {
        if (!expression.isEmpty()) {
            double solved_result = Scientific_Calculation.expression(expression);

            // Check if the result is NaN
            if (Double.isNaN(solved_result)) {
                // Handle invalid expression scenario, for example, display an error message
                Toast.makeText(getContext(), "Invalid expression", Toast.LENGTH_SHORT).show();
                return; // Exit the method
            }

            String result = String.valueOf((float) solved_result);
            if (result.contains(".0")) {
                this.result.setText(String.valueOf((long) solved_result));
            } else {



                this.result.setText(result);
            }
        } else {
            // Handle empty expression scenario, for example, display an error message
            input_values.setText(result.getText());
            expression = input_values.getText().toString();
            result.setText("");
        }

    }


    private void Cut() {
        if (!expression.isEmpty()) {
            expression = expression.substring(0, expression.length() - 1); // Remove last character
            input_values.setText(expression); // Update input display
        }
    }

    // The Method Initilizes The App Compact Buttons of Scientifc Calculator Which are Present in ROw


    public int dpToPixels(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public void button_gone() {
        for (AppCompatButton appCompatButton : non_scientific) {

            ViewGroup.LayoutParams params = appCompatButton.getLayoutParams();
            params.height = dpToPixels(70);
            params.width = dpToPixels(70);
            appCompatButton.setLayoutParams(params);

        }
    }

    public void button_Visible() {
        for (AppCompatButton appCompatButton : non_scientific) {

            ViewGroup.LayoutParams params = appCompatButton.getLayoutParams();
            params.height = dpToPixels(50);
            params.width = dpToPixels(50);
            appCompatButton.setLayoutParams(params);

        }
    }


    @Override
    public void onClick(View view) {

        AppCompatButton current_btn = (AppCompatButton) view;
        String current_text = current_btn.getText().toString();
        expression += current_text; // Append clicked button's text to expression
        input_values.setText(expression); // Update input display

    }


}