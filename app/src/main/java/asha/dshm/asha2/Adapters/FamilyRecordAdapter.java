package asha.dshm.asha2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import asha.dshm.asha2.CustomFilter;
import asha.dshm.asha2.Java.FamilyRecord;
import asha.dshm.asha2.R;

public class FamilyRecordAdapter extends RecyclerView.Adapter<FamilyRecordAdapter.MyViewHolder> implements Filterable {

    private Context mContext;
    public ArrayList<FamilyRecord> familyRecordList, filterList;
    private int mNumberItems;
    CustomFilter filter;

    public FamilyRecordAdapter(Context mContext, ArrayList<FamilyRecord> familyRecordList, int mNumberItems) {
        this.mContext = mContext;
        this.familyRecordList = familyRecordList;
        this.mNumberItems = mNumberItems;
        this.filterList = familyRecordList;
    }

    public ArrayList<FamilyRecord> getFamilyRecordList() {
        return familyRecordList;
    }

    public void setFamilyRecordList(ArrayList<FamilyRecord> familyRecordList) {
        this.familyRecordList = familyRecordList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView family_head, areaCode, address, familyID;
        ImageView im;

        public MyViewHolder(View view) {
            super(view);
            family_head = (TextView) view.findViewById(R.id.family_head);
            address = (TextView) view.findViewById(R.id.address);
            familyID = (TextView) view.findViewById(R.id.family_id);
            im=(ImageView)view.findViewById(R.id.im);
im.setImageResource(R.drawable.ic_home_black_24dp);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIDForListItem = R.layout.family_profile_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View itemView = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final FamilyRecord family = familyRecordList.get(position);
        Log.d("fam", family.toString());
        holder.family_head.setText("Family Head name: " + family.getName_head_of_family());
        holder.address.setText("Address: " + (family.getAddress()));
        holder.familyID.setText("Family ID: " + family.getFamilyID());
    }

    @Override
    public int getItemCount() {
        return familyRecordList.size();
    }

    @Override
    public CustomFilter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }

}
