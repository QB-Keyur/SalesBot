    package Config;

    import java.io.*;
    import java.util.Properties;

    public class ReadProperties  {

        public Properties properties;

        public final String filePath = "src/test/java/Config/Config.properties";

        public ReadProperties() {
            BufferedReader reader;
            try {

              reader = new BufferedReader((new FileReader(filePath)));
              properties = new Properties();
              try{
                  properties.load(reader);
                  reader.close();
              }catch (FileNotFoundException e){
                  e.printStackTrace();
              }
            } catch (IOException e) {
                System.err.println("Exception occurred: " + e.getMessage());
            }
        }

        public String getWebUrl() {
            String url = properties.getProperty("webURL");
            if (url != null)
                return url;
            else
                throw new RuntimeException("web url not specified in the Configuration.properties file.");
        }
        public String getFEUrl() {
            String url = properties.getProperty("feURL");
            if (url != null)
                return url;
            else
                throw new RuntimeException("web url not specified in the Configuration.properties file.");
        }
        public String[] getDirectorCredentials() {

            String user = properties.getProperty("DirectorUser");
            String password = properties.getProperty("DirectorPass");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

        public String[] getRSMCredentials() {

            String user = properties.getProperty("RSMUser");
            String password = properties.getProperty("RSMPass");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

        public String[] getASMCredential(){
            String user = properties.getProperty("ASMUser");
            String password = properties.getProperty("ASMPass");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

        public String[] getMRCredential(){
            String user = properties.getProperty("MRUser");
            String password = properties.getProperty("MRPass");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

    }
