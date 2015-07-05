package justeatengineer.justeatengineer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import justeatengineer.justeatengineer.R;
import justeatengineer.justeatengineer.dto.DtoEntity;
import justeatengineer.justeatengineer.holder.HolderInformation;

/**
 * Created by luisangelgarcia on 7/5/15.
 */
public class AdapterInformation extends RecyclerView.Adapter<HolderInformation> {
    private final String TAG = "AdapterInformation";

    private List<DtoEntity> items;
    private Context context;

    public AdapterInformation(Context context, List<DtoEntity> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public HolderInformation onCreateViewHolder(ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(context).inflate(R.layout.row_information, viewGroup, false);
        return new HolderInformation(item);
    }

    @Override
    public void onBindViewHolder(HolderInformation holder, int position) {
        Picasso.with(context).load(items.get(position).getStandardResolutionURL().get(0).getUrl()).into(holder.img);

        holder.txtName.setText(items.get(position).getName());

        String cuisines = "";
        for (int i = 0; i < items.get(position).getCuisineTypes().size(); i++) {
            cuisines += items.get(position).getCuisineTypes().get(i).getName() + "\n";
        }
        holder.txtCuisine.setText(cuisines.trim());

        holder.txtRating.setText(String.valueOf(items.get(position).getRatingStars()));
    }
}
