package it.ensayo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;

import java.util.List;

@Model(adaptables = {Resource.class}, adapters = Component.class, resourceType = "ensayo/components/content/boxes")
public class BoxesModel implements Component {

    @Self
    private Resource resource;

    @ChildResource
    private List<BoxItem> boxes;

    public List<BoxItem> getBoxes() {
        return boxes;
    }

    @Override
    public Resource getResource() {
        return resource;
    }
}
