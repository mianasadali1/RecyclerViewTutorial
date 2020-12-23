package com.mianasad.recyclerview_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button listBtn, gridBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        listBtn = findViewById(R.id.listBtn);
        gridBtn = findViewById(R.id.gridBtn);

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("Arabian Delight", R.drawable.arabian_delight));
        foods.add(new Food("Savour Food", R.drawable.savour_food));
        foods.add(new Food("Ravi Charga", R.drawable.ravi_charga));
        foods.add(new Food("KFC", R.drawable.kfc));
        foods.add(new Food("Juices Island", R.drawable.juices_island));
        foods.add(new Food("Galeto Pizza", R.drawable.galeto_pizza));


        FoodAdapter adapter = new FoodAdapter(this, foods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}