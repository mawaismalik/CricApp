package com.itroos.cricapp.helpers;

import android.os.Environment;

public class Config {

    public interface InputType{
        String Text = "Text";
        String Radio = "Radio";
        String Checkbox = "Checkbox";
        String Label = "Label";
        String AnySpecialServices = "Any Special Services";

    }
    public interface team{
        String TEAM_A = "TEAM_A";
        String TEAM_B = "TEAM_B";
    }

    public interface ExtrasHints{
        String TEAM_ID = "TEAM_ID";
    }
    public interface dateFormat{
        String ID_DATE = "yyyyddMM-HHmmssS";
        String DATE_FOMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        String Short_Date_Format = "yyyy-MM-dd";
        String TIME_FOMAT = "hh:mm a";
    }

    public interface Status{
        final Integer On_Going = 1;

    }

}
