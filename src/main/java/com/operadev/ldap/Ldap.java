package com.operadev.ldap;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Ldap {
    public static void main( String[] args ){
        System.out.println(System.getProperty("user.dir"));
        System.out.println( "Hello World!" );
        String keystorePath = System.getProperty("user.dir") + "/keystore.jks";
        System.setProperty("javax.net.ssl.keyStore", keystorePath);

        // Password of your java keystore. Default value is : changeit
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.PROVIDER_URL, "ldaps://directory.colostate.edu:389");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=radouane,ou=people,o=RoufidTutorials,c=fr");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        try {
            // Openning the connection
            DirContext ctx = new InitialDirContext(env);
            System.out.println("Connected");
            // Use your context here...
        } catch (NamingException e) {
            System.out.println("Problem occurs during context initialization !");
            e.printStackTrace();
        }

        System.out.println("END OF THE FILE");
    }
}
