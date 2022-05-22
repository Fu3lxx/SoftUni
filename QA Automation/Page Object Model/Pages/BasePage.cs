using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Students_Registry_Selenium_POM_Tests.Pages
{
    public class BasePage
    {
        protected readonly IWebDriver driver;
        public virtual string PageUrl { get; }

        public IWebElement LinkHomePage => driver.FindElement(By.CssSelector("body > a:nth-child(1)"));
        public IWebElement LinkViewStudentsPage => driver.FindElement(By.CssSelector("body > a:nth-child(3)"));
        public IWebElement LinkAddStudentsPage => driver.FindElement(By.CssSelector("body > a:nth-child(5)"));
        public IWebElement ElementTextHeading => driver.FindElement(By.CssSelector("body > h1"));


        public BasePage(IWebDriver driver)
        {
            this.driver = driver;
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
        }

        public void Open()
        {
            driver.Navigate().GoToUrl(this.PageUrl);
        }

        public bool isOpen()
        {
            return driver.Url == this.PageUrl;
        }

        public string GetPageTitle()
        {
            return driver.Title;
        }

        public string getPageHeadingText()
        {
            return ElementTextHeading.Text;
        }
    }
}
