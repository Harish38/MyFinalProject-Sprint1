<?xml version="1.0"?>
<!DOCTYPE module PUBLIC "-//Puppy Crawl//DTD Check Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
    <!-- Other checkstyle rules -->

    <module name="TreeWalker">
        <!-- Exclude a specific package -->
        <module name="SuppressionFilter">
            <property name="file" value="src/main/java/com/example/package/to/exclude/.*"/>
        </module>

        <!-- Other TreeWalker modules -->
    </module>
</module>


<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>example-project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-checkstyle-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <configLocation>checkstyle.xml</configLocation>
                </configuration>
                <executions>
                    <execution>
                        <id>checkstyle</id>
                        <phase>validate</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>