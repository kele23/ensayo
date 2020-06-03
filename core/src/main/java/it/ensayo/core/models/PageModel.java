package it.ensayo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = Resource.class, resourceType = "ensayo/components/structure/pages/page")
@Exporter(name = "jackson", extensions = "json")
public class PageModel implements Component {

    @Self
    private Resource resource;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String pageTitle;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL, name = "jcr:title")
    private String title;

    @ChildResource(name = "root/responsivegrid")
    private List<Component> components;

    public List<Component> getComponents() {
        return components;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Resource getResource() {
        return resource;
    }
}
