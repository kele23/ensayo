package it.ensayo.core.configuration.impl;

import it.ensayo.core.configuration.BasicTextConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = BasicTextConfiguration.class, immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = BasicTextConfigurationImpl.Configuration.class)
public class BasicTextConfigurationImpl implements BasicTextConfiguration {

    @Activate
    private void activate(Configuration configuration) {
        this.configuration = configuration;
    }

    private Configuration configuration;

    @Override
    public String getText() {
        return configuration.text();
    }

    @ObjectClassDefinition(name = "Ensayo - Basic Conf",
        description = "Ensayo - Basic Conf")
    public @interface Configuration {

        @AttributeDefinition(
            name = "Text",
            type = AttributeType.STRING
        )
        String text() default "Lorem ipsum";

        @AttributeDefinition(
            name = "Description",
            type = AttributeType.STRING
        )
        String description() default "Lorem ipsum dolorem";

        @AttributeDefinition(
            name = "Number",
            type = AttributeType.INTEGER
        )
        int number() default 0;

        @AttributeDefinition(
            name = "Multiple Text",
            type = AttributeType.STRING,
            cardinality = Integer.MAX_VALUE
        )
        String[] multipleText() default {};
    }
}
