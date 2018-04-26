package com.example.kevin.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ventanaItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_items);
        ((TextView) findViewById(R.id.Usuario)).setText(getIntent().getExtras().getString("id"));
    }
}
