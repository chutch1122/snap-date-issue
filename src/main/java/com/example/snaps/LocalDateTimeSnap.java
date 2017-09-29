package com.example.snaps;

import com.google.inject.Inject;
import com.snaplogic.api.ConfigurationException;
import com.snaplogic.api.ExecutionException;
import com.snaplogic.api.Snap;
import com.snaplogic.common.properties.builders.PropertyBuilder;
import com.snaplogic.snap.api.*;
import com.snaplogic.snap.api.capabilities.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@General(title = "Date Issue - LocalDateTime",
         purpose = "Demonstrate problem when writing a LocalDateTime to an output view.",
         author = "Cameron Hutchison",
         docLink = "http://github.com/chutch1122/snap-date-issue")
@Inputs(max = 1, accepts = {ViewType.DOCUMENT})
@Outputs(min = 1, max = 1, offers = {ViewType.DOCUMENT})
@Errors(offers = {ViewType.DOCUMENT})
@Version()
@Category(snap = SnapCategory.READ)
public class LocalDateTimeSnap implements Snap {
    @Inject private DocumentUtility documentUtility;
    @Inject private OutputViews outputViews;

    @Override
    public void defineProperties(PropertyBuilder propertyBuilder) {
    }

    @Override
    public void configure(PropertyValues propertyValues) throws ConfigurationException {
    }

    @Override
    public void execute() throws ExecutionException {
        Map<String, Object> row = new LinkedHashMap<>();

        row.put("firstName", "Bobby");
        row.put("lastName", "Tables");
        row.put("dateOfBirth", LocalDateTime.of(1990, 12, 25, 1, 30));
        row.put("email", "bobby@tables.com");
        row.put("yearsExperience", 5);

        Document document = documentUtility.newDocument(row);
        outputViews.write(document);
    }

    @Override
    public void cleanup() throws ExecutionException {

    }
}
