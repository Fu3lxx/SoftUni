using System;
using System.Runtime.InteropServices;
using NUnit.Framework;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Enums;
using OpenQA.Selenium.Appium.Service;
using OpenQA.Selenium.Appium.Windows;

namespace AppiumWindowsAppTesting
{
    public class Tests
    {
        private WindowsDriver<WindowsElement> driver;
        private const string AppiumServer = "http://127.0.0.1:4723/wd/hub";
        private AppiumOptions options;
        private SummatorApp summatorApp;

        [SetUp]
        public void Setup()
        {
            this.options = new AppiumOptions() { PlatformName = "Windows" };
            options.AddAdditionalCapability(MobileCapabilityType.App, @"C:\Users\Fu3l\Desktop\WindowsFormsApp.exe");

            this.driver = new WindowsDriver<WindowsElement>(new Uri(AppiumServer), options);
            summatorApp = new SummatorApp(driver);

        }

        [TearDown]
        public void ShutDown()
        {
            driver.CloseApp();
            driver.Quit();
            
        }

        [TestCase("10","10","20")]
        [TestCase("0","0","0")]
        [TestCase("1000000000", "9900220000000", "9901220000000")]

        public void SumTwoPositiveNumbers(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult,actualResutl);
        }

        [TestCase("-10", "-10", "-20")]
        [TestCase("-1000000000", "-9900220000000", "-9901220000000")]
        public void SumTwoNegativeNumbers(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult, actualResutl);
        }

        [TestCase("-10", "10", "0")]
        [TestCase("-1000000000", "9900220000000", "9899220000000")]
        public void SumFirstNegative(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult, actualResutl);
        }

        [TestCase("10", "-10", "0")]
        [TestCase("1000000000", "-9900220000000", "-9899220000000")]
        public void SumSecondNegative(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult, actualResutl);
        }

        [TestCase("h", "10", "error")]
        [TestCase("!", "-9900220000000", "error")]
        public void SumFirstInvalid(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult, actualResutl);
        }

        [TestCase("123", "g", "error")]
        [TestCase("100", "$", "error")]
        public void SumSecondInvalid(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);

            Assert.AreEqual(expectedResult, actualResutl);
        }

        [TestCase("q", "g", "error")]
        [TestCase("@", "$", "error")]
        public void SumBouthInvalid(string first, string second, string expectedResult)
        {
            string actualResutl = summatorApp.SumNumbers(first, second);
            
            Assert.AreEqual(expectedResult, actualResutl);
        }

        [Test]
        public void VeriftCalculateButtonText()
        {
            string actualText = summatorApp.GetCalculateButtonText();

            Assert.AreEqual("Calculate Sum", actualText);
        }




    }
}