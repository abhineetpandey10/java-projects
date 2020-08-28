import java.net.*;
import java.util.Scanner;
import java.io.InputStream;
class InternetAddress
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        InternetAddress internetAddressObject=new InternetAddress();
        String s;
        String dummy; //dummy string for clearing input buffer
        while(true)
        {
            System.out.println("1.Find IP address of a website from domain name");
            System.out.println("2.Find domain name of website from IP address");
            System.out.println("3.Find all IP addresses of a website from  domain name");
            System.out.println("4.Find the domain name and IP address of the localhost");
            System.out.println("5.Find whether the given website has an IPv4 or an IPv6 address");
            System.out.println("0. Exit");
            int n=sc.nextInt();
            dummy=sc.nextLine();
            switch(n)
            {
                case 1: 
                System.out.println("Enter the domain name of the website");
                s=sc.nextLine(); 
                internetAddressObject.printIPAddress(s);
                break;
                case 2:
                System.out.println("Enter the IP address of the website");
                s=sc.nextLine();
                internetAddressObject.printDomainName(s);
                break;
                case 3:
                System.out.println("Enter the domain name of the website");
                s=sc.nextLine();
                internetAddressObject.printAllIPAddresses(s);
                break;
                case 4:internetAddressObject.printLocalHostDetails();
                break;
                case 5:System.out.println("Enter the domain name of the website: ");
                s=sc.nextLine();
                internetAddressObject.printIPAddressType(s);
                break;
                case 0:System.exit(0);
            }
        }
    }
    public void printIPAddress(String s)
    {
        try
        {
            InetAddress address=InetAddress.getByName(s);
            System.out.println("IP address of "+s+" is: "+address);
        }
        catch(UnknownHostException e)
        {
            System.out.println("Failed to resolve "+s);
        }
    }
    public void printDomainName(String s)
    {
        try
        {
            InetAddress address=InetAddress.getByName(s);
            System.out.println(address.getHostName());
        }
        catch(UnknownHostException e)
        {
            System.out.println("Failed to resolve address : "+s);
        }
    }
    public void printAllIPAddresses(String s)
    {
        try
        {
            InetAddress[] address=InetAddress.getAllByName(s);
            System.out.println("Following are the IP addresses of "+s);
            for(InetAddress i:address)
                System.out.println(i);
        }
        catch(UnknownHostException e)
        {
            System.out.println("Failed to resolve "+s);
        }
    }
    public void printLocalHostDetails()
    {
        try
        {
            System.out.println(InetAddress.getLocalHost());
        }
        catch(UnknownHostException e)
        {
            System.out.println("Could not reolve LocalHost");
        }
    }
    public void printIPAddressType(String s)
    {
        try
        {
            InetAddress address=InetAddress.getByName(s);
            byte[] addressArray=address.getAddress();
            if(addressArray.length==4)
                System.out.println(s+" has a IPv4 type IP address");
            else
                System.out.println(s+"has a IPv4 type IP address");
        }
        catch(UnknownHostException e)
        {
            System.out.println("Failed to resolve "+s);
        }
    }
}