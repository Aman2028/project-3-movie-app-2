package com.android.aman.movieapp.Adapters;



import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.aman.movieapp.Models.Model;
import com.android.aman.movieapp.Viewmodel.Viewmodel;
import com.android.aman.movieapp.Models.TrailerModel;
import com.android.aman.movieapp.R;

import java.util.ArrayList;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.Viewholder>
{
    ArrayList<TrailerModel> arrayList;
    Context context;
    Context getContext;
    public TrailerAdapter(Context context,ArrayList<TrailerModel> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_item_layout,parent,false);
        Viewholder holder=new Viewholder(view);
        getContext=parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position)
    {
        final TrailerModel model=arrayList.get(position);
        holder.trailerNum.setText("Trailer "+(position+1));
        holder.item_layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v="+model.getKey()));
                try {
                    getContext.startActivity(webIntent);
                } catch (ActivityNotFoundException ex)
                {
                    Toast.makeText(getContext,""+ex.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
        RelativeLayout item_layout;
        TextView trailerNum;
        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            item_layout=itemView.findViewById(R.id.itemLayout);
            trailerNum=itemView.findViewById(R.id.trailernumber);
        }
    }
}
