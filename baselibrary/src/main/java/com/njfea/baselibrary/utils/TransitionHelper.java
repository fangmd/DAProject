package com.njfea.baselibrary.utils;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by double on 2017/8/12.
 */

public class TransitionHelper {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static List<Pair<View, String>> createSafeTransitionParticipants(@NonNull Activity activity) {
        View statusBar = activity.findViewById(android.R.id.statusBarBackground);
        View navigationBar = activity.findViewById(android.R.id.navigationBarBackground);
        List<Pair<View, String>> pairs = new ArrayList<>();
        if (statusBar != null) {
            pairs.add(Pair.create(statusBar, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME));
        }
        if (navigationBar != null) {
            pairs.add(Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME));
        }
        return pairs;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Pair<View, String>[] createSafeTransitionParticipants(@NonNull Activity activity, boolean includeStatusBar, @Nullable Pair... otherParticipants) {
        // Avoid system UI glitches as described here:
        // https://plus.google.com/+AlexLockwood/posts/RPtwZ5nNebb
        View decor = activity.getWindow().getDecorView();
        View statusBar = null;
        View navBar = null;
        if (includeStatusBar) {
            statusBar = decor.findViewById(android.R.id.statusBarBackground);
            navBar = decor.findViewById(android.R.id.navigationBarBackground);
        }
        // Create pair of transition participants.
        List<Pair> participants = new ArrayList<>(3);
        if (statusBar != null) {
            addNonNullViewToTransitionParticipants(statusBar, participants);
        }
        if (navBar != null) {
            addNonNullViewToTransitionParticipants(navBar, participants);
        }
        // only add transition participants if there's at least one none-null element
        if (otherParticipants != null && !(otherParticipants.length == 1
                && otherParticipants[0] == null)) {
            participants.addAll(Arrays.asList(otherParticipants));
        }
        return participants.toArray(new Pair[participants.size()]);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void addNonNullViewToTransitionParticipants(View view, List<Pair> participants) {
        if (view == null) {
            return;
        }
        participants.add(new Pair<>(view, view.getTransitionName()));
    }
}
