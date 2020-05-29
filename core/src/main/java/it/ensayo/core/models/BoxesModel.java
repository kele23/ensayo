package it.ensayo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class)
public class BoxesModel {

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @ChildResource
    private List<BoxItem> boxes;

    public List<BoxItem> getBoxes() {
        return boxes;
    }
}
