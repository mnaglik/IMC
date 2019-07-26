package com.example.imc2;




import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnImc, btnRaz;
    private RadioButton btnMetre, btnCentimetre;

    private CheckBox checkMegaFonction;
    private TextView txtPoids, txtTaille, txtResultat, txtConseil;
    private Double nombre1, nombre2, resultat;
    private String chaine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        listenerButton();

        resultat = 0.0;
        nombre1 = 0.0;
        nombre2 = 0.0;
        chaine = "";

    }


    //initilisation des bouton et champs
    public void initButton() {
        btnMetre = findViewById(R.id.btnMetre);
        btnCentimetre = findViewById(R.id.btnCentimetre);
        btnImc = findViewById(R.id.btnImc);
        btnRaz = findViewById(R.id.btnRaz);

        checkMegaFonction = findViewById(R.id.checkMegaFonction);


        txtPoids = findViewById(R.id.txtPoids);
        txtTaille = findViewById(R.id.txtTaille);
        txtResultat = findViewById(R.id.txtResultat);
        txtConseil = findViewById(R.id.txtConseil);
    }

    //ecouteur sur les boutons
    public void listenerButton() {
        btnMetre.setOnClickListener(this);
        btnCentimetre.setOnClickListener(this);
        btnImc.setOnClickListener(this);
        btnRaz.setOnClickListener(this);

        checkMegaFonction.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if ((("").equals(txtPoids.getText().toString()) || ("").equals(txtTaille.getText().toString())) && (v.equals(btnImc))) {

            Toast.makeText(this, "Merci de compléter tous  les champs ", Toast.LENGTH_SHORT).show();


        } else {


            if (v.equals(btnCentimetre)) {
                Toast.makeText(this, "Btn Centimetre", Toast.LENGTH_SHORT).show();
                btnCentimetre.setChecked(true);
                btnMetre.setChecked(false);

            }
            if (v.equals(btnMetre)) {
                Toast.makeText(this, "Btn Metre", Toast.LENGTH_SHORT).show();
                btnCentimetre.setChecked(false);
                btnMetre.setChecked(true);

            }

            if (!btnMetre.isChecked() && (!btnCentimetre.isChecked())) {

                Toast.makeText(this, "Merci de choisir une unité de mesure ", Toast.LENGTH_SHORT).show();

            }else{
                if (btnCentimetre.isChecked()) {
                    if (v.equals(btnImc)) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        Toast.makeText(this, "Btn Imc", Toast.LENGTH_SHORT).show();
                        nombre1 = Double.parseDouble(txtPoids.getText().toString());
                        nombre2 = Double.parseDouble(txtTaille.getText().toString());
                        resultat = (nombre1 / (nombre2 * nombre2) * 10000);
                        txtResultat.setText(" Votre indice de masse corporel est :" + df.format(resultat));
                        if (resultat <= 18.5) {
                            txtConseil.setText("trop mince");
                        }
                        if (resultat > 18.5 && resultat <= 25) {
                            txtConseil.setText("C'est ok ");
                        }
                        if (resultat > 25 && resultat <= 30) {
                            txtConseil.setText("C'est limite");
                        }
                        if (resultat > 30 && resultat <= 35) {
                            txtConseil.setText("Obèse sympa");
                        }
                        if (resultat > 35 && resultat <= 40) {
                            txtConseil.setText("Obèse à fond");
                        }
                        if (resultat > 40) {
                            txtConseil.setText("Là t'es gros");
                        }
                    }
                    if (btnMetre.isChecked()) {
                        DecimalFormat df = new DecimalFormat("0.00");
                        Toast.makeText(this, "Btn Imc", Toast.LENGTH_SHORT).show();
                        nombre1 = Double.parseDouble(txtPoids.getText().toString());
                        nombre2 = Double.parseDouble(txtTaille.getText().toString());
                        resultat = (nombre1 / (nombre2 * nombre2));
                        txtResultat.setText(" Votre indice de masse corporel est :" + df.format(resultat));
                        if (resultat <= 18.5) {
                            txtConseil.setText("maigreur");
                        }
                        if (resultat > 18.5 && resultat <= 25) {
                            txtConseil.setText("Corpulence normale ");
                        }
                        if (resultat > 25 && resultat <= 30) {
                            txtConseil.setText("surpoids");
                        }
                        if (resultat > 30 && resultat <= 35) {
                            txtConseil.setText("Obèsité modérée ");
                        }
                        if (resultat > 35 && resultat <= 40) {
                            txtConseil.setText("Obèsité sévère");
                        }
                        if (resultat > 40) {
                            txtConseil.setText("obesité morbide");
                        }
                    }
                }
            }
        }

        if (v.equals(btnRaz)) {
            Toast.makeText(this, "Btn Raz", Toast.LENGTH_SHORT).show();
            chaine = "";
            txtTaille.setText(chaine);
            txtPoids.setText(chaine);
            txtResultat.setText(chaine);
            txtConseil.setText(chaine);
            btnCentimetre.setChecked(false);
            btnMetre.setChecked(false);
        }
    }
}
