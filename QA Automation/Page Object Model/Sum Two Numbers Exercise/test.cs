using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using POMSumTwoNumbers.Page;

namespace POMSumTwoNumbers
{
    public class Tests
    {
        private IWebDriver driver;
        private HomePage homepage;
        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            homepage = new HomePage(driver);
        }

        [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }

        [TestCase("0", "0", "Sum: 0")]
        [TestCase("100000000", "100000000", "Sum: 200000000")]
        public void SumTwoPositiveNumbers(string firstNum, string secondNum, string expectedResult)
        {
            var actual = homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual(expectedResult,actual);
        }

        [TestCase("-1", "-0", "Sum: -1")]
        [TestCase("-200000000", "-100000000", "Sum: -300000000")]
        public void SumTwoNegativeNumbers(string firstNum, string secondNum, string expectedResult)
        {
            var actual = homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual(expectedResult, actual);
        }

        [TestCase("-1", "1", "Sum: 0")]
        [TestCase("-200000000", "100000000", "Sum: -100000000")]
        public void SumFirstNegativeSecondPositive(string firstNum, string secondNum, string expectedResult)
        {
            var actual = homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual(expectedResult, actual);
        }

        [TestCase("-1", "1", "Sum: 0")]
        [TestCase("-200000000", "100000000", "Sum: -100000000")]
        public void SumSecondNegativeSecondPositive(string firstNum, string secondNum, string expectedResult)
        {
            var actual = homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual(expectedResult, actual);
        }

        [TestCase("ha", "11")]
        [TestCase("$$", "100000000")]
        public void SumFirstInvalidSecondValid(string firstNum, string secondNum)
        {
            homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual("invalid input", homepage.GetErrorMessage());
        }

        [TestCase("14", "we")]
        [TestCase("51", "!")]
        public void SumSecondInvalidSecondValid(string firstNum, string secondNum)
        {
            homepage.SumTwoNumbers(firstNum, secondNum);
            Assert.AreEqual("invalid input", homepage.GetErrorMessage());
        }

        [Test]
        public void TestReset()
        {
            homepage.SumTwoNumbers("5", "10");
            homepage.Reset();
            Assert.AreEqual("",homepage.GetFirstNum());
            Assert.AreEqual("",homepage.GetSecondNum());
        }

        [Test]
        public void VerifyPageTitle()
        {
            Assert.AreEqual("Sum Two Numbers",homepage.GetPageTitle());
        }

        [Test]
        public void VerifyPageHeadingText()
        {
            Assert.AreEqual("Sum Two Numbers", homepage.GetPageHeadingText());
        }



    }
}