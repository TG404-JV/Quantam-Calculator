package com.android.scientificcalci;

public class Unit_Conversion {

    public static double FindLength(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Meter":
                switch (fromUnit) {
                    case "Meter":
                        return value;
                    case "Kilometer":
                        return (value * 1000.0);
                    case "Centimeter":
                        return (value / 0.01);
                    case "Millimeter":
                        return (value / 0.001);
                    case "Mile":
                        return (value * 1609.344);
                    case "Yard":
                        return (value * 0.9144);
                    case "Foot":
                        return (value * 0.3048);
                    case "Inch":
                        return (value * 0.0254);
                }
                break;
            case "Kilometer":
                switch (fromUnit) {
                    case "Meter":
                        return (value / 1000.0);
                    case "Kilometer":
                        return value;
                    case "Centimeter":
                        return (value / 100000.0);
                    case "Millimeter":
                        return (value / 1000000.0);
                    case "Mile":
                        return (value * 1.609344);
                    case "Yard":
                        return (value * 0.0009144);
                    case "Foot":
                        return (value * 0.0003048);
                    case "Inch":
                        return (value * 0.0000254);
                }
                break;
            case "Centimeter":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 100.0);
                    case "Kilometer":
                        return (value * 100000.0);
                    case "Centimeter":
                        return value;
                    case "Millimeter":
                        return (value / 0.1);
                    case "Mile":
                        return (value * 160934.4);
                    case "Yard":
                        return (value * 91.44);
                    case "Foot":
                        return (value * 30.48);
                    case "Inch":
                        return (value * 2.54);
                }
                break;
            case "Millimeter":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 1000.0);
                    case "Kilometer":
                        return (value * 1000000.0);
                    case "Centimeter":
                        return (value * 10.0);
                    case "Millimeter":
                        return value;
                    case "Mile":
                        return (value * 1609344.0);
                    case "Yard":
                        return (value * 914.4);
                    case "Foot":
                        return (value * 304.8);
                    case "Inch":
                        return (value * 25.4);
                }
                break;
            case "Mile":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 0.000621371);
                    case "Kilometer":
                        return (value * 0.621371);
                    case "Centimeter":
                        return (value * 0.00000621371);
                    case "Millimeter":
                        return (value * 0.000000621371);
                    case "Mile":
                        return value;
                    case "Yard":
                        return (value * 1760.0);
                    case "Foot":
                        return (value * 5280.0);
                    case "Inch":
                        return (value * 63360.0);
                }
                break;
            case "Yard":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 1.09361);
                    case "Kilometer":
                        return (value * 1093.61);
                    case "Centimeter":
                        return (value * 0.0109361);
                    case "Millimeter":
                        return (value * 0.00109361);
                    case "Mile":
                        return (value * 0.000568182);
                    case "Yard":
                        return value;
                    case "Foot":
                        return (value * 3.0);
                    case "Inch":
                        return (value * 36.0);
                }
                break;
            case "Foot":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 3.28084);
                    case "Kilometer":
                        return (value * 3280.84);
                    case "Centimeter":
                        return (value * 0.0328084);
                    case "Millimeter":
                        return (value * 0.00328084);
                    case "Mile":
                        return (value * 0.000189394);
                    case "Yard":
                        return (value * 0.333333);
                    case "Foot":
                        return value;
                    case "Inch":
                        return (value * 12.0);
                }
                break;
            case "Inch":
                switch (fromUnit) {
                    case "Meter":
                        return (value * 39.3701);
                    case "Kilometer":
                        return (value * 39370.1);
                    case "Centimeter":
                        return (value * 0.393701);
                    case "Millimeter":
                        return (value * 0.0393701);
                    case "Mile":
                        return (value * 0.000015783);
                    case "Yard":
                        return (value * 0.0277778);
                    case "Foot":
                        return (value * 0.0833333);
                    case "Inch":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindArea(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Square Meter":
                switch (fromUnit) {
                    case "Square Meter":
                        return value;
                    case "Square Kilometer":
                        return value * 1e+6;
                    case "Square Mile":
                        return value * 2.58999e+6;
                    case "Square Yard":
                        return value * 0.836127;
                    case "Square Foot":
                        return value * 0.092903;
                    case "Acre":
                        return value * 4046.86;
                }
                break;
            case "Square Kilometer":
                switch (fromUnit) {
                    case "Square Meter":
                        return value * 1e-6;
                    case "Square Kilometer":
                        return value;
                    case "Square Mile":
                        return value * 2.58999;
                    case "Square Yard":
                        return value * 1.19599e+6;
                    case "Square Foot":
                        return value * 1.07639e+7;
                    case "Acre":
                        return value * 247.105;
                }
                break;
            case "Square Mile":
                switch (fromUnit) {
                    case "Square Meter":
                        return value * 3.861e-7;
                    case "Square Kilometer":
                        return value * 0.386102;
                    case "Square Mile":
                        return value;
                    case "Square Yard":
                        return value * 3.0976e+6;
                    case "Square Foot":
                        return value * 2.788e+7;
                    case "Acre":
                        return value * 640;
                }
                break;
            case "Square Yard":
                switch (fromUnit) {
                    case "Square Meter":
                        return value * 1.19599;
                    case "Square Kilometer":
                        return value * 8.3613e-7;
                    case "Square Mile":
                        return value * 3.22831e-7;
                    case "Square Yard":
                        return value;
                    case "Square Foot":
                        return value * 9;
                    case "Acre":
                        return value * 4840;
                }
                break;
            case "Square Foot":
                switch (fromUnit) {
                    case "Square Meter":
                        return value * 10.7639;
                    case "Square Kilometer":
                        return value * 9.2903e-8;
                    case "Square Mile":
                        return value * 3.587e-8;
                    case "Square Yard":
                        return value * 0.111111;
                    case "Square Foot":
                        return value;
                    case "Acre":
                        return value * 43560;
                }
                break;
            case "Acre":
                switch (fromUnit) {
                    case "Square Meter":
                        return value * 0.000247105;
                    case "Square Kilometer":
                        return value * 0.00404686;
                    case "Square Mile":
                        return value * 0.0015625;
                    case "Square Yard":
                        return value * 0.000206612;
                    case "Square Foot":
                        return value * 2.29568e-5;
                    case "Acre":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindVolume(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Cubic Meter":
                switch (fromUnit) {
                    case "Cubic Meter":
                        return value;
                    case "Liter":
                        return value * 0.001;
                    case "Milliliter":
                        return value * 1e-6;
                    case "Cubic Foot":
                        return value * 0.0283168;
                    case "Gallon":
                        return value * 0.00378541;
                }
                break;
            case "Liter":
                switch (fromUnit) {
                    case "Cubic Meter":
                        return value * 1000;
                    case "Liter":
                        return value;
                    case "Milliliter":
                        return value * 0.001;
                    case "Cubic Foot":
                        return value * 28.3168;
                    case "Gallon":
                        return value * 3.78541;
                }
                break;
            case "Milliliter":
                switch (fromUnit) {
                    case "Cubic Meter":
                        return value * 1e+6;
                    case "Liter":
                        return value * 1000;
                    case "Milliliter":
                        return value;
                    case "Cubic Foot":
                        return value * 28316.8;
                    case "Gallon":
                        return value * 3785.41;
                }
                break;
            case "Cubic Foot":
                switch (fromUnit) {
                    case "Cubic Meter":
                        return value * 35.3147;
                    case "Liter":
                        return value * 0.0353147;
                    case "Milliliter":
                        return value * 3.53147e-5;
                    case "Cubic Foot":
                        return value;
                    case "Gallon":
                        return value * 7.48052;
                }
                break;
            case "Gallon":
                switch (fromUnit) {
                    case "Cubic Meter":
                        return value * 264.172;
                    case "Liter":
                        return value * 0.264172;
                    case "Milliliter":
                        return value * 2.64172e-4;
                    case "Cubic Foot":
                        return value * 0.133681;
                    case "Gallon":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindSpeed(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Meter per Second":
                switch (fromUnit) {
                    case "Meter per Second":
                        return value;
                    case "Kilometer per Hour":
                        return value * 0.277778;
                    case "Mile per Hour":
                        return value * 0.44704;
                    case "Knot":
                        return value * 0.514444;
                }
                break;
            case "Kilometer per Hour":
                switch (fromUnit) {
                    case "Meter per Second":
                        return value * 3.6;
                    case "Kilometer per Hour":
                        return value;
                    case "Mile per Hour":
                        return value * 1.60934;
                    case "Knot":
                        return value * 1.852;
                }
                break;
            case "Mile per Hour":
                switch (fromUnit) {
                    case "Meter per Second":
                        return value * 2.23694;
                    case "Kilometer per Hour":
                        return value * 0.621371;
                    case "Mile per Hour":
                        return value;
                    case "Knot":
                        return value * 1.15078;
                }
                break;
            case "Knot":
                switch (fromUnit) {
                    case "Meter per Second":
                        return value * 1.94384;
                    case "Kilometer per Hour":
                        return value * 0.539957;
                    case "Mile per Hour":
                        return value * 0.868976;
                    case "Knot":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindWeight(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Kilogram":
                switch (fromUnit) {
                    case "Kilogram":
                        return value;
                    case "Gram":
                        return value * 0.001;
                    case "Pound":
                        return value * 0.453592;
                    case "Ounce":
                        return value * 0.0283495;
                }
                break;
            case "Gram":
                switch (fromUnit) {
                    case "Kilogram":
                        return value * 1000;
                    case "Gram":
                        return value;
                    case "Pound":
                        return value * 453.592;
                    case "Ounce":
                        return value * 28.3495;
                }
                break;
            case "Pound":
                switch (fromUnit) {
                    case "Kilogram":
                        return value * 2.20462;
                    case "Gram":
                        return value * 0.00220462;
                    case "Pound":
                        return value;
                    case "Ounce":
                        return value * 16;
                }
                break;
            case "Ounce":
                switch (fromUnit) {
                    case "Kilogram":
                        return value * 35.274;
                    case "Gram":
                        return value * 0.035274;
                    case "Pound":
                        return value * 0.0625;
                    case "Ounce":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindTemperature(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Celsius":
                switch (fromUnit) {
                    case "Celsius":
                        return value;
                    case "Fahrenheit":
                        return (value - 32) * 5 / 9;
                    case "Kelvin":
                        return value - 273.15;
                }
                break;
            case "Fahrenheit":
                switch (fromUnit) {
                    case "Celsius":
                        return value * 9 / 5 + 32;
                    case "Fahrenheit":
                        return value;
                    case "Kelvin":
                        return value * 9 / 5 - 459.67;
                }
                break;
            case "Kelvin":
                switch (fromUnit) {
                    case "Celsius":
                        return value + 273.15;
                    case "Fahrenheit":
                        return (value + 459.67) * 5 / 9;
                    case "Kelvin":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindPower(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Watt":
                switch (fromUnit) {
                    case "Watt":
                        return value;
                    case "Kilowatt":
                        return value * 1000;
                    case "Horsepower":
                        return value * 745.7;
                }
                break;
            case "Kilowatt":
                switch (fromUnit) {
                    case "Watt":
                        return value / 1000;
                    case "Kilowatt":
                        return value;
                    case "Horsepower":
                        return value * 0.7457;
                }
                break;
            case "Horsepower":
                switch (fromUnit) {
                    case "Watt":
                        return value / 745.7;
                    case "Kilowatt":
                        return value / 0.7457;
                    case "Horsepower":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }

    public static double FindPressure(double value, String fromUnit, String toUnit) {
        switch (toUnit) {
            case "Pascal":
                switch (fromUnit) {
                    case "Pascal":
                        return value;
                    case "Bar":
                        return value * 100000;
                    case "Atmosphere":
                        return value * 101325;
                }
                break;
            case "Bar":
                switch (fromUnit) {
                    case "Pascal":
                        return value / 100000;
                    case "Bar":
                        return value;
                    case "Atmosphere":
                        return value * 1.01325;
                }
                break;
            case "Atmosphere":
                switch (fromUnit) {
                    case "Pascal":
                        return value / 101325;
                    case "Bar":
                        return value / 1.01325;
                    case "Atmosphere":
                        return value;
                }
                break;
        }
        return 0; // Default return value if conversion is not possible
    }


}
