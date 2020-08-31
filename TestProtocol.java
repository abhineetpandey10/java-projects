/**
 *A java program to check which protocols are supported by java
 *The user enters a protocol, and a custom URL string is made by appending ://www.google.com
 *to the protocol, and a URL object is attempted to create
 *If the creation of such an object succeeds, then is means that the protocol is supported
 *otherwise, a MalformedURLException is thrown which is caught and the user is told that the protocol is not supported
 */
 import java.util.Scanner;
 import java.net.*;
class TestProtocol
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a protocol:");
        String s=sc.next();
        String s1=s+"://www.google.com";;
        try
        {
            URL url=new URL(s1);
            System.out.println("The protocol "+s+" is supported");
        }
        catch(MalformedURLException e)
        {
            System.out.println("The protocol "+s+" is not supported");
        }
    }
}