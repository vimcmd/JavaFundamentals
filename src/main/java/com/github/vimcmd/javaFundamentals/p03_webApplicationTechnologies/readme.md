# Intellij IDEA project: Tomcat deployment
##### Download Tomcat Server
[Download](https://tomcat.apache.org/) Tomcat server 8.x or later and extract it. Add it to Intellij IDEA:
    - _File > Settings > Build, Ex... > Application servers > Add (+) > Tomcat server >_ choose extracted directory.

##### Web Application: Archive (war)
1. Prepare artifact (or use external build manager, for ex. _Maven_)
    - _File > Project Structure > Artifacts_
    - _Add (+) > Web Application: Archive_
    - Give a name
    - Choose elements in _Output Layout_ tab
2. Edit configurations
    - _Run > Edit configurations_
    - _Add (+) > Tomcat Server > local_
    - Add artifact (war) on _Deployment_ tab
    - Other settings may keep defaults (pay attention to port number to prevent conflicts)
3. Now _Applications Servers_ tool window appeared (may be accessed via _View > Tool Window > Application Servers_)
4. Start server

##### Web Application: Exploded (Hot Deployment while debugging)
1. Prepare artifact (or use external build manager, for ex. _Maven_)
    - steps same as war, but choose _Web Application: Exploded_
2. Edit configurations
    - _Run > Edit configurations_
    - _Add (+) > Tomcat Server > local_
    - Add artifact (exploded) on _Deployment_ tab
    - On _Server_ tab choose for _On update action_ and _On frame deactivation_ choose option _Update classes and resources_
    - Other settings may keep defaults (pay attention to port number to prevent conflicts)
3. Now _Applications Servers_ tool window appeared (may be accessed via _View > Tool Window > Application Servers_)
4. Start server in debug mode. Try to modify some codes or resources (JSP or html),
the modified classes and resources will be reloaded automatically.

##### Web Resources
In case of different web resources usage for tasks in this chapters, make sure your added all web resource directories
to _Web_ module in _Project Structure_:
1. _File > Project Structure > Modules > Add (+) > Web_
2. Give a name
3. In _Web Resource Directories_ tab add all needed directories with resource (jsp, html, images etc.) with specified
relative path. Later that path will be used for access to resource.
4. Add web facet resources added to artifact.
5. To access controller in jsp by relative path, use
`
action="${pageContext.request.contextPath}/%UrlPatternName%"
`
6. Restart server

