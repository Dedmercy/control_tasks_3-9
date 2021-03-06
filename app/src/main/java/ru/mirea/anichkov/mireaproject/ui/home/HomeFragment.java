package ru.mirea.anichkov.mireaproject.ui.home;

import static ru.mirea.anichkov.mireaproject.ui.settings.SettingsFragment.getSavedText;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.anichkov.mireaproject.LoginScreen;
import ru.mirea.anichkov.mireaproject.MainActivity;
import ru.mirea.anichkov.mireaproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getSavedText() != null){
            binding.textHome.setText(getSavedText());
            Toast.makeText(getActivity(), getSavedText(), Toast.LENGTH_SHORT).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}