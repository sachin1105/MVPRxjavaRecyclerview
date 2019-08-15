package developer.smarty.rxjava.rxjavarecyclerview.adaptor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import developer.smarty.rxjava.rxjavarecyclerview.R;

public class RecyclerviewAdaptor extends RecyclerView.Adapter<RecyclerviewAdaptor.RecyclerviewViewHolder> {

    List<String> data = new ArrayList<>();
    Activity context;

    public RecyclerviewAdaptor(Activity context,List<String> data) {

        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.display_list_item,viewGroup,false);
        return new RecyclerviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewViewHolder recyclerviewViewHolder, final int i) {

        recyclerviewViewHolder.tvName.setText(data.get(i));
        Toast.makeText(context, data.get(i), Toast.LENGTH_SHORT).show();
        recyclerviewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+data.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class RecyclerviewViewHolder extends RecyclerView.ViewHolder{


        TextView tvName;

        public RecyclerviewViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView)itemView.findViewById(R.id.tvName);

        }//end of constructor

    }//end of class

}//end of adaptor
