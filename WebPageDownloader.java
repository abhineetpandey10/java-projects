/**
 *This is a WebPage downloader that downloads Web Page contents (text basically ) using a URLConnection object
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
 class WebPageDownloader
{
    public static void main(String[] args)
    {
        System.out.println("Enter a WebPage URL");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        URL url=null;
        /**
         * Check if the protocol has been entered or not
         * If the protocol has been enterd, check whether it is supported by the current VM or not.
         */
        try
        {
            url=new URL(s);
        }
        catch(MalformedURLException e)
        {
            System.out.println("Either you have not specified the protocol in the entered IP address, or the protocol you entered is not supported on the current VM.");
            System.exit(0);
        }
        /**
         * Open a connection to the specified URL and download the content from its web page.
         */
        /**
         * Check if the entered URL exists or not or the machine is connected to the Internet or not
         */
        try
        {
            String tmp=url.getHost().toString();
            InetAddress address=InetAddress.getByName(tmp);
        }
        catch (UnknownHostException e)
        {
            System.out.println("The URL you entered could not be found. Possible reasons could be: ");
            System.out.println("Bad Internet Connection. Please Check your Internet connection and then try again.");
            System.out.println("There might be a mistake while typing in the URL. Please check the URL and try again.");
            System.exit(0);
        }
        try
        {
            URLConnection connection=url.openConnection();
            BufferedInputStream input=new BufferedInputStream(connection.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(input));
            int c;
            FileWriter fout=new FileWriter("WebPage.html");
            while((c=br.read())!=-1)
                fout.write((char)c);
            fout.close();
        }
        catch(IOException e)
        {
            System.out.println("Failed to establish a connection to the specified URL "+s);
            System.exit(0);
        }
    }
}