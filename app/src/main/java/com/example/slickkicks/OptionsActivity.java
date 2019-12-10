package com.example.slickkicks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {
    SeekBar seekBar;
    SeekBar seekBar2;
    CheckBox nike, adidas, ua;
    private int size = 0;
    private static int price = 0;
    private static boolean n = false;
    private static boolean a = false;
    private static boolean u = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        selectItem();

        seekBar=(SeekBar)findViewById(R.id.size);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                size = progress;
                Toast.makeText(getApplicationContext(),"Shoe Size: "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Shoe Size: "+size, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Shoe Size: "+size, Toast.LENGTH_SHORT).show();
            }
        });
        seekBar2=(SeekBar)findViewById(R.id.price);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                price = progress;
                Toast.makeText(getApplicationContext(),"Maximum price: $"+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Maximum price: $"+ price, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Maximum price: $"+ price, Toast.LENGTH_SHORT).show();
            }
        });
        Button next = (Button)findViewById(R.id.Next);
        Intent intent = new Intent(this, DisplayActivity.class);
        next.setOnClickListener(unused -> startActivity(intent));
    }
    public void selectItem() {
        nike = (CheckBox)findViewById(R.id.Nike);
        adidas = (CheckBox)findViewById(R.id.Adidas);
        ua = (CheckBox)findViewById(R.id.UnderArmour);

        nike.setOnClickListener(unused -> {
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (((CheckBox)v).isChecked()) {
                                n = true;
                            }
                        }
                    };
                }
        );
        adidas.setOnClickListener(unused -> {
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (((CheckBox)v).isChecked()) {
                                a = true;
                            }
                        }
                    };
                }
        );
        ua.setOnClickListener(unused -> {
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (((CheckBox)v).isChecked()) {
                                u = true;
                            }
                        }
                    };
                }
        );
    }
    public static boolean getN() {
        return n;
    }
    public static boolean getA() {
        return a;
    }
    public static  boolean getU() {
        return u;
    }
    public  int getSize() {
        return size;
    }
    public static  int getPrice() {
        return price;
    }
}
