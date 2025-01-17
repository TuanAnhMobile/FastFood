package android.mobile.foodappclient.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.mobile.foodappclient.activity.ChangePassActivity;
import android.mobile.foodappclient.activity.FavouriteActivity;
import android.mobile.foodappclient.activity.IntroActivity;
import android.mobile.foodappclient.databinding.FragmentProfileBinding;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.mobile.foodappclient.R;
import android.widget.Toast;


public class ProfileFragment extends Fragment {
FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        SharedPreferences sharedPreferences_name = getActivity().getSharedPreferences("myPre", MODE_PRIVATE);
        String userName = sharedPreferences_name.getString("mail", ""); // Lấy tên người dùng từ SharedPreferences

        // Gán tên người dùng vào TextView hoặc phần tử giao diện tương ứng
//        fragmentManager = getChildFragmentManager();
        binding.txtNameProfile.setText(userName);

        binding.txtDoimkProfile.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), ChangePassActivity.class));
        });
        binding.txtLogOut.setOnClickListener(v -> {
            getDialogOut();
        });
        binding.txtFavorite.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), FavouriteActivity.class));
        });
        binding.txtOrder.setOnClickListener(v -> {
//            fragmentManager.popBackStack();
//
//            // Thêm fragment mới (OrderFragment)
//            OrderFragment orderFragment = new OrderFragment();
//            fragmentManager.beginTransaction().replace(R.id.fragment_container_order, orderFragment,"OrderFragmentTag").addToBackStack(null).commit();

        });


        return binding.getRoot();
    }
    private void getDialogOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.warning);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn đăng xuất không ?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LogOut();
                Toast.makeText(getContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void LogOut() {
        startActivity(new Intent(getContext(), IntroActivity.class));
    }
}