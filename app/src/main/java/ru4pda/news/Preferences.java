package ru4pda.news;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by asavinova on 13/04/15.
 */
@SharedPref
public interface Preferences {

	@DefaultBoolean(true)
	boolean isFirstRun();

}
