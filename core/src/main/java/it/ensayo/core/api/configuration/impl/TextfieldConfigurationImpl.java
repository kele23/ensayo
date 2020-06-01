package it.ensayo.core.api.configuration.impl;

import it.ensayo.core.api.configuration.TextfieldConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = TextfieldConfiguration.class, immediate = true)
@Designate(ocd = TextfieldConfigurationImpl.Configuration.class)
public class TextfieldConfigurationImpl implements TextfieldConfiguration {

    @Activate
    private void activate(Configuration configuration) {
        this.configuration = configuration;
    }

    private Configuration configuration;

    @Override
    public String getText() {
        return configuration.text();
    }

    @ObjectClassDefinition(name = "Ensayo - get text",
        description = "Ensayo - get text")
    public @interface Configuration {
        @AttributeDefinition(
            name = "Text",
            type = AttributeType.STRING
        )
        String text() default "Lorem ipsum";
    }
}
