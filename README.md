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
