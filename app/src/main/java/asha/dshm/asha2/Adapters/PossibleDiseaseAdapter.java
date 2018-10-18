package asha.dshm.asha2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import asha.dshm.asha2.R;

public class PossibleDiseaseAdapter extends RecyclerView.Adapter<PossibleDiseaseAdapter.MyViewHolder> {
    final private ListItemClickListener mOnClickListener;
    private int mNumberItems;
    private List<String> diseaseList;

    public PossibleDiseaseAdapter(List<String> diseases, ListItemClickListener mOnClickListener, int numberOfItems, List<String> diseaseList) {

        mNumberItems = numberOfItems;
        this.mOnClickListener = mOnClickListener;
        this.diseaseList = diseaseList;
    }

    public void update(List<String> data) {
//        diseaseList.clear();
//        diseaseList.addAll(data);
//        diseaseList = data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView diseaseName;

        public MyViewHolder(View itemView) {
            super(itemView);
            diseaseName = (TextView) itemView.findViewById(R.id.disease_name);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(v, clickedPosition);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIDForListItem = R.layout.disease_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View itemView = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);
        return new PossibleDiseaseAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        String x = diseaseList.get(position);
        Log.d("onbind", x);
        holder.diseaseName.setText(x);
    }

    @Override
    public int getItemCount() {
        return diseaseList.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(View v, int clickedListItem);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
