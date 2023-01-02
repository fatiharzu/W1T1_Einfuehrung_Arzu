package w1.t1.unterricht.einfuehrung_arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Damit VOM Codebehind auf ELemente des XML Files zugegriffen werden kann,
     * muss die entsperechende View (<code>TextView</code>) im Designer eine ID erhalten.
     * Diese ID wird benötigt, um eindeutig auf  die View zugriefen zu können.
     * Sie wird nach der Vergabe direkt in die vorkomplierten Ressourcen eingearbeitet.
     * Damit ist diese View unter "R.id.tv" erreichbaer (s.u)
     */

    private TextView lbl1;
    private Button btnZaehler, btnKopieren;
    private int zaehler;
    private EditText ed_Eingabe;

//    ===========================================================================================
    private class MyOCL implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            zaehler++;
            String txt = String.format("zaehler = %d", zaehler);
            lbl1.setText(txt);
        }
    }
//    ===========================================================================================
    private class MyOCL_Kopieren implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
           String txt = ed_Eingabe.getText().toString();
           lbl1.setText(txt);
           ed_Eingabe.setText("");
        }
    }
//    ===========================================================================================




    /**
     * Dies ist der Einstieg in die aktuelle Activity. Die Methode <code>onCreate</code>
     * entspricht der Methods <code>main</code>in Java
     * Ein Activity ist eine Klasse, die einen eigenen Bildschirm anzeigt.
     *
     * @param savedInstanceState übergebene Werte
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zaehler = 0;
        /*
        Hier wird die Referenz zum TextView hergestellt. Da diese Technik für alle Views gilt,
        muss der Cast zur TextView erfolgen, weil hier eine TextView vorliegt.
         */
        lbl1 = (TextView) findViewById(R.id.label1);

        btnZaehler = (Button) findViewById(R.id.buttonZaehler);
        btnZaehler.setOnClickListener(new MyOCL());

        btnKopieren = (Button) findViewById(R.id.buttonKopieren);
        btnKopieren.setOnClickListener(new MyOCL_Kopieren());

        ed_Eingabe = (EditText) findViewById(R.id.ed_Eingabe);

        lbl1.setText("Android ist super!");
    }

    //-----------------------------------------------------------------------------------------
}