package a_Basics;

/*
================================================================================
                        CLASSLOADER HIERARCHY IN JAVA
================================================================================

1. WHAT IS CLASSLOADER?
   - A ClassLoader is a part of JRE (Java Runtime Environment)
   - Responsible for dynamically loading Java classes into JVM memory
   - Loads classes on-demand (lazy loading) rather than all at once
   - Works on the delegation model

2. CLASSLOADER HIERARCHY (Top to Bottom)

   Bootstrap ClassLoader (null)
            ↑
   Extension/Platform ClassLoader
            ↑
   Application/System ClassLoader
            ↑
   Custom ClassLoader (optional)

================================================================================

3. DETAILED EXPLANATION OF EACH CLASSLOADER

   a) BOOTSTRAP CLASSLOADER (Primordial ClassLoader)
      - Root of the ClassLoader hierarchy
      - Written in native code (C/C++), not Java
      - Loads core Java API classes from <JAVA_HOME>/jre/lib
      - Loads rt.jar (runtime jar) containing java.lang, java.util, etc.
      - Cannot be instantiated in Java code
      - Returns null when you call getClassLoader() on core classes
      - Example classes: String, Object, System, Integer

   b) EXTENSION/PLATFORM CLASSLOADER
      - Child of Bootstrap ClassLoader
      - Loads classes from extension directories
      - Location: <JAVA_HOME>/jre/lib/ext or any directory specified by
        java.ext.dirs system property
      - In Java 9+, renamed to Platform ClassLoader
      - Loads standard Java extensions
      - Implemented by sun.misc.Launcher$ExtClassLoader (Java 8)
      - Implemented by PlatformClassLoader (Java 9+)

   c) APPLICATION/SYSTEM CLASSLOADER
      - Child of Extension/Platform ClassLoader
      - Loads classes from application classpath
      - Loads classes from -classpath or -cp command line option
      - Loads classes from CLASSPATH environment variable
      - Implemented by sun.misc.Launcher$AppClassLoader
      - This is the default ClassLoader for application classes
      - Most commonly used ClassLoader

   d) CUSTOM CLASSLOADER (User-Defined)
      - Child of Application ClassLoader (or any other)
      - Created by extending java.lang.ClassLoader
      - Used for special requirements like:
        * Loading classes from network
        * Loading encrypted classes
        * Hot deployment in servers
        * Loading classes from database
        * Implementing plugin architectures


================================================================================

5. WHY CLASSLOADER HIERARCHY IS NEEDED

   a) SECURITY
      - Core Java classes always loaded by Bootstrap ClassLoader
      - Prevents replacing system classes with malicious versions
      - Example: Cannot replace java.lang.String with custom version

   b) NAMESPACE SEPARATION
      - Different ClassLoaders create different namespaces
      - Same class loaded by different loaders are different classes
      - Useful in application servers (Tomcat, WebLogic)

   c) MEMORY EFFICIENCY
      - Classes loaded only once and shared
      - Parent delegation prevents duplicate loading

   d) MODULARITY
      - Different applications can use different versions of same library
      - Each application gets its own ClassLoader in app servers

   e) DYNAMIC LOADING
      - Classes loaded on-demand, not at startup
      - Reduces initial memory footprint
      - Faster application startup

================================================================================

6. PRACTICAL USES & APPLICATIONS

   a) WEB SERVERS & APPLICATION SERVERS
      - Each web application gets its own ClassLoader
      - Isolates applications from each other
      - Allows hot deployment without restarting server
      - Tomcat uses: Common, Server, Shared, WebApp ClassLoaders

   b) PLUGIN ARCHITECTURES
      - Load plugins dynamically at runtime
      - Eclipse, IntelliJ IDEA use custom ClassLoaders
      - Plugins can be added/removed without restart

   c) OSGI FRAMEWORK
      - Each bundle has its own ClassLoader
      - Supports versioning of modules
      - Dynamic module loading/unloading

   d) HOT DEPLOYMENT
      - Reload classes without restarting application
      - Development environments use this
      - JRebel tool uses ClassLoader mechanism

   e) CLASS ENCRYPTION/OBFUSCATION
      - Load encrypted class files
      - Decrypt at runtime using custom ClassLoader

================================================================================

9. IMPORTANT INTERVIEW QUESTIONS & ANSWERS

   Q1: What is ClassLoader in Java?
   A: ClassLoader is a subsystem of JVM responsible for loading class files
      into memory dynamically at runtime.

   Q2: Why do we have three ClassLoaders?
   A: For security, modularity, and namespace separation. Bootstrap loads
      core classes, Extension loads extensions, Application loads user classes.

   Q3: When do we need custom ClassLoader?
   A: For loading classes from non-standard sources (network, encrypted files,
      database), hot deployment, plugin systems, or isolation requirements.

   Q4: What happens if class is not found?
   A: ClassNotFoundException is thrown after all ClassLoaders in hierarchy
      fail to find the class.

   Q5: Can two classes with same name exist in JVM?
   A: Yes, if loaded by different ClassLoaders. Each loader creates a
      separate namespace.


*/