using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Selenium_Waits
{
    public class BaseTest
    {
        protected IWebDriver driver;
        [OneTimeSetUp]
        public void Setup()
        {
            driver = new ChromeDriver();

        }

        [OneTimeTearDown]
        public void TearDown()
        {
            driver.Quit();
        }
    }
}