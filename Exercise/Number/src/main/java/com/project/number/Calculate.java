package com.project.number;

import android.widget.EditText;
import android.widget.Spinner;

public class Calculate {

    Spinner raw;
    Spinner dest;
    EditText number;

    StringBuilder result;

    public Calculate(Spinner raw, Spinner dest, EditText number) {
        this.raw = raw;
        this.dest = dest;
        this.number = number;
        result = new StringBuilder();
    }

    public void run() {
        String rawB = raw.getSelectedItem().toString();
        String destB = dest.getSelectedItem().toString();

        result.delete(0, result.length());
        changeTen(this.number.getText().toString(), Integer.valueOf(rawB));
    }

    private StringBuilder changeTen(String number, int ben) {
        StringBuilder preResult = new StringBuilder();
        StringBuilder nextResult = new StringBuilder();

        boolean point = true;

        StringBuilder res = new StringBuilder();

        if( number.contains(".") ) {
            preResult.append(number.split("\\.")[0]);
            nextResult.append(number.split("\\.")[1]);
        } else {
            point = false;
            preResult.append(number);
        }

        int n = preResult.length();
        int resul = 0;
        int save = Integer.valueOf(preResult.toString());
        for( int i = 1; i <= n; i++ ) {
            int tmpN = 1;
            for( int j = 0; j < n-i; j++ )
                tmpN *= 10;
            int baseN = 1;
            for( int k = n-i; k > 0; k-- ) {
                baseN *= ben;
            }
            resul += (save/tmpN)*baseN;
            save %= tmpN;
        }

        System.out.println("\nresul : ("+ resul+")");
        return res;
    }

    public StringBuilder getResult() {
        return result;
    }
}
