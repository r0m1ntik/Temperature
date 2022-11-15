package fr.univpau.temperature;

import androidx.annotation.NonNull;

public class Temperature {

    private float mValeurSource;
    private float mValeurCible;
    private String mSpinnerSource;
    private String mSpinnerCible;

    public float getValeurCible() {
        return mValeurCible;
    }

    public void setValeurCible(float valeurCible) {
        mValeurCible = valeurCible;
    }

    public float getValeurSource() {
        return mValeurSource;
    }

    public void setValeurSource(float valeurSource) {
        mValeurSource = valeurSource;
    }

    public String getSpinnerSource() {
        return mSpinnerSource;
    }

    public void setSpinnerSource(String spinnerSource) {
        mSpinnerSource = spinnerSource;
    }

    public String getSpinnerCible() {
        return mSpinnerCible;
    }

    public void setSpinnerCible(String spinnerCible) {
        mSpinnerCible = spinnerCible;
    }

    public final void convertToFrom()
    {
        switch (getSpinnerSource()) {
            case "Celcius": this.CelciusTempTo(); break;
            case "Kelvin": this.KelvinTempTo(); break;
            case "Fahrenheit": this.FahrenheitTempTo(); break;
            case "Rankine": this.RankineTempTo(); break;
            case "Reaumur": this.ReaumurTempTo(); break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public final void KelvinTempTo()
    {
        switch (getSpinnerCible()) {
            case "Celcius": break;
            case "Kelvin": this.setValeurCible(getValeurSource()); break;
            case "Fahrenheit": break;
            case "Rankine": break;
            case "Reaumur": break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public final void FahrenheitTempTo()
    {
        switch (getSpinnerCible()) {
            case "Celcius": break;
            case "Kelvin": break;
            case "Fahrenheit": this.setValeurCible(getValeurSource()); break;
            case "Rankine": break;
            case "Reaumur": break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }
    public final void RankineTempTo()
    {
        switch (getSpinnerCible()) {
            case "Celcius": break;
            case "Kelvin": break;
            case "Fahrenheit": break;
            case "Rankine": this.setValeurCible(getValeurSource()); break;
            case "Reaumur": break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public final void ReaumurTempTo()
    {
        switch (getSpinnerCible()) {
            case "Celcius": this.setValeurCible(getValeurSource() * 1.25f); break;
            case "Kelvin": this.setValeurCible(1.25f * getValeurSource() + 273.15f); break;
            case "Fahrenheit": this.setValeurCible(getValeurSource() * 9/4 + 32f); break;
            case "Rankine":  this.setValeurCible(getValeurSource() * 9/4 + 491.67f); break;
            case "Reaumur": this.setValeurCible(getValeurSource()); break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public final void CelciusTempTo()
    {
        switch (getSpinnerCible()) {
            case "Celcius": this.setValeurCible(getValeurSource()); break;
            case "Kelvin": this.setValeurCible(getValeurSource() + 273.15f); break;
            case "Fahrenheit": this.setValeurCible((getValeurSource() * 9/5) + 32f); break;
            case "Rankine": this.setValeurCible(getValeurSource() * 9/5 + 491.67f); break;
            case "Reaumur": this.setValeurCible(getValeurSource() * 4/5); break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }

    public Temperature(float ValeurSource, @NonNull String spinnerSource, @NonNull String spinnerCible)
    {
        this.setValeurSource(ValeurSource);
        this.setSpinnerCible(spinnerCible);
        this.setSpinnerSource(spinnerSource);
        this.convertToFrom();
    }

    public static boolean isFloat(String number)
    {
        try {
            return !Float.valueOf(number).isNaN();
        } catch (NumberFormatException e){
            return false;
        }
    }
}
