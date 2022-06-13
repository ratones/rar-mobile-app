package rar.dtic.rarapplication.ui.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import rar.dtic.rarapplication.R;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {

    private List<VehicleListItem> itemList;
    private Context context;

    public VehiclesAdapter(List<VehicleListItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_vehicle, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VehicleListItem vehicle = itemList.get(position);
        holder.txt_VehicleCIV.setText(vehicle.getCiv());
        holder.txt_VehicleVIN.setText(vehicle.getVin());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_VehicleVIN;
        public TextView txt_VehicleCIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_VehicleVIN = (TextView) itemView.findViewById(R.id.txt_VehicleVIN);
            txt_VehicleCIV = (TextView) itemView.findViewById(R.id.txtVehicleCIV);
        }
    }
}
