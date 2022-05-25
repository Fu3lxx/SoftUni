using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;

namespace POMSumTwoNumbers.Page
{
    public class HomePage 
    {
        private IWebDriver driver;

        private IWebElement firstNum => driver.FindElement(By.CssSelector("input[name='number1']"));
        private IWebElement secondNum => driver.FindElement(By.CssSelector("input[name='number2']"));
        private IWebElement calculate => driver.FindElement(By.CssSelector("input#calcButton"));
        private IWebElement reset => driver.FindElement(By.CssSelector("input#resetButton"));
        private IWebElement result => driver.FindElement(By.CssSelector("#result"));
        private IWebElement errorMessage => driver.FindElement(By.CssSelector("#result > i"));
        private IWebElement pageHeadingPage => driver.FindElement(By.CssSelector("body > form > h1"));

        
        public HomePage(IWebDriver driver)
        {
            this.driver = driver;
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
            driver.Manage().Window.Maximize();
            driver.Navigate().GoToUrl("https://sum-numbers.nakov.repl.co/");
        }

        public string SumTwoNumbers(string first, string second)
        {
            firstNum.Click();
            firstNum.SendKeys(first);
            secondNum.Click();
            secondNum.SendKeys(second);
            calculate.Click();

            return result.Text;
        }

        public string GetErrorMessage()
        {
            return errorMessage.Text;
        }

        public void Reset()
        {
            this.reset.Click();
        }

        public string GetFirstNum()
        {
            return firstNum.Text;
        }
        public string GetSecondNum()
        {
            return secondNum.Text;
        }

        public string GetPageTitle()
        {
            return this.driver.Title;
        }

        public string GetPageHeadingText()
        {
            return this.pageHeadingPage.Text;
        }





    }
}
