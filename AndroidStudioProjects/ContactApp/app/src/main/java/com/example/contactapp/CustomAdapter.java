package com.example.contactapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataName;
    private static String[] localDataPhone;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_text;
        private final TextView phone_text;
        private final ImageView img_to_click;
        public ViewHolder(View view) {
            super(view);
            name_text = (TextView) view.findViewById(R.id.editName);
            phone_text = (TextView) view.findViewById(R.id.editPhone);
            img_to_click=(ImageView) view.findViewById(R.id.image);
            // Define click listener for the ViewHolder's View

        }

        public TextView getName() {
            return name_text;
        }
        public TextView getPhone() {
            return phone_text;
        }
        public ImageView getContactImage(){return img_to_click;}
    }

    public CustomAdapter(String[] dataName ,String[] dataPhone) {
        localDataName=dataName;localDataPhone=dataPhone;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getName().setText(localDataName[position]);
        viewHolder.getPhone().setText(localDataPhone[position]);
        //Onclick listener to Contact image
        viewHolder.getContactImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Opening Phone app", Toast.LENGTH_SHORT).show();
                //Intent for dialing the mobile number in the phone app
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + localDataPhone[position]));
                v.getContext().startActivity(intent);

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataName.length;
    }
}
