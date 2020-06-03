package it.ensayo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;

import java.util.List;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, adapters = ComponentModel.class)
public class BoxesModel implements ComponentModel{

    @Self
    private Resource resource;

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @ChildResource
    private List<BoxItem> boxes;

    public List<BoxItem> getBoxes() {
        return boxes;
    }

    @Override
    public String getName() {
        String resourceType= resource.getResourceType();
        return resourceType.substring(resourceType.lastIndexOf('/') + 1);
    }
}
