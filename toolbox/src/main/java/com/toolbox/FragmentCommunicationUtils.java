package com.toolbox;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public final class FragmentCommunicationUtils {

	private FragmentCommunicationUtils() {}

	@Nullable
	public static <T> T getListener(Fragment fragment, Class<T> listenerClazz) {

		T targetFragmentListener = getTargetFragmentListener(fragment, listenerClazz);
		if (targetFragmentListener != null) {
			return targetFragmentListener;
		}

		T parentFragmentListener = getParentFragmentListener(fragment, listenerClazz);
		if (parentFragmentListener != null) {
			return parentFragmentListener;
		}

		T activityListener = getActivityFragmentListener(fragment, listenerClazz);
		if (activityListener != null) {
			return activityListener;
		}

		return null;
	}

	@Nullable
	public static <T> T getListener(Class<T> listenerClazz, Object object) {
		if (listenerClazz.isInstance(object)) {
			return listenerClazz.cast(object);
		}

		return null;
	}

	@Nullable
	public static <T> T getTargetFragmentListener(Fragment fragment, Class<T> listenerClazz) {
		return getListener(listenerClazz, fragment.getTargetFragment());
	}

	@Nullable
	public static <T> T getParentFragmentListener(Fragment fragment, Class<T> listenerClazz) {
		return getListener(listenerClazz, fragment.getParentFragment());
	}

	@Nullable
	public static <T> T getActivityFragmentListener(Fragment fragment, Class<T> listenerClazz) {
		return getListener(listenerClazz, fragment.getActivity());
	}

	@NonNull
	public static <T> T getListenerOrThrow(Fragment fragment, Class<T> listenerClazz) {
		T listener = getListener(fragment, listenerClazz);
		if (listener == null) {
			throw new IllegalStateException("Host must implement " + listenerClazz.getSimpleName());
		}

		return listener;
	}
}
