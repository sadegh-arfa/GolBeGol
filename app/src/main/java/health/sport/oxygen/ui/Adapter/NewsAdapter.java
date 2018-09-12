package health.sport.oxygen.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import health.sport.oxygen.R;
import health.sport.oxygen.models.News;
import health.sport.oxygen.ui.WebViewActivity;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> mItems;
    Context c;

    public NewsAdapter(List<News> data, Context c) {
        super();
        mItems = data;
        this.c = c;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.news_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final News item = mItems.get(i);

        if (item.getNewsImage() != null && item.getNewsImage().getPicture() != null) {
            Glide.with(c)
                    .load(item.getNewsImage().getPicture())
                    .into(viewHolder.image);
        } else {
            viewHolder.image.setImageDrawable(c.getResources().getDrawable(R.drawable.ic_preview));
        }


        viewHolder.title.setText(item.getMainNews().getNewsEntity().getTitle());

        viewHolder.author.setText(item.getMainNews().getNewsEntity().getNewsSource());

        viewHolder.time.setText(String.format("%s %s" ,item.getMainNews().getNewsEntity().getDate().getDateNumber() , item.getMainNews().getNewsEntity().getDate().getDateString() ));

        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, WebViewActivity.class);
                String link = "http://khabar.parsijoo.ir/khabar/showpost?pid="+ item.getMainNews().getNewsEntity().getUrl() +"&khabarjoo";
                intent.putExtra("url" , link);
                intent.putExtra("title" , item.getMainNews().getNewsEntity().getTitle());
                c.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {

        return mItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView image;
        public final TextView title;
        public final TextView time;
        public final TextView author;
        public final CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            time = (TextView) itemView.findViewById(R.id.time);
            author = (TextView) itemView.findViewById(R.id.author);
            card = (CardView) itemView.findViewById(R.id.card);

        }
    }
}