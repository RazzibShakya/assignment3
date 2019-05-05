package com.softwarica.assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemsViewHolder>  {
    List<Items> clotheslist;
    Context context;

    public ItemRecyclerAdapter(List<Items> clotheslist, Context context) {
        this.clotheslist = clotheslist;
        this.context = context;
    }

    public ItemsViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_row,viewGroup,false);
        return new ItemsViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemsViewHolder itemsViewHolder, int i) {
        final Items clothes=clotheslist.get(i);
        itemsViewHolder.item_Name.setText(clothes.getItem_name());
        itemsViewHolder.item_price.setText(clothes.getItem_price());
        itemsViewHolder.item_des.setText(clothes.getItem_des());
        itemsViewHolder.img.setImageResource(clothes.getItem_img());
        itemsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,clothes.getItem_name(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,description.class);
                intent.putExtra("Item_Name",clothes.item_name);
                intent.putExtra("Item_Price",clothes.item_price);
                intent.putExtra("Item_Description",clothes.item_des);
                intent.putExtra("Item_Picture",clothes.item_img);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return clotheslist.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{
        public TextView item_Name;
        public TextView item_price;
        public TextView item_des;
        public ImageView img;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            item_Name=itemView.findViewById(R.id.ItemName);
            item_price=itemView.findViewById(R.id.ItemPrice);
            item_des=itemView.findViewById(R.id.itemdes);
            img=itemView.findViewById(R.id.imgItem);
        }
    }
}
