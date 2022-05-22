using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Remote;


    public class WikiTests
    {
        private WebDriver driver;

        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
        }
        // // // // // //

        [Test]
        public void Test_Wikipeadi_SearchBoxQa()
        {
            driver.Url = "https://www.wikipedia.org/";
            var searchElement = driver.FindElement(By.Id("searchInput"));
            searchElement.Click();
            searchElement.SendKeys("QA");
            searchElement.SendKeys(Keys.Enter);

            var actualElement = driver.FindElement(By.CssSelector("#firstHeading"));

            Assert.AreEqual("https://en.wikipedia.org/wiki/QA",driver.Url);
            Assert.AreEqual("QA",actualElement.Text);
        }

    // // // // // //
    [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }
    }