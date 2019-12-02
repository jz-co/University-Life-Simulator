package com.example.universitylife;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class BonusIcons {
    private ArrayList<Integer> bonusIconsIdentifiers = new ArrayList<Integer>();

    public BonusIcons(AppCompatActivity activity) {
        populateBonusIcons(activity);
    }

    private void populateBonusIcons(AppCompatActivity activity) {
        ArrayList<String> iconNames = new ArrayList<String>(Arrays.asList("@drawable/calculator", "@drawable/umbrella", "@drawable/superarrow"
        ));

        for (String iconName : iconNames) {
            bonusIconsIdentifiers.add(activity.getResources().getIdentifier(iconName, null,
                    activity.getPackageName()));
        }

    }

    /**
     * Returns the identifier of the icon
     *
     * @param index the picture index
     * @return identifier of the pic
     */
    public int getIconIdentifierByIndex(int index) {
        return bonusIconsIdentifiers.get(index-1);
    }
}
