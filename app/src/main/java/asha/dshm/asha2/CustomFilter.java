package asha.dshm.asha2;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import asha.dshm.asha2.Adapters.FamilyRecordAdapter;
import asha.dshm.asha2.Java.FamilyRecord;

public class CustomFilter extends Filter {
    FamilyRecordAdapter familyRecordAdapter;
    ArrayList<FamilyRecord> filterList;

    public CustomFilter(ArrayList<FamilyRecord> filterList, FamilyRecordAdapter adapter) {
        this.filterList =  filterList;
        this.familyRecordAdapter = adapter;
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            ArrayList<FamilyRecord> filteredFamilies = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {
                if (filterList.get(i).toString().toUpperCase().contains(constraint)) {
                    filteredFamilies.add(filterList.get(i));
                }
            }

            results.count = filteredFamilies.size();
            results.values = filteredFamilies;
        } else {
            results.count = filterList.size();
            results.values = filterList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        familyRecordAdapter.familyRecordList = (ArrayList<FamilyRecord>) results.values;

        //REFRESH
        familyRecordAdapter.notifyDataSetChanged();
    }
}
