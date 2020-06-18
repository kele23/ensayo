package it.ensayo.core.models;

import it.ensayo.core.configuration.BasicTextConfiguration;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;

@Model(adaptables = Resource.class, adapters = Component.class, resourceType = "ensayo/components/content/title-image")
public class TitleImageModel implements Component {

    @Self
    private Resource resource;

    @OSGiService
    private BasicTextConfiguration basicTextConfiguration;

    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;

    @ValueMapValue
    private String select;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImageTitle() {
        Resource resource = resourceResolver.getResource(image);
        if (resource != null) {
            return resource.getName();
        }
        return null;
    }

    public String getSelect() {
        return select;
    }

    public String getConfig() {
        return basicTextConfiguration.getText();
    }

    @Override
    public Resource getResource() {
        return resource;
    }
}
