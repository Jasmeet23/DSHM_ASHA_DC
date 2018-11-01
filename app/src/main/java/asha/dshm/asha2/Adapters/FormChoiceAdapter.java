package asha.dshm.asha2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import asha.dshm.asha2.R;
import asha.dshm.asha2.SubActivityDetails;

/**
 * Created by Akshara on 11-05-2018.
 */

public class FormChoiceAdapter extends RecyclerView.Adapter<FormChoiceAdapter.MyViewHolder> {
    private Context mContext;
    private List<SubActivityDetails> albumList;
    private int mNumberItems;
    final private ListItemClickListener mOnClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        RelativeLayout holderLayout;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            holderLayout = (RelativeLayout) view.findViewById(R.id.holderLayout);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(view, clickedPosition);
        }
    }


    public FormChoiceAdapter(List<SubActivityDetails> albumList, int numberOfItems, ListItemClickListener listener) {
        this.albumList = albumList;
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIDForListItem = R.layout.activity_card;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View itemView = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final SubActivityDetails album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getId() + "");
        holder.thumbnail.setImageResource(album.getImage());


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(View v, int clickedListItem);
    }


//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.maternalHealth)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, SubActivityChoice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.maternalHealth));
//                    mContext.startActivity(subActivityIntent);
//
//                }
//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.familyPlanning)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, SubActivityChoice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.familyPlanning));
//                    mContext.startActivity(subActivityIntent);
//
//                }
//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.IEC)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, SubActivityChoice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.IEC));
//                    mContext.startActivity(subActivityIntent);
//
//                }
//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.TB)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, SubActivityChoice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.TB));
//                    mContext.startActivity(subActivityIntent);
//
//                }
//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.Sanitation)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, SubActivityChoice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.Sanitation));
//                    mContext.startActivity(subActivityIntent);
//
//                }
//                else if( holder.title.getText().toString().equalsIgnoreCase(mContext.getResources().getString(R.string.malnourished)))
//                {
//                    Intent subActivityIntent = new Intent(mContext, Visit_Choice.class);
//                    subActivityIntent.putExtra("ID", mContext.getResources().getString(R.string.malnourished));
//                    mContext.startActivity(subActivityIntent);
//
//                }


}

