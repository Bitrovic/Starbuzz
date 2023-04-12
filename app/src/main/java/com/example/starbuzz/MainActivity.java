package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pravi se osluškivač onItemClickListener
        AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long id){

                //Na osnovu kliknute pozicije prosleđujemo odgovarajući CategoryID
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this, ServiceCategoryActivity.class);
                    intent.putExtra(ServiceCategoryActivity.EXTRA_CATEGORYID, position);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(MainActivity.this, ServiceCategoryActivity.class);
                    intent.putExtra(ServiceCategoryActivity.EXTRA_CATEGORYID, position);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, ServiceCategoryActivity.class);
                    intent.putExtra(ServiceCategoryActivity.EXTRA_CATEGORYID, position);
                    startActivity(intent);
                }
            }
        };

        //Dodavanje osluškivača u prikaz liste
        ListView listView = (ListView) findViewById(R.id.list_option);
        listView.setOnItemClickListener(itemClickListener);
    }
}