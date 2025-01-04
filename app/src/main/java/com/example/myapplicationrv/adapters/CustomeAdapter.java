package com.example.myapplicationrv.adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrv.R;
import com.example.myapplicationrv.models.Data;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.myViewHolder> {

    private ArrayList<Data> arr;

    public CustomeAdapter(ArrayList<Data> arr) {

        this.arr = arr;
    }
    public class myViewHolder extends RecyclerView.ViewHolder {


        TextView username;
        TextView nameVersion;
        ImageView imageViewItem;

        public myViewHolder ( View itemView){
            super(itemView);
           username = itemView.findViewById(R.id.textName);
           nameVersion = itemView.findViewById(R.id.textVer);
           imageViewItem = itemView.findViewById(R.id.imageView);
        }

    }
    @NonNull
    @Override
    public CustomeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview , parent , false ) ;

        myViewHolder MyViewHolder = new myViewHolder(view);

       return MyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.myViewHolder holder, int position) {

        Data currentItem = arr.get(position);

        holder.username.setText(currentItem.getName());
        holder.nameVersion.setText(currentItem.getSummary());
        holder.imageViewItem.setImageResource(currentItem.getImage());

        holder.itemView.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
            View dialogView = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.dialog_cardview, null);


            TextView dialogName = dialogView.findViewById(R.id.dialog_name);
            TextView dialogVersion = dialogView.findViewById(R.id.dialog_summary);
            ImageView dialogImage = dialogView.findViewById(R.id.dialog_image);


            dialogName.setText(currentItem.getName());
            dialogVersion.setText(currentItem.getSummary());
            dialogImage.setImageResource(currentItem.getImage());


            builder.setView(dialogView)
                    .setPositiveButton("Close", (dialog, which) -> dialog.dismiss());


            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }


    @Override
    public int getItemCount() {
        return arr.size();
    }


}
