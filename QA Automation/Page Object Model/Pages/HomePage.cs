using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;

namespace Students_Registry_Selenium_POM_Tests.Pages
{
    public class HomePage : BasePage
    {
        public HomePage(IWebDriver driver) : base(driver)
        {
        }

        public IWebElement ElementStudentCount => driver.FindElement(By.CssSelector("body > p > b"));
        

        public override string PageUrl => "https://mvc-app-node-express.nakov.repl.co/";

        public string GetStudentCount()
        {
            return ElementStudentCount.Text;
        }
    }
}
