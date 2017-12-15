package com.toolbox.utils;

import android.view.View;

public class VisibilityUtils {

	private VisibilityUtils() {
	}

	public static void show(boolean show, View view) {
		if (show) {
			show(view);
		} else {
			hide(view);
		}
	}

	public static void show(View view) {
		view.setVisibility(View.VISIBLE);
	}

	public static void show(View... views) {
		for (View view : views) {
			show(view);
		}
	}

	public static void show(boolean show, View... views) {
		for (View view : views) {
			show(show, view);
		}
	}

	public static void hide(View... views) {
		for (View view : views) {
			hide(view);
		}
	}

	public static void hide(View view) {
		view.setVisibility(View.GONE);
	}

	public static void invisible(View view) {
		view.setVisibility(View.INVISIBLE);
	}

	public static void invisible(boolean show, View view) {
		if (show) {
			show(view);
		} else {
			invisible(view);
		}
	}
}