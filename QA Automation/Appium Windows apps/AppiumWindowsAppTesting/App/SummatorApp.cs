using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium.Appium.Windows;

namespace AppiumWindowsAppTesting
{
    
    public class SummatorApp
    {
        private WindowsDriver<WindowsElement> driver;

        private WindowsElement firstNumTextBox => driver.FindElementByAccessibilityId("textBoxFirstNum");
        private WindowsElement secondNumTextBox => driver.FindElementByAccessibilityId("textBoxSecondNum");
        private WindowsElement calculateButton => driver.FindElementByAccessibilityId("buttonCalc");
        private WindowsElement result => driver.FindElementByAccessibilityId("textBoxSum");

        public SummatorApp(WindowsDriver<WindowsElement> driver)
        {
            this.driver = driver;
        }

        public string SumNumbers(string first, string second)
        {
            firstNumTextBox.SendKeys(first);
            secondNumTextBox.SendKeys(second);
            calculateButton.Click();
            return result.Text;
        }

        public string GetCalculateButtonText()
        {
            return calculateButton.Text;
        }

    }
}
