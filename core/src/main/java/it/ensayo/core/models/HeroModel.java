package it.ensayo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, adapters = {ComponentModel.class}, cache = true)
public class HeroModel implements ComponentModel{

    @Self
    private Resource resource;

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    private String name;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subtitle;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String topText;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;

    public HeroModel(Resource resource) {
        this.resource= resource;
    }

    @Override
    public String getName() {
        String resourceType= resource.getResourceType();
        return resourceType.substring(resourceType.lastIndexOf('/') + 1);
    }

    public String getTitle() {
        return (String) resource.getValueMap().get("title");
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTopText() {
        return topText;
    }

    public String getImage() {
        return image;
    }
}
