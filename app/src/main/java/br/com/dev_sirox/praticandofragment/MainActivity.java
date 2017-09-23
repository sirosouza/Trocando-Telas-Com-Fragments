package br.com.dev_sirox.praticandofragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Activity activity;

    private Switch stFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stFragment = (Switch) findViewById(R.id.swFragment);
        stFragment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Fragment otherFragment = new OtherFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);

                    transaction.replace(R.id.fragmentContainer, otherFragment);
                    // Commit the transaction
                    transaction.commit();
                    getFragmentManager().executePendingTransactions();
                } else {
                    getFragmentManager().popBackStack();
                }
            }
        });
    }
}
