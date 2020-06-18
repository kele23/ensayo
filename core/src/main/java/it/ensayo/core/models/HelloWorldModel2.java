package it.ensayo.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class}, resourceType = "ensayo/components/content/hello-world")
@Exporter(name = "jackson", selector = "mexp", extensions = "json")
public class HelloWorldModel2 {

    @ValueMapValue(name = "title")
    private String myTitle;

    @JsonIgnore
    public String getHelloWorld() {
        return "hello world model";
    }

    public String getLowercaseTitle() {
        return myTitle.toLowerCase();
    }

}
