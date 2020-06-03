package it.ensayo.core.models;

import it.ensayo.core.configuration.BasicTextConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = SlingHttpServletRequest.class)
public class TextfieldModel {

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @OSGiService
    private BasicTextConfiguration basicTextConfiguration;

    public String getText() {
        Object o = slingHttpServletRequest.getAttribute("ensayo-attribute");
        if (o instanceof String) {
            return basicTextConfiguration.getText() + " " + o;
        }
        return basicTextConfiguration.getText();
    }

}
