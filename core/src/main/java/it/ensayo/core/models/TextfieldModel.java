package it.ensayo.core.models;

import it.ensayo.core.api.configuration.TextfieldConfiguration;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class)
public class TextfieldModel {
    @OSGiService
    private TextfieldConfiguration textfieldConfiguration;

    public String getText() {
        return textfieldConfiguration.getText();
    }
}
