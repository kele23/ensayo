package it.ensayo.core.models;

import it.ensayo.core.configuration.BasicTextConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = SlingHttpServletRequest.class)
public class TextConfModel {

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @OSGiService(injectionStrategy = InjectionStrategy.OPTIONAL)
    private BasicTextConfiguration basicTextConfiguration;

    public String getConfText() {
        return basicTextConfiguration != null ? basicTextConfiguration.getText() : "No config";
    }

    public String getFilterText() {
        Object o = slingHttpServletRequest.getAttribute("ensayo-attribute");
        if (o instanceof String) {
            return (String) o;
        }
        return null;
    }


}
