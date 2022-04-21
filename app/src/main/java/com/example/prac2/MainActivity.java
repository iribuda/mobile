package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prac2.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MainModel> list;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        init();
    }

    public void setInitialData(){
        list = new ArrayList<MainModel>();
        list.add(new MainModel("Adis Kerimov", "0220075870", R.drawable.img, "Neurology", "adiskerimov@gmail.com", "Main office"));
        list.add(new MainModel("Melis Karyev", "0550786655", R.drawable.img1, "Pediatr", "meliskaryev@gmail.com", "Secondary office"));
        list.add(new MainModel("Sindy Leon", "0777722788", R.drawable.img2, "Podology", "sindyleon@gmail.com", "Main office"));
        list.add(new MainModel("Annie Leonhart", "0772227772", R.drawable.img3, "Ortopedia", "annieleonhart@gmail.com", "Main office"));
        list.add(new MainModel("Eren Yeager", "05555506070", R.drawable.img4, "Physiotherapy", "erenyeager@gmail.com", "Secondary office"));
        list.add(new MainModel("Levi Ackerman", "0708996543", R.drawable.img5, "Surgeon", "leviackerman@gmail.com", "Main office"));
    }

    private void init(){
        recyclerView = findViewById(R.id.rv_doctors);
        adapter = new MainAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}

