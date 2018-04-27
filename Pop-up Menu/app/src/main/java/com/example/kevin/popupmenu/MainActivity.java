package com.example.kevin.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuPopUp(View v){
        PopupMenu popUp=new PopupMenu(this,v);
        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemVer:
                        Toast.makeText(getApplicationContext(),"Opcion Ver",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.itemComprar:
                        Toast.makeText(getApplicationContext(),"Opcion Comprar",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.itemComparar:
                        Toast.makeText(getApplicationContext(),"Opcion Comparar",Toast.LENGTH_LONG).show();
                        return true;
                        default: return false;
                }
            }
        });
            popUp.inflate(R.menu.menupopup);
            popUp.show();
    }
}
