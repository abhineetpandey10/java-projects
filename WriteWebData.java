
import java.util.Scanner;
import java.io.*;
import java.net.*;
class WriteWebData
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a URL");
        String s=sc.next();
        URL url=null;
        try
        {
            url=new URL(s);
            String tmp=url.getProtocol();
        }
        catch(MalformedURLException e)
        {
            System.out.println("The URL either does not contain a protocol or the protocol present in the URL is not supported by the current VM");
            System.exit(0);
        }
        InetAddress address;
        try
        {
            String tmp=url.getHost();
            address=InetAddress.getByName(tmp);
        }
        catch(UnknownHostException e)
        {
            System.out.println("Unable to connect to the given URL. Kindly check the URL you entered or check your Internet connection.");
            System.exit(0);
        }
        try
        {
            InputStream in=url.openStream();
            in=new BufferedInputStream(in); //the inputstream in has been buffered to increase productivity
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int c;
            FileWriter fout=new FileWriter("WebPage.html");
            while((c=br.read())!=-1)
                fout.write(c);
            fout.close();
        }
        catch(IOException e)
        {
            System.out.println("Failed to download data from "+url);
            System.exit(0);
        }
    }
}