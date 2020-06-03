package it.ensayo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Model(adaptables = Resource.class)
public class PageModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String pageTitle;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL, name = "jcr:title")
    private String title;

    @ChildResource(name = "root/responsivegrid")
    private List<Resource> components;

    public List<ComponentModel> getComponents() {
        List<ComponentModel> componentList = new ArrayList<>();
        for (Resource resource : components){
            String resourceType = resource.getResourceType();
            String componentName = resourceType.substring(resourceType.lastIndexOf('/') + 1);
            if (componentName.equals("hero")){
                componentList.add(new HeroModel(resource));
            }


        }
        return componentList;
        //return components;

        //return components.stream().map(Resource::getName).collect(Collectors.toList());
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getTitle() {
        return title;
    }


}
