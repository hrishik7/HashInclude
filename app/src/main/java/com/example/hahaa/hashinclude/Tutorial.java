package com.example.hahaa.hashinclude;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Tutorial {
    private String heading;
    private String description;
    private String url;
    private String website;

    Tutorial(String head, String desc, String ur, String site)
    {
        heading = head;
        description = desc;
        url = ur;
        website = site;
    }
    public String getHeading()
    {
        return heading;
    }
    public String getDescription()
    {
        return description;
    }
    public String getUrl()
    {
        return url;
    }
    public String getWebsite()
    {
        return website;
    }
}
