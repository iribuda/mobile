package com.example.prac2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.prac2.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    public List<MainModel> list = new ArrayList<>();
    public Context context;
    private PopupMenu popMenu;

    public MainAdapter(List<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_recycler_item,parent,false);
        return new MainViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position){
        holder.onBind(list.get(position));
        holder.popMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem menuItem){
                        switch (menuItem.getItemId()){
                            case R.id.appoint_to_doctor:
                                Toast.makeText(context, "Dear User, you can enroll by calling a number 999999",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case R.id.call:
                                String number = list.get(position).getNumber();
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel: " + number));
                                context.startActivity(intent);
                                break;
                            case R.id.online_consult:
                                Toast.makeText(context, "Online consult...", Toast.LENGTH_SHORT).show();
                                break;
                        }return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName;
        TextView txtPhone;
        TextView txtSpec;
        TextView txtPlace;
        TextView txtEmail;
        ImageView imageView;
        ImageView popMenu;
        MainModel model;

        public MainViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtPlace = itemView.findViewById(R.id.txtPlace);
            txtSpec = itemView.findViewById(R.id.txtSpec);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            imageView = itemView.findViewById(R.id.imageView);
            popMenu = itemView.findViewById(R.id.popupMenu);
        }

        public void onBind(MainModel model){
            this.model = model;
            txtPhone.setText(model.getNumber());
            txtName.setText(model.getName());
            txtSpec.setText(model.getSpecialization());
            txtPlace.setText(model.getPlace());
            txtEmail.setText(model.getEmail());
            if(model.getImageView()!=0){
                Glide.with(context)
                        .load(model.getImageView())
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageView);
            }
        }

        @Override
        public void onClick(View view) {
        }
    }

}
