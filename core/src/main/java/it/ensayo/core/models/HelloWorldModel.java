package it.ensayo.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class}, adapters = Component.class, resourceType = "ensayo/components/content/hello-world")
public class HelloWorldModel implements Component {

    @Self
    private Resource resource;

    @ValueMapValue(name = "title")
    private String myTitle;

    @JsonIgnore
    public String getHelloWorld() {
        return "hello world model";
    }

    public String getUppercaseTitle() {
        return myTitle.toUpperCase();
    }

    @Override
    public Resource getResource() {
        return resource;
    }
}
