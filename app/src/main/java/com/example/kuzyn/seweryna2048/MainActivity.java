package com.example.kuzyn.seweryna2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    public Vector<TextView> komorki = new Vector<TextView>();
    public  GridLayout refGL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refGL = (GridLayout)findViewById(R.id.gridLayoutGame);
        for(int i=0;i<game2048.getRozmiarPlanszy();i++) {
            for(int j=0;j<game2048.getRozmiarPlanszy();j++) {
                TextView napis = new TextView(this);
                napis.setTextSize(32);
                napis.setText(game2048.getFromTable(i, j));
                komorki.add(napis);
                refGL.addView(napis);
            }
        }

        ImageButton buttonG = (ImageButton) findViewById(R.id.imageButtonG);
        ImageButton buttonD = (ImageButton) findViewById(R.id.imageButtonD);
        ImageButton buttonL = (ImageButton) findViewById(R.id.imageButtonL);
        ImageButton buttonR = (ImageButton) findViewById(R.id.imageButtonR);

        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("G", komorki);

            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("D", komorki);
            }
        });
        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("L", komorki);
            }
        });
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("R", komorki);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    game2048 game2048 = new game2048();

}
