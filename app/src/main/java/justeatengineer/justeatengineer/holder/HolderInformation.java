package justeatengineer.justeatengineer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import justeatengineer.justeatengineer.R;

/**
 * Created by luisangelgarcia on 7/5/15.
 */
public class HolderInformation extends RecyclerView.ViewHolder {
    public ImageView img;
    public TextView txtName;
    public TextView txtCuisine;
    public TextView txtRating;

    public HolderInformation(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        txtName = (TextView) itemView.findViewById(R.id.txt_name);
        txtCuisine = (TextView) itemView.findViewById(R.id.txt_cuisine);
        txtRating = (TextView) itemView.findViewById(R.id.txt_rating);
    }
}
