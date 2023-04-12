package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ServiceCategoryActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORYID = "categoryId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_category);

        //Preuzimanje CategoryID iz Intent-a
        int positionCategory = (Integer)getIntent().getExtras().get(EXTRA_CATEGORYID);

        ArrayList<String> dataList = new ArrayList<>();
        ArrayAdapter<String> adapter;
        ListView listServices = (ListView) findViewById(R.id.list_services);

        //Prolazimo kroz sve usluge i uzimamo one usluge koje imaju odgovarajući CategoryID
        for(Service s : Service.SERVICES){
            if(s.getCategoryId() == positionCategory){
                dataList.add(s.getName());
            }
        }

        //Pronađene usluge postavljamo u ListView.
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listServices.setAdapter(adapter);

        //Pravi se osluškivač
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listServices,
                                            View itemView,
                                            int position,
                                            long id) {

                        Intent newIntent = new Intent(ServiceCategoryActivity.this, ServiceActivity.class);
                        newIntent.putExtra(ServiceActivity.EXTRA_SERVICEID, (int)id);
                        //Prosleđujemo opet CategoryID pored ServiceID
                        newIntent.putExtra(ServiceActivity.EXTRA_CATEGORYID, positionCategory);
                        startActivity(newIntent);
                    }
                };

        //Dodeliti osluškivač prikazu liste
        listServices.setOnItemClickListener(itemClickListener);
    }
}