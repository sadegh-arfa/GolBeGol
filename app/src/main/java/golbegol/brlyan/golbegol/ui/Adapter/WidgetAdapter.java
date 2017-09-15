package golbegol.brlyan.golbegol.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import golbegol.brlyan.golbegol.R;
import golbegol.brlyan.golbegol.ui.Cell.widget;


public class WidgetAdapter extends RecyclerView.Adapter<WidgetAdapter.ViewHolder> {

    private final List<widget> mItems;
    Context c;

    public WidgetAdapter(List<widget> data, Context c) {
        super();
        mItems = data;
        this.c = c;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.wiget_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final widget item = mItems.get(i);


        viewHolder.card.setCardBackgroundColor(item.getBackgroundColor());
        viewHolder.imgThumbnail.setImageResource(item.getImage());
        viewHolder.process.setText(item.getProcess() +" "+item.getUnit());
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,item.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {

        return mItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView imgThumbnail;
        public final CardView card ;
        public final TextView process ;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.image);
            card = (CardView) itemView.findViewById(R.id.card);
            process = (TextView) itemView.findViewById(R.id.process);

        }
    }
}