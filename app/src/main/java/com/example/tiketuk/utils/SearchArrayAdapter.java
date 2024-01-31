package com.example.tiketuk.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;


import java.util.ArrayList;
import java.util.List;

public class SearchArrayAdapter extends ArrayAdapter<String> {
	private ArrayList<String> _items;
	private ArrayList<String> _originalItems;
	private ArrayList<String> _filtered;
	private Filter _filter;

	public SearchArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
		this._items = new ArrayList<String>(objects);
		this._filtered = new ArrayList<String>();
		this._filter = new StockIDFilter();
	}
	
	@Override
	public Filter getFilter() {
		if(this._filter == null)
			this._filter = new StockIDFilter();
		return this._filter;		
	}
	
	@Override
	public int getCount() {
		return this._filtered.size();
	}
	
	@Override
	public String getItem(int position) {
		return this._filtered.get(position);
	}
	
	@Override
	public boolean isEnabled(int position) {
		return true;
	}
	
	private class StockIDFilter extends Filter {
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults result = new FilterResults();
			if(constraint == null || constraint.length() == 0) {
				if(_originalItems == null)
					_originalItems = new ArrayList<String>(_items);
				result.values = _originalItems;
				result.count = _originalItems.size();
			} else {
				String prefix = constraint.toString().toLowerCase();
				final ArrayList<String> values = _originalItems;
				final int count = values.size();
				final ArrayList<String> newValues = new ArrayList<String>(count);
				for(int i = 0; i < count; ++i) {
					final String value = values.get(i);
					if(value.toLowerCase().startsWith(prefix))
						newValues.add(value);
				}
				result.values = newValues;
				result.count = newValues.size();
			}
			return result;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults result) {
			try {
				_filtered = (ArrayList<String>) result.values;
				int count = _filtered.size();
				if(result.count > 0) {
					clear();
					for(int i = 0; i < count && i < 15; ++i)
						add(_filtered.get(i));
					notifyDataSetChanged();					
				}
				else
					notifyDataSetInvalidated();				
			} catch (Exception e) {
				Log.e("err",e.getMessage());
			}
		}
	}
}
