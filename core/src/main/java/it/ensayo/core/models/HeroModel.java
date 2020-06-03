package it.ensayo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class}, adapters = {Component.class}, cache = true, resourceType = "ensayo/components/content/hero")
public class HeroModel implements Component {

    @Self
    private Resource resource;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subtitle;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String topText;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;

    public String getTitle() {
        return title;
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

    @Override
    public Resource getResource() {
        return resource;
    }
}
