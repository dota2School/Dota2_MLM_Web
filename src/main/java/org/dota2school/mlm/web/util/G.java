package org.dota2school.mlm.web.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by nt on 2017/7/26.
 */
public class G {
    public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();
}
