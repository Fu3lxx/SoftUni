using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace NumberCalculatorTest
{
    public class Tests
    {
        private WebDriver chromeDriver;
        private IWebElement firstNum;
        private IWebElement secondNum;
        private IWebElement operatorr;
        private IWebElement calculate;
        private IWebElement reset;

        [SetUp]
        public void OnetimeSetup()
        {
            chromeDriver = new ChromeDriver();
            chromeDriver.Manage().Window.Maximize();
            chromeDriver.Url = "https://number-calculator.nakov.repl.co/";
            firstNum = chromeDriver.FindElement(By.Id("number1"));
            secondNum = chromeDriver.FindElement(By.Id("number2"));
            operatorr = chromeDriver.FindElement(By.Id("operation"));
            calculate = chromeDriver.FindElement(By.Id("calcButton"));
            reset = chromeDriver.FindElement(By.Id("resetButton"));
        }

        [TearDown]
        public void OneTimeTearDown()
        {
            chromeDriver.Quit();
        }

        [TestCase("5","10","+", "Result: 15")]
        [TestCase("5.5","10.4","+", "Result: 15.9")]
        [TestCase("-5","-10", "+", "Result: -15")]
        [TestCase("","", "+", "Result: invalid input")]
        [TestCase("hi","hi", "+", "Result: invalid input")]

        [TestCase("5","10","*", "Result: 50")]
        [TestCase("5.5","10.2","*", "Result: 56.1")]
        [TestCase("-5","-10", "*", "Result: 50")]
        [TestCase("","", "*", "Result: invalid input")]
        [TestCase("hi","ha", "*", "Result: invalid input")]

        [TestCase("10","1", "-", "Result: 9")]
        [TestCase("10.1","1.4", "-", "Result: 8.7")]
        [TestCase("-10","-1", "-", "Result: -9")]
        [TestCase("","", "-", "Result: invalid input")]
        [TestCase("ho","ho", "-", "Result: invalid input")]

        [TestCase("4","2", "/", "Result: 2")]
        [TestCase("4.2","2.4", "/", "Result: 1.75")]
        [TestCase("-4","-2", "/", "Result: 2")]
        [TestCase("","", "/", "Result: invalid input")]
        [TestCase("ho","ho", "/", "Result: invalid input")]

        public void TestCalculatorWebApp
        (string num1, string num2, string dropDownOperator, string expectedValue)
        {
            firstNum.Click();
            firstNum.SendKeys(num1);
            secondNum.Click();
            secondNum.SendKeys(num2);

            operatorr.SendKeys(dropDownOperator);
            calculate.Click();
            var result = chromeDriver.FindElement(By.CssSelector("#result"));
            Assert.AreEqual(expectedValue,result.Text);
            reset.Click();
        }
    }
}