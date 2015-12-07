package com.example.kuzyn.seweryna2048;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    public Vector<ImageView> komorki = new Vector<ImageView>();
    public HashMap<String, Drawable> mapImages = new HashMap<String, Drawable>();
    public  GridLayout refGL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refGL = (GridLayout)findViewById(R.id.gridLayoutGame);

        mapImages.put("0", getResources().getDrawable(R.drawable.zero ) );
        mapImages.put("2", getResources().getDrawable(R.drawable.two ) );
        mapImages.put("4", getResources().getDrawable(R.drawable.four));
        mapImages.put("8", getResources().getDrawable(R.drawable.eight));
        mapImages.put("16", getResources().getDrawable(R.drawable.sixteen ) );
        mapImages.put("32", getResources().getDrawable(R.drawable.thirtytwo ) );
        mapImages.put("64", getResources().getDrawable(R.drawable.sixtyfour ) );
        mapImages.put("128", getResources().getDrawable(R.drawable.hundred ) );
        mapImages.put("256", getResources().getDrawable(R.drawable.twohundred ) );
        mapImages.put("512", getResources().getDrawable(R.drawable.fivehundred ) );
        mapImages.put("1024", getResources().getDrawable(R.drawable.thousand ) );
        mapImages.put("2048", getResources().getDrawable(R.drawable.twothousand ) );

        for(int i=0;i<game2048.getRozmiarPlanszy();i++) {
            for(int j=0;j<game2048.getRozmiarPlanszy();j++) {
                ImageView refImage = new ImageView(this);
                refImage.setImageDrawable(mapImages.get(game2048.getFromTable(i, j)));
                refImage.setPadding(40,40,0, 0);
                komorki.add(refImage);
                refGL.addView(refImage);
            }
        }

        ImageButton buttonG = (ImageButton) findViewById(R.id.imageButtonG);

        ImageButton buttonD = (ImageButton) findViewById(R.id.imageButtonD);
        ImageButton buttonL = (ImageButton) findViewById(R.id.imageButtonL);
        ImageButton buttonR = (ImageButton) findViewById(R.id.imageButtonR);

        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("G", komorki,mapImages);

            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("D", komorki,mapImages);
            }
        });
        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("L", komorki,mapImages);
            }
        });
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game2048.makeMoveForArrow("R", komorki,mapImages);
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
