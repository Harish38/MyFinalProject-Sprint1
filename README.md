<dependency>
    <groupId>org.jvnet.jaxb2_commons</groupId>
    <artifactId>jaxb2-basics</artifactId>
    <version>1.11.1</version>
</dependency>

package com.example.plugin;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.tools.xjc.BadCommandLineException;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.Outline;
import org.eclipse.persistence.oxm.annotations.XmlNullPolicy;
import org.eclipse.persistence.oxm.annotations.XmlMarshalNullRepresentation;

public class XmlNullPolicyPlugin extends Plugin {

    @Override
    public String getOptionName() {
        return "Xxmlnullpolicy";
    }

    @Override
    public String getUsage() {
        return "  -Xxmlnullpolicy    :  Add @XmlNullPolicy annotations to generated classes";
    }

    @Override
    public int parseArgument(Options opt, String[] args, int i) throws BadCommandLineException {
        return 0;
    }

    @Override
    public boolean run(Outline outline, Options opt, ErrorHandler errorHandler) {
        for (ClassOutline classOutline : outline.getClasses()) {
            JDefinedClass definedClass = classOutline.implClass;
            for (JFieldVar field : definedClass.fields().values()) {
                JAnnotationUse xmlElementAnnotation = field.annotate(XmlElement.class);
                xmlElementAnnotation.param("nillable", true);

                JAnnotationUse xmlNullPolicyAnnotation = field.annotate(XmlNullPolicy.class);
                xmlNullPolicyAnnotation.param("emptyNodeRepresentsNull", true);
                xmlNullPolicyAnnotation.param("nullRepresentationForXml", XmlMarshalNullRepresentation.EMPTY_NODE);
            }
        }
        return true;
    }
}



com.example.plugin.XmlNullPolicyPlugin


xjc -d src -p com.example.model -extension -Xxmlnullpolicy -classpath path/to/your/classes your-schema.xsd


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Example example = new Example();
        example.setName(null); // This should result in an empty tag <name/>
        example.setValue("Some value");

        JAXBContext jaxbContext = JAXBContext.newInstance(Example.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setListener(new Marshaller.Listener() {
            @Override
            public void beforeMarshal(Object source) {
                try {
                    Class<?> clazz = source.getClass();
                    for (Field field : clazz.getDeclaredFields()) {
                        field.setAccessible(true);
                        if (field.get(source) == null) {
                            field.set(source, "");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        StringWriter writer = new StringWriter();
        marshaller.marshal(example, writer);
        System.out.println(writer.toString());
    }
}
