package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICEID = "serviceId";
    public static final String EXTRA_CATEGORYID = "categoryId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Preuzimanje vrednosti iz Intent-a
        int serviceId = (Integer)getIntent().getExtras().get(EXTRA_SERVICEID);
        int categoryId = (Integer)getIntent().getExtras().get(EXTRA_CATEGORYID);

        ArrayList<Service> services = new ArrayList<>();

        //Prolazimo kroz sve usluge i izdvajamo usluge koje imaju odgovarajući CategoryID u novu list.
        for(Service s : Service.SERVICES){
            if(s.getCategoryId() == categoryId){
                services.add(s);
            }
        }

        //Iz liste usluga izdvajamo odgovarajuću uslugu na osnovu pozicije kliknute usluge.
        Service service = services.get(serviceId);

        //Popuniti naziv usluge
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(service.getName());

        //Popuniti opis usluge
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(service.getDescription());

        //Popuniti sliku usluge
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(service.getImageResourceId());
        photo.setContentDescription(service.getName());
    }
}