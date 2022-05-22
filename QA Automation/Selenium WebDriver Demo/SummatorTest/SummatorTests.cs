using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SummatorTest
{
    public class SummatorTests
    {
        private WebDriver chromeDriver;
        private IWebElement num1;
        private IWebElement num2;
        private IWebElement calculate;
        private IWebElement reset;
        private IWebElement result;
        [SetUp]
        public void Setup()
        {
            chromeDriver = new ChromeDriver();
            chromeDriver.Url = ("https://sum-numbers.nakov.repl.co/");
            chromeDriver.Manage().Window.Maximize();
            num1 = chromeDriver.FindElement(By.Id("number1"));
            num2 = chromeDriver.FindElement(By.Id("number2"));
            calculate = chromeDriver.FindElement(By.Id("calcButton"));
            reset = chromeDriver.FindElement(By.Id("resetButton"));
        }
        // // // // //

        [Test]
        public void Sum_TwoValidPositiveIntegers()
        {
            num1.Click();
            num1.SendKeys("10");
            num2.Click();
            num2.SendKeys("15");
            calculate.Click();
            result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("Sum: 25", result.Text);
        }

        [Test]
        public void Sum_TwoValidNegativeIntegers()
        {
            num1.Click();
            num1.SendKeys("-5");
            num2.Click();
            num2.SendKeys("-5");
            calculate.Click();
            result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("Sum: -10", result.Text);
        }
        [Test]
        public void NumberOneWithInvalidInput()
        {
            num1.Click();
            num1.SendKeys("invalid");
            num2.Click();
            num2.SendKeys("5");
            calculate.Click();
            result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("Sum: invalid input", result.Text);
        }
        [Test]
        public void NumberTwoWithInvalidInput()
        {
            num2.Click();
            num2.SendKeys("invalid");
            num1.Click();
            num1.SendKeys("5");
            calculate.Click();
            IWebElement result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("Sum: invalid input", result.Text);
        }

        [Test]
        public void Sum_EmptyNumbers()
        {
            num1.Click();
            num1.SendKeys("");
            num2.Click();
            num2.SendKeys("");
            calculate.Click();
            IWebElement result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("Sum: invalid input", result.Text);
        }

        [Test]
        public void RessetButton_BeforeSum()
        {
            num1.Click();
            num1.SendKeys("5");
            num2.Click();
            num2.SendKeys("6");
            reset.Click();

            Assert.AreEqual("",num1.GetAttribute("value"));
            Assert.AreEqual("",num2.GetAttribute("value"));
        }

        [Test]
        public void ResetButton_AfterSum()
        {
            num1.Click();
            num1.SendKeys("5");
            num2.Click();
            num2.SendKeys("6");
            calculate.Click();
            result = chromeDriver.FindElement(By.CssSelector("#result"));

            Assert.AreEqual("5",num1.GetAttribute("value"));
            Assert.AreEqual("6", num2.GetAttribute("value"));
            Assert.AreEqual("Sum: 11", result.Text);

            reset.Click();

            Assert.AreEqual("", num1.GetAttribute("value"));
            Assert.AreEqual("", num2.GetAttribute("value"));
            Assert.AreEqual("",result.Text);
        }
        // // // // // //
        [TearDown]
        public void TearDown()
        {
            chromeDriver.Quit();
        }
    }
}