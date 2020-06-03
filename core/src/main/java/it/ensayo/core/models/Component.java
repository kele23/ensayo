package it.ensayo.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

public interface Component {

    default String getName() {
        String resourceType = getResource().getResourceType();
        return resourceType.substring(resourceType.lastIndexOf('/') + 1);
    }

    @JsonIgnore
    Resource getResource();

}
