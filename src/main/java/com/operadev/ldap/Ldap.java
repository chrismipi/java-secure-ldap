package main.java.com.operadev.ldap;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Ldap {
    public static void main( String[] args ){
        String keystorePath = System.getProperty("user.dir") + "/keystore.jks";
        System.setProperty("javax.net.ssl.keyStore", keystorePath);

        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=operadev,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "P@ss1W0Rd!");

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
