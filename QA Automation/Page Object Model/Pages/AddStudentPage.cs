using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using Students_Registry_Selenium_POM_Tests.Pages;

namespace Students_Registry_Selenium_POM_Tests.pages
{
    public class AddStudentPage : BasePage
    {
        public AddStudentPage(IWebDriver driver) : base(driver)
        {
        }

        public override string PageUrl => "https://mvc-app-node-express.nakov.repl.co/add-student";

        public IWebElement FieldStudentName => driver.FindElement(By.CssSelector("#name"));
        public IWebElement FieldStudentEmail => driver.FindElement(By.CssSelector("#email"));
        public IWebElement  ButtonAdd => driver.FindElement(By.CssSelector("body > form > button"));

        public IWebElement ErrorMessage => driver.FindElement(By.CssSelector("body > div"));

        public void RegisterStudent(string name, string email)
        {
            FieldStudentName.SendKeys(name);
            FieldStudentEmail.SendKeys(email);
            ButtonAdd.Click();
        }

        public string GetErrorMessage()
        {
            return ErrorMessage.Text;
        }


    }
}
