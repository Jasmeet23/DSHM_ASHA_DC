package asha.dshm.asha2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import asha.dshm.asha2.Java.FamilyRecord;

public class rntcpAdapter extends RecyclerView.Adapter<rntcpAdapter.MyViewHolder> implements Filterable {

    private Context mContext;
    public ArrayList<Rnctp_object> familyRecordList, filterList;
    private int mNumberItems;
    CustomFilter filter;

    public rntcpAdapter(Context mContext, ArrayList<Rnctp_object> familyRecordList, int mNumberItems) {
        this.mContext = mContext;
        this.familyRecordList = familyRecordList;
        this.mNumberItems = mNumberItems;
        this.filterList = familyRecordList;
    }

    public ArrayList<Rnctp_object> getFamilyRecordList() {
        return familyRecordList;
    }

    public void setFamilyRecordList(ArrayList<Rnctp_object> familyRecordList) {
        this.familyRecordList = familyRecordList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView record;
        TextView name;

        public MyViewHolder(View view) {
            super(view);
            record = (TextView) view.findViewById(R.id.family_item);
            name = (TextView) view.findViewById(R.id.ident);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
        }
    }

    @Override
    public rntcpAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
//        fixRecord();
        int layoutIDForListItem = R.layout.item_family;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View itemView = inflater.inflate(layoutIDForListItem, parent, shouldAttachToParentImmediately);
        return new rntcpAdapter.MyViewHolder(itemView);
    }
//    public void fixRecord(){
//        for(int i=0;i<familyRecordList.size();i++){
//            if(Integer.parseInt(familyRecordList.get(i).getTreatment_status())==1)
//                    familyRecordList.remove(i);
//        }
//    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(rntcpAdapter.MyViewHolder holder, int position) {
        final Rnctp_object family = familyRecordList.get(position);
        Log.d("fam", family.toString());
        int ch = Integer.parseInt(family.getTreatment_status());
        holder.name.setText("Member ID:"+family.getFamily_member_id());


        switch (ch) {


            case 1:{
                holder.record.setText("Treatment completed");

                holder.record.setTextColor(mContext.getResources().getColor(R.color.green));
                break;
            }
            case 2: {
                holder.record.setText("Treatment left in between");
                holder.record.setTextColor(mContext.getResources().getColor(R.color.red));
                break;
            }
            case 3: {
                holder.record.setTextColor(mContext.getResources().getColor(R.color.red));
                holder.record.setText("Treatment not started");
                break;
            }
            case 4: {
                holder.record.setTextColor(mContext.getResources().getColor(R.color.blue));
                holder.record.setText("Treatment is going on");
                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return familyRecordList.size();
    }

    @Override
    public CustomFilter getFilter() {
        return filter;
    }
}
