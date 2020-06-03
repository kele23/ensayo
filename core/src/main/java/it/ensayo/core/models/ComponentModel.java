package it.ensayo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public interface ComponentModel {

    public String getName();

}
