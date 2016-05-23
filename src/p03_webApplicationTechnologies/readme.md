# Intellij IDEA project: Tomcat deployment
0. [Download](https://tomcat.apache.org/) Tomcat server 8.x or later and extract it. Add it to Intellij IDEA:
    - _File > Settings > Build, Ex... > Application servers > Add (+) > Tomcat server >_ choose extracted directory.
1. Prepare artifact (war)
    - Default (IDEA):
        - _File > Project Structure > Artifacts_
        - _Add (+) > Web Application: Archive_
        - Give a name
        - Choose elements in _Output Layout_ tab
    - Maven: clean, install
2. Edit configurations
    - _Run > Edit configurations_
    - _Add (+) > Tomcat Server > local_
    - Add artifact (war) on _Deployment_ tab
    - Other settings may keep defaults
3. Now _Applications Servers_ tool window appeared (may be accessed via _View > Tool Window > Application Servers_)
