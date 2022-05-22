using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumDemo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var driver = new ChromeDriver();
            driver.Url = "https://wikipedia.org";
            driver.Quit();
        }
    }
}
