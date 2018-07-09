package com.kewenc.kewencimagetext;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private final List<String> data;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<String> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.removeAllViews();
        position = position % 3;
        if (position == 0){
            holder.textView.setText("position = "+data.get(position));
            holder.itemView.addView(holder.textView);
        } else if (position == 1){
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.itemView.addView(holder.editText,layoutParams);
        } else {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.itemView.addView(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textView;
        private EditText editText;
        private ImageView imageView;
        private RelativeLayout itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            ViewHolder.this.itemView = (RelativeLayout) itemView;
            textView = new TextView(itemView.getContext());
            editText = new EditText(itemView.getContext());
            imageView = new ImageView(itemView.getContext());
//            textView.setVisibility(View.GONE);
//            editText.setVisibility(View.GONE);
//            imageView.setVisibility(View.GONE);
//            textView = new TextView(itemView.getContext());
//            ViewHolder.this.itemView.addView(textView);
//            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnTtemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
